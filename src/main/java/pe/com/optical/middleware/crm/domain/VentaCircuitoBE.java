package pe.com.optical.middleware.crm.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CRM_VENTA_CIRCUITO", schema = "crm")
public class VentaCircuitoBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RVCI_CODIGO_VENTA_CIRCUITO", nullable = false)
	private Long id;

	/*@Column(name = "RVCI_COD_VENTA")
	public int codigoVenta;*/

	@Column(name = "RVCI_COD_DIRECCION")
	private int codigoDireccion;

	@Column(name = "RVCI_COD_PLANTILLA")
	private int codigoPlantilla;

	@Column(name = "RVCI_COD_CIRCUITO")
	private int codigoCircuito;

	@Column(name = "RVCV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "RVCD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "RVCV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "RVCD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@ManyToOne(optional = false)
    @JoinColumn(name = "RVCI_COD_VENTA")
	private VentaBE venta;

	/*
	 * public CRM_DIRECCION CRM_DIRECCION;
	 * 
	 * public CRM_PLANTILLA CRM_PLANTILLA;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoDireccion() {
		return codigoDireccion;
	}

	public void setCodigoDireccion(int codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}

	public int getCodigoPlantilla() {
		return codigoPlantilla;
	}

	public void setCodigoPlantilla(int codigoPlantilla) {
		this.codigoPlantilla = codigoPlantilla;
	}

	public int getCodigoCircuito() {
		return codigoCircuito;
	}

	public void setCodigoCircuito(int codigoCircuito) {
		this.codigoCircuito = codigoCircuito;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public VentaBE getVenta() {
		return venta;
	}

	public void setVenta(VentaBE venta) {
		this.venta = venta;
	}	
}
