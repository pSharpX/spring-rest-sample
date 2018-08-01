package pe.com.optical.middleware.crm.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CRM_DOCUMENTO_MODELACION", schema = "crm")
public class DocumentoModelacionBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOMI_COD_DOCUMENTO_MODELACION", nullable = false)
	private Long id;

	// @Column(name = "DOMI_COD_DOCUMENTO")
	// private int codigoDocumento;
	//
	// @Column(name = "DOMI_COD_MODELACION")
	// private int codigoModelacion;

	@Column(name = "DOMI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "DOMV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "DOMD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "DOMV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "DOMD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "DOMI_COD_MODELACION")
	private ModelacionBE modelacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "DOMI_COD_DOCUMENTO")
	private DocumentoBE documento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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

	public DocumentoBE getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoBE documento) {
		this.documento = documento;
	}

	public ModelacionBE getModelacion() {
		return modelacion;
	}

	public void setModelacion(ModelacionBE modelacion) {
		this.modelacion = modelacion;
	}
}
