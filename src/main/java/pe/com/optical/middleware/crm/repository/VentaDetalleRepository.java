package pe.com.optical.middleware.crm.repository;

import java.util.List;

import pe.com.optical.middleware.crm.domain.VentaDetalleBE;

public interface VentaDetalleRepository extends BaseRepository<VentaDetalleBE, Long> {
	List<VentaDetalleBE> obtenerPorVenta(Long codigoVenta);
}
