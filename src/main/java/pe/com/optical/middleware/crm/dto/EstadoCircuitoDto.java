package pe.com.optical.middleware.crm.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstadoCircuitoDto {
	
	private int numeroCircuito;
	private String estadoDescripcion;
	private String codigoEstado;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaEjecucion;
	private String usuario;
		
	public EstadoCircuitoDto() {
		super();
	}
	
	public EstadoCircuitoDto(int numeroCircuito, String estadoDescripcion, String codigoEstado, Date fechaEjecucion,
			String usuario) {
		super();
		this.numeroCircuito = numeroCircuito;
		this.estadoDescripcion = estadoDescripcion;
		this.codigoEstado = codigoEstado;
		this.fechaEjecucion = fechaEjecucion;
		this.usuario = usuario;
	}
	
	public int getNumeroCircuito() {
		return numeroCircuito;
	}
	public void setNumeroCircuito(int numeroCircuito) {
		this.numeroCircuito = numeroCircuito;
	}
	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}
	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}
	public String getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
