package pe.com.optical.middleware.crm.service.facade.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.com.optical.middleware.crm.application.annotation.BusinessService;
import pe.com.optical.middleware.crm.domain.DocumentoBE;
import pe.com.optical.middleware.crm.domain.DocumentoModelacionBE;
import pe.com.optical.middleware.crm.domain.DocumentoTareaPostVentaBE;
import pe.com.optical.middleware.crm.domain.OportunidadBE;
import pe.com.optical.middleware.crm.domain.TareaPostVentaBE;
import pe.com.optical.middleware.crm.domain.TipoBE;
import pe.com.optical.middleware.crm.domain.VentaBE;
import pe.com.optical.middleware.crm.domain.VentaCircuitoBE;
import pe.com.optical.middleware.crm.domain.VentaDetalleBE;
import pe.com.optical.middleware.crm.dto.EstadoCircuitoDto;
import pe.com.optical.middleware.crm.dto.ServicioDto;
import pe.com.optical.middleware.crm.repository.DocumentoModelacionRepository;
import pe.com.optical.middleware.crm.repository.DocumentoRepository;
import pe.com.optical.middleware.crm.repository.DocumentoTareaPostVentaRepository;
import pe.com.optical.middleware.crm.repository.OportunidadRepository;
import pe.com.optical.middleware.crm.repository.TareaPostVentaRepository;
import pe.com.optical.middleware.crm.repository.TipoRepository;
import pe.com.optical.middleware.crm.repository.VentaCircuitoRepository;
import pe.com.optical.middleware.crm.repository.VentaDetalleRepository;
import pe.com.optical.middleware.crm.repository.VentaRepository;
import pe.com.optical.middleware.crm.service.facade.ServicioServiceFacade;
import pe.com.optical.middleware.crm.util.LocalDateUtils;

@BusinessService
@Transactional("jpaTransactionManager")
public class ServicioServiceFacadeImpl implements ServicioServiceFacade {
		
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private VentaDetalleRepository ventaDetalleRepository;
	@Autowired
	private VentaCircuitoRepository ventaCircuitoRepository;
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private OportunidadRepository oportunidadRepository;
	@Autowired
	private TareaPostVentaRepository tareaPostVentaRepository;
	@Autowired
	private DocumentoModelacionRepository documentoModelacionRespository;
	@Autowired
	private DocumentoTareaPostVentaRepository documentoTareaPostVentaRepository;
	
	@Override
	public void actualizarServicio(ServicioDto servicioDto) {		
		actualizarAServicioActivoSinConformidad(servicioDto);
		actualizarAServicioSuspendidoBaja(servicioDto);
		actualizarAServicioEliminado(servicioDto);
	}
	
	@Override
	public void actualizarAServicioActivo(EstadoCircuitoDto estadoCircuitoDto) {		
		estadoCircuitoDto = Objects.requireNonNull(estadoCircuitoDto, "estadoCircuito cannot be null");
		String estadoActivo = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_ACTIVO;
		if(estadoActivo.equals(estadoCircuitoDto.getCodigoEstado())) {
		}
	}

	@Override
	public void actualizarAServicioSuspendidoBaja(EstadoCircuitoDto estadoCircuitoDto) {
		Objects.requireNonNull(estadoCircuitoDto, "estadoCircuito cannot be null");			
		final String estadoBaja = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_BAJA;
		final String estadoSuspendidoFaltaPago = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_SUSPENDIDO_FALTA_PAGO;
		final String estadoSuspendidoSolicitudCliente = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_SUSPENDIDO_SOLICITUD_CLIENTE;
		if(Arrays.asList(estadoBaja, estadoSuspendidoFaltaPago, estadoSuspendidoSolicitudCliente).contains(estadoCircuitoDto.getCodigoEstado())) {
			VentaCircuitoBE ventaCircuitoBE = this.ventaCircuitoRepository.obtenerPorCodigoCircuito((long) estadoCircuitoDto.getNumeroCircuito());
			VentaBE ventaBE = ventaCircuitoBE.getVenta();
			TipoBE estadoOperativoBaja = this.tipoRepository.obtenerEstadoDocumento(TipoBE.CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_BAJA);
			TipoBE estadoOperativoSuspendido = this.tipoRepository.obtenerEstadoDocumento(TipoBE.CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_SUSPENDIDO);
			if(Arrays.asList(estadoSuspendidoFaltaPago, estadoSuspendidoSolicitudCliente).contains(estadoCircuitoDto.getCodigoEstado())) {
				ventaBE.setTipoEstadoOperaciones(estadoOperativoSuspendido);
			}else if(estadoBaja.equals(estadoCircuitoDto.getCodigoEstado())) {
				ventaBE.setTipoEstadoOperaciones(estadoOperativoBaja);
			}
			this.ventaRepository.actualizar(ventaBE);
		}
	}

