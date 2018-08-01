package pe.com.optical.middleware.crm.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pe.com.optical.middleware.crm.domain.composite.DocumentoTareaPostVentaId;

@Entity
@Table(name = "CRM_DOCUMENTO_TAREA_POST_VENTA", schema = "crm")
@IdClass(DocumentoTareaPostVentaId.class)
public class DocumentoTareaPostVentaBE {

	@Column(name = "DTPV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "DTPD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "DTPV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "DTPD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Id
	@ManyToOne
	@JoinColumn(name="DTPI_COD_DOCUMENTO")	
	private DocumentoBE documento;
	
	@Id
	@ManyToOne
	@JoinColumn(name="DTPI_COD_TAREA")
	private TareaPostVentaBE tareaPostVenta;

	
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

	public DocumentoBE getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoBE documento) {
		this.documento = documento;
	}

	public TareaPostVentaBE getTareaPostVenta() {
		return tareaPostVenta;
	}

	public void setTareaPostVenta(TareaPostVentaBE tareaPostVenta) {
		this.tareaPostVenta = tareaPostVenta;
	}
	
}
