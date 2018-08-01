package pe.com.optical.middleware.crm.repository;

import java.util.List;

import pe.com.optical.middleware.crm.domain.VentaBE;

public interface VentaRepository extends BaseRepository<VentaBE, Long> {
	 List<VentaBE> obtenerPorDocumento(Long idDocumento);
	 List<VentaBE> obtenerPorCliente(Long idCliente);
}
