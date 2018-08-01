package pe.com.optical.middleware.crm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import pe.com.optical.middleware.auditoria.service.LogService;
import pe.com.optical.middleware.bean.MiddlewareResponseBE;
import pe.com.optical.middleware.controller.impl.OauthValidatorImpl;
import pe.com.optical.middleware.crm.dto.ServicioDto;
import pe.com.optical.middleware.crm.service.facade.ServicioServiceFacade;

@RestController
@RequestMapping("/crm/servicio")
public class ServicioController extends OauthValidatorImpl {

	private static final long serialVersionUID = -6093604202691106109L;
	
	private static final Logger	LOGGER = LoggerFactory.getLogger(ServicioController.class);
	
	//@Autowired
	//private LogService logService;
	
	@Autowired
	private ServicioServiceFacade servicioServiceFacade;
	
	@RequestMapping(value = "/actualizarCircuito", method = RequestMethod.POST)
	public MiddlewareResponseBE aprobarDocumento(@RequestBody ServicioDto servicioDto, HttpServletRequest httpServletRequest) {
		LOGGER.info("access-token:{} - actualizarCircuito", httpServletRequest.getParameterMap().get("access_token"), EMPTY_STRING);
		MiddlewareResponseBE middlewareResponseBE;

		if (validarPermiso(httpServletRequest.getRemoteUser(), httpServletRequest.getRequestURI(), httpServletRequest.getRemoteHost())) {
			try {
				servicioServiceFacade.actualizarServicio(servicioDto);
				
				/*logService.crearLogInterno(TR_BUSCAR_VENTAS, httpServletRequest.getRemoteUser(), null, httpServletRequest.getRemoteHost(),
						httpServletRequest.getRequestURI());*/
				middlewareResponseBE = new MiddlewareResponseBE();
				if (servicioDto == null) {
					middlewareResponseBE.setEstado(ESTADO_400);
					middlewareResponseBE.setMensaje(ESTADO_400_MENSAJE);
					middlewareResponseBE.setMensaje("No se procesó correctamente.");
					LOGGER.info("se procesó correctamente.");
				} else {
					middlewareResponseBE.setEstado(ESTADO_200);
					middlewareResponseBE.setMensaje(ESTADO_200_MENSAJE);
				}

				Map<String, Object> data = new HashMap<>();
				data.put("circuito", servicioDto);
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

}
