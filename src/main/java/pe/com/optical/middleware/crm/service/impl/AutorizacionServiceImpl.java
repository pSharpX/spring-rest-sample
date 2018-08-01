package pe.com.optical.middleware.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pe.com.optical.middleware.bean.MiddlewareResponseBE;
import pe.com.optical.middleware.crm.dto.DocumentoDto;
import pe.com.optical.middleware.crm.service.AutorizacionService;
import pe.com.optical.middleware.crm.service.VentaService;
import pe.com.optical.middleware.util.Constantes;

@Service
public class AutorizacionServiceImpl implements AutorizacionService {
	
private static final Logger LOGGER = LoggerFactory.getLogger(VentaService.class);
	
	@Autowired
	private RestTemplate cliente;
	
	public DocumentoDto aprobarDocumento(DocumentoDto documentoDto) throws Exception {
		LOGGER.info("Procesando aprobacion de documento.");
		final String uri = "http://localhost/CRM/api/Autorizacion/aprobarDocumento";	    
		MiddlewareResponseBE oRespuesta = cliente.postForObject( uri, documentoDto, MiddlewareResponseBE.class);
		String estado = oRespuesta.getEstado();
		Map<String, Object> data = oRespuesta.getData();		
		documentoDto = (DocumentoDto) data.get("documento");
		if(estado == Constantes.ESTADO_200) {			
			data = oRespuesta.getData();
			documentoDto = (DocumentoDto) data.get("documento");
		}else if(oRespuesta.getEstado() == Constantes.ESTADO_400) {
			throw new Exception(String.format("%s - %s", Constantes.ESTADO_400_MENSAJE, oRespuesta.getMensaje()));
		}else if(oRespuesta.getEstado() == Constantes.ESTADO_500) {
			throw new Exception(String.format("%s - %s", Constantes.ESTADO_500_MENSAJE, oRespuesta.getMensaje()));
		}
		return documentoDto;
	}

	@Override
	public DocumentoDto buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentoDto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(DocumentoDto object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(DocumentoDto object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(DocumentoDto object) {
		// TODO Auto-generated method stub
		
	}
}
