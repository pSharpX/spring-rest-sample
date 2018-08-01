package pe.com.optical.middleware.crm.repository;

import java.util.List;

import pe.com.optical.middleware.crm.domain.TipoBE;

public interface TipoRepository extends BaseRepository<TipoBE, Long> {
	List<TipoBE> obtenerTiposPorConcepto(String codigoConcepto);
	
	List<TipoBE> obtenerTipoMotivosAnulacionTareaPostVenta();
	TipoBE obtenerTipoMotivoAnulacionTareaPostVenta(String codigoEstado);
	
	List<TipoBE> obtenerTipoMotivosCerradoPerdido();
	TipoBE obtenerTipoMotivoCerradoPerdido(String codigoEstado);
	
	List<TipoBE> obtenerEstadosTareaPostVenta();
	TipoBE obtenerEstadoTareaPostVenta(String codigoEstado);
	
	List<TipoBE> obtenerEstadosOportunidades();
	TipoBE obtenerEstadoOportunidad(String codigoEstado);
	
	List<TipoBE> obtenerTipoPeriodos();
	TipoBE obtenerTipoPeriodo(String codigoPeriodo);
	
	List<TipoBE> obtenerEstadosComerciales();
	TipoBE obtenerEstadoComercial(String codigoEstado);
	
	List<TipoBE> obtenerEstadosOperativos();
	TipoBE obtenerEstadoOperativo(String codigoEstado);
	
	List<TipoBE> obtenerEstadosServiciosVentas();
	TipoBE obtenerEstadoServicioVenta(String codigoEstado);
	
	List<TipoBE> obtenerEstadosDocumentos();
	TipoBE obtenerEstadoDocumento(String codigoEstado);
}
