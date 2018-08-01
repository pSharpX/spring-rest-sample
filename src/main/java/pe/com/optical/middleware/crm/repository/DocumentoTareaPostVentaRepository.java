package pe.com.optical.middleware.crm.repository;

import java.util.List;

import pe.com.optical.middleware.crm.domain.DocumentoTareaPostVentaBE;

public interface DocumentoTareaPostVentaRepository extends BaseRepository<DocumentoTareaPostVentaBE, Long>  {
	List<DocumentoTareaPostVentaBE> obtenerDocumentosPorTareaPostVenta(Long codigoTareaPostVenta);
	List<DocumentoTareaPostVentaBE> obtenerPorDocumento(Long codigoDocumento);
}
