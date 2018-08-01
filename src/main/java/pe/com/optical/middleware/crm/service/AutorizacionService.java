package pe.com.optical.middleware.crm.service;

import pe.com.optical.middleware.crm.dto.DocumentoDto;

public interface AutorizacionService extends BaseService<DocumentoDto, Long> {	
	public DocumentoDto aprobarDocumento(DocumentoDto documentoDto) throws Exception;
}