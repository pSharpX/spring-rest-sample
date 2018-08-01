/*
 * Optical Networks S.A.C. Copyright (c) 2016. All rights reserved. 20/06/2016
 */
package pe.com.optical.middleware.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import pe.com.optical.middleware.auditoria.service.LogService;
import pe.com.optical.middleware.bean.MiddlewareResponseBE;
import pe.com.optical.middleware.controller.impl.OauthValidatorImpl;
import pe.com.optical.middleware.crm.bean.VentaBE;
import pe.com.optical.middleware.crm.service.VentaService;

// TODO: Auto-generated Javadoc
/**
 * The Class VentaController.
 */
@RestController
@RequestMapping("/crm/venta")
public class VentaController extends OauthValidatorImpl {

	/**
	 * 
	 */
	private static final long	serialVersionUID		= -5447526686334156126L;

	/** The Constant LOGGER. */
	private static final Logger	LOGGER					= LoggerFactory.getLogger(VentaController.class);

	// Codigo de transacciones internas
	private static final String	TR_BUSCAR_VENTAS		= "TRINVENB0001";

	private static final String	TR_BUSCAR_VENTA_X_ID	= "TRINVENB0002";

	private static final String	TR_CREAR_VENTA			= "TRINVENC0003";

	private static final String	TR_ACTUALIZAR_VENTA		= "TRINVENA0004";

	private static final String	TR_ELIMINAR_VENTA		= "TRINVENE05";

	/** The venta service. */
	@Autowired
	private VentaService		ventaService;

	/** The log service. */
	@Autowired
	private LogService			logService;

	/**
	 * Buscar por id.
	 *
	 * @param id
	 *            the id
	 * @param httpServletRequest
	 *            the http servlet request
	 * @return the middleware response be
	 */
	@RequestMapping(value = "/buscarPorId", method = RequestMethod.GET)
	public MiddlewareResponseBE buscarPorId(@RequestParam(value = "id", defaultValue = "0") int id, HttpServletRequest httpServletRequest) {

		LOGGER.info("buscarPorId");

		MiddlewareResponseBE middlewareResponseBE;

		if (validarPermiso(httpServletRequest.getRemoteUser(), httpServletRequest.getRequestURI(), httpServletRequest.getRemoteHost())) {
			try {
				if (id > 0) {
					LOGGER.info("buscarPorId.id: " + id);
					LOGGER.info("access-token:{} - id:{}", httpServletRequest.getParameterMap().get("access_token"), id);
					VentaBE ventaBE = this.ventaService.buscarPorId(id);
					// Registro de auditoria
					logService.crearLogInterno(TR_BUSCAR_VENTA_X_ID, httpServletRequest.getRemoteUser(), String.valueOf(id), httpServletRequest.getRemoteHost(),
							httpServletRequest.getRequestURI());
					middlewareResponseBE = new MiddlewareResponseBE();
					if (ventaBE == null) {
						middlewareResponseBE.setEstado(ESTADO_400);
						middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
						middlewareResponseBE.setDescripcion("No existe ninguna venta con el identificador: " + id);
						LOGGER.info("No existe ninguna venta con el identificador: " + id);
					} else {
						middlewareResponseBE.setEstado(ESTADO_200);
						middlewareResponseBE.setMensaje(ESTADO_200_MENSAJE);
					}
					Map<String, Object> data = new HashMap<>();
					data.put("venta", ventaBE);
					middlewareResponseBE.setData(data);

				} else {
					middlewareResponseBE = new MiddlewareResponseBE();
					middlewareResponseBE.setEstado(ESTADO_400);
					middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
					middlewareResponseBE.setDescripcion("El identificador de la venta no es valido.");
					middlewareResponseBE.setData(null);
					LOGGER.info("El identificador de la venta no es valido.");
				}
			} catch (Exception e) {
				middlewareResponseBE = new MiddlewareResponseBE();
				middlewareResponseBE.setEstado(ESTADO_500);
				middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
				middlewareResponseBE.setData(null);
				e.printStackTrace();
			}
		} else {
			middlewareResponseBE = new MiddlewareResponseBE();
			middlewareResponseBE.setEstado(ESTADO_400);
			middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
			middlewareResponseBE.setDescripcion("No tiene permisos para consumir el servicio web.");
			middlewareResponseBE.setData(null);
			LOGGER.info("No tiene permisos para consumir el servicio web.");
		}

		return middlewareResponseBE;
	}

