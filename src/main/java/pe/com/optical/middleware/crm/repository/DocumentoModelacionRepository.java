package pe.com.optical.middleware.crm.repository;

import java.util.List;

import pe.com.optical.middleware.crm.domain.DocumentoModelacionBE;

public interface DocumentoModelacionRepository extends BaseRepository<DocumentoModelacionBE, Long>  {	
	List<DocumentoModelacionBE> obtenerDocumentosPorModelacion(Long codigoModelacion);
	List<DocumentoModelacionBE> obtenerPorDocumento(Long codigoDocumento);
}