	@Override
	public void actualizarAServicioEliminado(EstadoCircuitoDto estadoCircuitoDto) {
		Objects.requireNonNull(estadoCircuitoDto, "estadoCircuito cannot be null");
		String estadoEliminado = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_ELIMINADO;
		if(estadoEliminado.equals(estadoCircuitoDto.getCodigoEstado())) {
			VentaCircuitoBE ventaCircuitoBE = this.ventaCircuitoRepository.obtenerPorCodigoCircuito((long) estadoCircuitoDto.getNumeroCircuito());
			VentaBE ventaBE = ventaCircuitoBE.getVenta();
			DocumentoBE documentoBE = ventaBE.getDocumento();
			List<VentaDetalleBE> ventaDetallesBE = this.ventaDetalleRepository.obtenerPorVenta((long)ventaBE.getId());
			ventaDetallesBE.stream().forEach((VentaDetalleBE detalle) -> {
				detalle.setEstadoRegistro(TipoBE.CONST_CRM_AUDITORIA_ESTADO_INACTIVO);
			});
			ventaBE.setEstadoRegistro(TipoBE.CONST_CRM_AUDITORIA_ESTADO_INACTIVO);
			List<VentaBE> ventasBE = this.ventaRepository.obtenerPorDocumento(documentoBE.getId());
			List<VentaBE> ventasRestantes = ventasBE.stream().filter((v) -> !v.getId().equals(ventaBE.getId())).collect(Collectors.toList());
			if(ventasRestantes.size() > 0) {
				double totalRecurrente = ventasRestantes.stream().mapToDouble((v) -> v.getTotalRecurrente()).sum();
				double totalNoRecurrente = ventasRestantes.stream().mapToDouble((v) -> v.getTotalNoRecurrente()).sum();
				documentoBE.setRecurrente(totalRecurrente);
				documentoBE.setNoRecurrente(totalNoRecurrente);
			}else {
				TipoBE estadoDocumentadoAnulado = this.tipoRepository.obtenerEstadoDocumento(TipoBE.CONST_CRM_TIPO_DOCUMENTO_ESTADO_ANULADO);
				documentoBE.setTipoEstado(estadoDocumentadoAnulado);
				List<DocumentoModelacionBE> documentosModelacionBE = this.documentoModelacionRespository.obtenerPorDocumento(documentoBE.getId());
				List<DocumentoTareaPostVentaBE> documentosTareaPostVentaBE = this.documentoTareaPostVentaRepository.obtenerPorDocumento(documentoBE.getId());
				if(!documentosModelacionBE.isEmpty()) {
					documentosModelacionBE.stream().findFirst().ifPresent((dm) -> {
						OportunidadBE oportunidadBE = dm.getModelacion().getOportunidad();
						TipoBE estadoOportunidadCerradoPerdido = this.tipoRepository.obtenerEstadoOportunidad(TipoBE.CONST_CRM_TIPO_OPORTUNIDAD_ESTADO_CERRADO_PERDIDO);
						TipoBE motivoCerradoPerdidoEliminacionServicio = this.tipoRepository.obtenerTipoMotivoCerradoPerdido(TipoBE.CONST_CRM_TIPO_OPORTUNIDAD_MOTIVO_CERRADO_PERDIDO_ELIMINACION_SERVICIO);
						oportunidadBE.setTipoEtapa(estadoOportunidadCerradoPerdido);
						oportunidadBE.setTipoMotivoPerdido(motivoCerradoPerdidoEliminacionServicio);
						this.oportunidadRepository.actualizar(oportunidadBE);
					});
				}else if(!documentosTareaPostVentaBE.isEmpty()) {
					documentosTareaPostVentaBE.stream().findFirst().ifPresent((dt) -> {
						TareaPostVentaBE tareaPostVentaBE = dt.getTareaPostVenta();
						TipoBE estadoTareaPostVentaAnulado = this.tipoRepository.obtenerEstadoTareaPostVenta(TipoBE.CONST_CRM_TIPO_TPV_ESTADO_ANULADO);
						TipoBE motivoAnulacionEliminacionServicio = this.tipoRepository.obtenerTipoMotivoAnulacionTareaPostVenta(TipoBE.CONST_CRM_TIPO_TPV_MOTIVO_ANULACION_ELIMINACION_SERVICIO);
						tareaPostVentaBE.setTipoEstadoComercial(estadoTareaPostVentaAnulado);
						tareaPostVentaBE.setTipoMotivoAnulacion(motivoAnulacionEliminacionServicio);
						this.tareaPostVentaRepository.actualizar(tareaPostVentaBE);
					});
				}
			}
			ventaBE.setVentaDetalles(ventaDetallesBE);
			this.ventaRepository.actualizar(ventaBE);
			this.documentoRepository.actualizar(documentoBE);
		}
	}
	
