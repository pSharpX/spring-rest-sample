package pe.com.optical.middleware.crm.repository;


import pe.com.optical.middleware.crm.domain.VentaCircuitoBE;

public interface VentaCircuitoRepository extends BaseRepository<VentaCircuitoBE, Long> {
	VentaCircuitoBE obtenerPorCodigoCircuito(Long codigoCircuito);
}