	/**
	 * Buscar.
	 *
	 * @param clientId
	 *            the client id
	 * @param httpServletRequest
	 *            the http servlet request
	 * @return the middleware response be
	 */
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public MiddlewareResponseBE buscar(HttpServletRequest httpServletRequest) {

		LOGGER.info("access-token:{} - buscar", httpServletRequest.getParameterMap().get("access_token"), EMPTY_STRING);

		MiddlewareResponseBE middlewareResponseBE;

		if (validarPermiso(httpServletRequest.getRemoteUser(), httpServletRequest.getRequestURI(), httpServletRequest.getRemoteHost())) {
			try {

				List<VentaBE> lstVenta = this.ventaService.buscar();
				// Registro de auditoria
				logService.crearLogInterno(TR_BUSCAR_VENTAS, httpServletRequest.getRemoteUser(), null, httpServletRequest.getRemoteHost(),
						httpServletRequest.getRequestURI());
				middlewareResponseBE = new MiddlewareResponseBE();
				if (lstVenta == null) {
					middlewareResponseBE.setEstado(ESTADO_400);
					middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
					middlewareResponseBE.setMensaje("No se ha encontrado ninguna venta.");
					LOGGER.info("No se ha encontrado ninguna venta.");
				} else {
					middlewareResponseBE.setEstado(ESTADO_200);
					middlewareResponseBE.setMensaje(ESTADO_200_MENSAJE);
				}

				Map<String, Object> data = new HashMap<>();
				data.put("ventas", lstVenta);
				middlewareResponseBE.setData(data);

			} catch (Exception e) {
				e.printStackTrace();
				middlewareResponseBE = new MiddlewareResponseBE();
				middlewareResponseBE.setEstado(ESTADO_500);
				middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
				middlewareResponseBE.setData(null);
			}
		} else {
			middlewareResponseBE = new MiddlewareResponseBE();
			middlewareResponseBE.setEstado(ESTADO_400);
			middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
			middlewareResponseBE.setDescripcion("No tiene permisos para consumir el servicio web.");
			middlewareResponseBE.setData(null);
			LOGGER.info("No tiene permisos para consumir el servicio web.");
		}

		return middlewareResponseBE;
	}

	/**
	 * Crear.
	 *
	 * @param data
	 *            the data
	 * @param clientId
	 *            the client id
	 * @param httpServletRequest
	 *            the http servlet request
	 * @return the middleware response be
	 */
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public MiddlewareResponseBE crear(@RequestParam(value = "data", defaultValue = "") String data, HttpServletRequest httpServletRequest) {

		LOGGER.info("access-token:{} - crear.data:{}", httpServletRequest.getParameterMap().get("access_token"), data);

		MiddlewareResponseBE middlewareResponseBE;
		try {

			middlewareResponseBE = new MiddlewareResponseBE();
			if (data.trim().equals(EMPTY_STRING)) {
				middlewareResponseBE.setEstado(ESTADO_400);
				middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
				middlewareResponseBE.setMensaje("Por favor de enviar la información correcta en el formato establecido.");
			} else {
				Gson gson = new Gson();
				VentaBE ventaBE = gson.fromJson(data.trim(), VentaBE.class);
				LOGGER.info(ventaBE.toString());
				if (this.ventaService.crear(ventaBE) > 0) {

					if (validarPermiso(httpServletRequest.getRemoteUser(), httpServletRequest.getRequestURI(), httpServletRequest.getRemoteHost())) {
						// Registro de auditoria
						logService.crearLogInterno(TR_CREAR_VENTA, httpServletRequest.getRemoteUser(), data, httpServletRequest.getRemoteHost(),
								httpServletRequest.getRequestURI());

						middlewareResponseBE.setEstado(ESTADO_201);
						middlewareResponseBE.setMensaje(ESTADO_201_MENSAJE);
						middlewareResponseBE.setDescripcion("La venta se ha registrado exitosamente.");
						LOGGER.info("La venta se ha registrado exitosamente.");
					} else {
						middlewareResponseBE.setEstado(ESTADO_400);
						middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
						middlewareResponseBE.setDescripcion("No tiene permisos para consumir el servicio web.");
						middlewareResponseBE.setData(null);
						LOGGER.info("No tiene permisos para consumir el servicio web.");
					}

				} else {
					middlewareResponseBE.setEstado(ESTADO_500);
					middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
					middlewareResponseBE.setDescripcion("No se ha logrado insertar la venta.");
					LOGGER.info("No se ha logrado insertar la venta.");
				}

			}

		} catch (Exception e) {
			middlewareResponseBE = new MiddlewareResponseBE();
			middlewareResponseBE.setEstado(ESTADO_500);
			middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
			middlewareResponseBE.setDescripcion("La información a registrar no tiene el formato correcto.");
			middlewareResponseBE.setData(null);
		}

		return middlewareResponseBE;
	}