	@Override
	public void actualizarAServicioActivoSinConformidad(final EstadoCircuitoDto estadoCircuitoDto) {
		Objects.requireNonNull(estadoCircuitoDto, "estadoCircuito cannot be null");
		String estadoSinConfirmidad = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_SIN_CONFORMIDAD;
		String estadoActivo = TipoBE.CONST_INTRANET_CIRCUITO_ESTADO_ACTIVO;
		if(Arrays.asList(estadoSinConfirmidad, estadoActivo).contains(estadoCircuitoDto.getCodigoEstado())) {
//		if(estadoSinConfirmidad.equals(estadoCircuitoDto.getCodigoEstado())) {
			VentaCircuitoBE ventaCircuitoBE = this.ventaCircuitoRepository.obtenerPorCodigoCircuito((long) estadoCircuitoDto.getNumeroCircuito());
			ventaCircuitoBE = Objects.requireNonNull(ventaCircuitoBE, "ventaCircuitoBE cannot be null");
			DocumentoBE documentoBE = this.documentoRepository.buscar(ventaCircuitoBE.getVenta().getDocumento().getId());
			documentoBE = Objects.requireNonNull(documentoBE, "documentoBE cannot be null");
			TipoBE estadoDocumentadoRegistrado = this.tipoRepository.obtenerEstadoDocumento(TipoBE.CONST_CRM_TIPO_DOCUMENTO_ESTADO_REGISTRADO);
			if(estadoDocumentadoRegistrado.getId().equals(documentoBE.getTipoEstado().getId())) {
				VentaBE ventaBE = ventaCircuitoBE.getVenta();
				TipoBE estadoDocumentadoVigente = this.tipoRepository.obtenerEstadoDocumento(TipoBE.CONST_CRM_TIPO_DOCUMENTO_ESTADO_VIGENTE);

				TipoBE estadoComercialActivo = this.tipoRepository.obtenerEstadoComercial(TipoBE.CONST_CRM_TIPO_SERVICIO_ESTADO_COMERCIAL_ACTIVO);
				TipoBE estadoOperativoActivo = this.tipoRepository.obtenerEstadoOperativo(TipoBE.CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_ACTIVO);

				Function<DocumentoBE, DocumentoBE> calcularPlazoContratacion = (DocumentoBE documento) -> {
					int plazoContratacion = documento.getPlazo();
					TipoBE tipoPeriodo = documento.getTipoPeriodo();
					TipoBE tipoPeriodoDias = this.tipoRepository.obtenerTipoPeriodo(TipoBE.CONST_CRM_TIPO_DOCUMENTO_PERIODO_DIAS);
					TipoBE tipoPeriodoMeses = this.tipoRepository.obtenerTipoPeriodo(TipoBE.CONST_CRM_TIPO_DOCUMENTO_PERIODO_MESES);
					Date fechaInicio = estadoCircuitoDto.getFechaEjecucion();
					Date fechaFin = null;
					if(tipoPeriodoDias.getId().equals(tipoPeriodo.getId())) {
						fechaFin = LocalDateUtils.agregarDias(fechaInicio, plazoContratacion);
					}else if(tipoPeriodoMeses.getId().equals(tipoPeriodo.getId())) {
						fechaFin = LocalDateUtils.agregarMeses(fechaInicio, plazoContratacion);
					}
					documento.setFechaInicio(LocalDateUtils.asSqlDate(fechaInicio));
					documento.setFechaFin(LocalDateUtils.asSqlDate(fechaFin));
					return documento;
				};
				
				documentoBE = calcularPlazoContratacion.apply(documentoBE);
				documentoBE.setTipoEstado(estadoDocumentadoVigente);
				ventaBE.setTipoEstadoComercial(estadoComercialActivo);
				ventaBE.setTipoEstadoOperaciones(estadoOperativoActivo);
				ventaBE.setFechaAlta(LocalDateUtils.asSqlDate(estadoCircuitoDto.getFechaEjecucion()));
				this.documentoRepository.actualizar(documentoBE);
				this.ventaRepository.actualizar(ventaBE);
			}
		}
	}
}
