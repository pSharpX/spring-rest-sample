package pe.com.optical.middleware.crm.service.facade;

import pe.com.optical.middleware.crm.dto.EstadoCircuitoDto;
import pe.com.optical.middleware.crm.dto.ServicioDto;

public interface ServicioServiceFacade {	
	void actualizarServicio(ServicioDto servicioDto);
	void actualizarAServicioActivo(EstadoCircuitoDto estadoCircuitoDto);
	void actualizarAServicioActivoSinConformidad(EstadoCircuitoDto estadoCircuitoDto);
	void actualizarAServicioSuspendidoBaja(EstadoCircuitoDto estadoCircuitoDto);
	void actualizarAServicioEliminado(EstadoCircuitoDto estadoCircuitoDto);
}