	/**
	 * Eliminar.
	 *
	 * @param id
	 *            the id
	 * @param clientId
	 *            the client id
	 * @param httpServletRequest
	 *            the http servlet request
	 * @return the middleware response be
	 */
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public MiddlewareResponseBE eliminar(@RequestParam(value = "id", defaultValue = "0") int id, HttpServletRequest httpServletRequest) {

		LOGGER.info("access-token:{} - eliminar.id:{}", httpServletRequest.getParameterMap().get("access_token"), id);

		MiddlewareResponseBE middlewareResponseBE;

		if (validarPermiso(httpServletRequest.getRemoteUser(), httpServletRequest.getRequestURI(), httpServletRequest.getRemoteHost())) {
			try {
				if (id > 0) {

					VentaBE ventaBE = this.ventaService.buscarPorId(id);
					// Registro de auditoria
					logService.crearLogInterno(TR_BUSCAR_VENTA_X_ID, httpServletRequest.getRemoteUser(), String.valueOf(id), httpServletRequest.getRemoteHost(),
							httpServletRequest.getRequestURI());

					middlewareResponseBE = new MiddlewareResponseBE();
					if (ventaBE == null) {
						middlewareResponseBE.setEstado(ESTADO_400);
						middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
						middlewareResponseBE.setDescripcion("La venta con identificador: " + id + " no existe.");
						LOGGER.info("La venta con identificador: " + id + " no existe.");
					} else {
						this.ventaService.eliminar(ventaBE.getId());
						// Registro de auditoria
						logService.crearLogInterno(TR_ELIMINAR_VENTA, httpServletRequest.getRemoteUser(), String.valueOf(id),
								httpServletRequest.getRemoteHost(), httpServletRequest.getRequestURI());

						middlewareResponseBE.setEstado(ESTADO_200);
						middlewareResponseBE.setMensaje(ESTADO_200_MENSAJE);
						middlewareResponseBE.setDescripcion("Se ha eliminado exitosamente la venta con id: " + ventaBE.getId());
						LOGGER.info("Se ha eliminado exitosamente la venta con id: " + ventaBE.getId());
					}
				} else {
					middlewareResponseBE = new MiddlewareResponseBE();
					middlewareResponseBE.setEstado(ESTADO_400);
					middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
					middlewareResponseBE.setDescripcion("El identificador de la venta no es valido.");
					middlewareResponseBE.setData(null);
					LOGGER.info("El identificador de la venta no es valido.");
				}
			} catch (Exception e) {
				middlewareResponseBE = new MiddlewareResponseBE();
				middlewareResponseBE.setEstado(ESTADO_500);
				middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
				middlewareResponseBE.setData(null);
			}
		} else {
			middlewareResponseBE = new MiddlewareResponseBE();
			middlewareResponseBE.setEstado(ESTADO_400);
			middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
			middlewareResponseBE.setDescripcion("No tiene permisos para consumir el servicio web.");
			middlewareResponseBE.setData(null);
			LOGGER.info("No tiene permisos para consumir el servicio web.");
		}

		return middlewareResponseBE;
	}

	/**
	 * Actualizar.
	 *
	 * @param data
	 *            the data
	 * @param clientId
	 *            the client id
	 * @param httpServletRequest
	 *            the http servlet request
	 * @return the middleware response be
	 */
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public MiddlewareResponseBE actualizar(@RequestParam(value = "data", defaultValue = "") String data, HttpServletRequest httpServletRequest) {

		LOGGER.info("access-token:{} - actualizar.data:{}", httpServletRequest.getParameterMap().get("access_token"), data);
		MiddlewareResponseBE middlewareResponseBE;
		try {

			middlewareResponseBE = new MiddlewareResponseBE();
			if (data.trim().equals(EMPTY_STRING)) {
				middlewareResponseBE.setEstado(ESTADO_400);
				middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
				middlewareResponseBE.setMensaje("Por favor de enviar la información correcta en el formato establecido.");
			} else {
				Gson gson = new Gson();
				VentaBE ventaBE = gson.fromJson(data.trim(), VentaBE.class);
				LOGGER.info(ventaBE.toString());
				if (this.ventaService.actualizar(ventaBE) > 0) {

					if (validarPermiso(httpServletRequest.getRemoteUser(), httpServletRequest.getRequestURI(), httpServletRequest.getRemoteHost())) {
						// Registro de auditoria
						logService.crearLogInterno(TR_ACTUALIZAR_VENTA, httpServletRequest.getRemoteUser(), data, httpServletRequest.getRemoteHost(),
								httpServletRequest.getRequestURI());

						middlewareResponseBE.setEstado(ESTADO_200);
						middlewareResponseBE.setMensaje(ESTADO_200_MENSAJE);
						middlewareResponseBE.setDescripcion("La venta se actualizó exitosamente.");
						LOGGER.info("La venta se actualizó exitosamente.");
					} else {
						middlewareResponseBE = new MiddlewareResponseBE();
						middlewareResponseBE.setEstado(ESTADO_400);
						middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
						middlewareResponseBE.setDescripcion("No tiene permisos para consumir el servicio web.");
						middlewareResponseBE.setData(null);
						LOGGER.info("No tiene permisos para consumir el servicio web.");
					}

				} else {
					middlewareResponseBE.setEstado(ESTADO_500);
					middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
					middlewareResponseBE.setDescripcion("No se ha logrado actualizar la venta.");
					LOGGER.info("No se ha logrado actualizar la venta.");
				}

			}

		} catch (Exception e) {
			middlewareResponseBE = new MiddlewareResponseBE();
			middlewareResponseBE.setEstado(ESTADO_500);
			middlewareResponseBE.setMensaje(ESTADO_500_MENSAJE);
			middlewareResponseBE.setDescripcion("La información a registrar no tiene el formato correcto.");
			middlewareResponseBE.setData(null);
		}
		return middlewareResponseBE;
	}

}
