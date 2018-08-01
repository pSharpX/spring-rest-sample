package pe.com.optical.middleware.crm.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CRM_MODELACION", schema = "crm")
public class ModelacionBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODI_COD_MODELACION", nullable = false)
	private Long id;

	@Column(name = "MODV_CODIGO_MODELACION", nullable = false)
	@NotNull
	@Size(max = 30)
	private String codigoModelacion;

	// @Column(name = "MODI_COD_CLIENTE")
	// public int codigoCliente;
	//
	// @Column(name = "MODI_COD_OPORTUNIDAD")
	// public int codigoOportunidad;

	@Column(name = "MODI_COD_TIPO_ESTADO")
	private int codigoTipoEstado;

	@Column(name = "MODI_COD_TIPO_MONEDA")
	private int codigoTipoMoneda;

	@Column(name = "MODN_TOTAL_NO_RECURRENTE")
	private double totalNoRecurrente;

	@Column(name = "MODN_TOTAL_NO_RECURRENTE_IGV")
	private double totalNoRecurrenteIGV;

	@Column(name = "MODN_TOTAL_RECURRENTE")
	private double totalRecurrente;

	@Column(name = "MODN_TOTAL_RECURRENTE_IGV")
	private double totalRecurrenteIGV;

	@Column(name = "MODI_PLAZO")
	private int plazo;

	@Column(name = "MODI_COD_TIPO_PERIODO")
	private int codigoTipoPeriodo;

	@Column(name = "MODI_VALIDEZ_OFERTA")
	private int validezOferta;

	@Column(name = "MODB_PROBABLE")
	private boolean probable;

	@Column(name = "MODB_ACEPTACION")
	private boolean aceptacion;

	@Column(name = "MODV_DESCRIPCION", nullable = false)
	@NotNull
	@Size(max = 2000)
	private String descripcion;

	@Column(name = "MODI_COD_TCAMBIO")
	private Integer codigoTipoCambio;

	@Column(name = "MODI_PLAZO_INSTALACION")
	private int plazoInstalacion;

	@Column(name = "MODI_HOLD_FACTURACION")
	private int holdFacturacion;

	@Column(name = "MODI_COD_CONTACTO")
	private Integer codigoContacto;
	
	@Column(name = "MODI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "MODV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "MODD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "MODV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "MODD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "MODI_COD_CLIENTE")
	private ClienteBE cliente;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "MODI_COD_OPORTUNIDAD")
	private OportunidadBE oportunidad;
	
	@OneToMany(mappedBy = "modelacion", fetch = FetchType.LAZY)
	private List<DocumentoModelacionBE> documentosModelacion;


	// public ICollection<CRM_AUTORIZACION_MODELACION> CRM_AUTORIZACION_MODELACION;
	//
	// public virtual CRM_CONTACTO CRM_CONTACTO;
	//
	// public virtual CRM_TIPO_CAMBIO CRM_TIPO_CAMBIO;
	//
	// public virtual CRM_TIPO CRM_TIPO;
	//
	// public virtual CRM_TIPO CRM_TIPO1;
	//
	// public virtual CRM_TIPO CRM_TIPO2;
	//
	// public virtual ICollection<CRM_MODELACION_DETALLE> CRM_MODELACION_DETALLE;
	//
	// public virtual ICollection<CRM_MODELACION_PREFACTIBILIDAD>
	// CRM_MODELACION_PREFACTIBILIDAD;
	//
	// public virtual ICollection<CRM_TAREA_POST_VENTA_DETALLE>
	// CRM_TAREA_POST_VENTA_DETALLE;
	//
	// public virtual ICollection<CRM_VENTA> CRM_VENTA;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoModelacion() {
		return codigoModelacion;
	}

	public void setCodigoModelacion(String codigoModelacion) {
		this.codigoModelacion = codigoModelacion;
	}

	public int getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	public void setCodigoTipoEstado(int codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	public int getCodigoTipoMoneda() {
		return codigoTipoMoneda;
	}

	public void setCodigoTipoMoneda(int codigoTipoMoneda) {
		this.codigoTipoMoneda = codigoTipoMoneda;
	}

	public double getTotalNoRecurrente() {
		return totalNoRecurrente;
	}

	public void setTotalNoRecurrente(double totalNoRecurrente) {
		this.totalNoRecurrente = totalNoRecurrente;
	}

	public double getTotalNoRecurrenteIGV() {
		return totalNoRecurrenteIGV;
	}

	public void setTotalNoRecurrenteIGV(double totalNoRecurrenteIGV) {
		this.totalNoRecurrenteIGV = totalNoRecurrenteIGV;
	}

	public double getTotalRecurrente() {
		return totalRecurrente;
	}

	public void setTotalRecurrente(double totalRecurrente) {
		this.totalRecurrente = totalRecurrente;
	}

	public double getTotalRecurrenteIGV() {
		return totalRecurrenteIGV;
	}

	public void setTotalRecurrenteIGV(double totalRecurrenteIGV) {
		this.totalRecurrenteIGV = totalRecurrenteIGV;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public int getCodigoTipoPeriodo() {
		return codigoTipoPeriodo;
	}

	public void setCodigoTipoPeriodo(int codigoTipoPeriodo) {
		this.codigoTipoPeriodo = codigoTipoPeriodo;
	}

	public int getValidezOferta() {
		return validezOferta;
	}

	public void setValidezOferta(int validezOferta) {
		this.validezOferta = validezOferta;
	}

	public boolean isProbable() {
		return probable;
	}

	public void setProbable(boolean probable) {
		this.probable = probable;
	}

	public boolean isAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(boolean aceptacion) {
		this.aceptacion = aceptacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodigoTipoCambio() {
		return codigoTipoCambio;
	}

	public void setCodigoTipoCambio(Integer codigoTipoCambio) {
		this.codigoTipoCambio = codigoTipoCambio;
	}

	public int getPlazoInstalacion() {
		return plazoInstalacion;
	}

	public void setPlazoInstalacion(int plazoInstalacion) {
		this.plazoInstalacion = plazoInstalacion;
	}

	public int getHoldFacturacion() {
		return holdFacturacion;
	}

	public void setHoldFacturacion(int holdFacturacion) {
		this.holdFacturacion = holdFacturacion;
	}

	public Integer getCodigoContacto() {
		return codigoContacto;
	}

	public void setCodigoContacto(Integer codigoContacto) {
		this.codigoContacto = codigoContacto;
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

	public ClienteBE getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBE cliente) {
		this.cliente = cliente;
	}

	public OportunidadBE getOportunidad() {
		return oportunidad;
	}

	public void setOportunidad(OportunidadBE oportunidad) {
		this.oportunidad = oportunidad;
	}

	public List<DocumentoModelacionBE> getDocumentosModelacion() {
		return documentosModelacion;
	}

	public void setDocumentosModelacion(List<DocumentoModelacionBE> documentosModelacion) {
		this.documentosModelacion = documentosModelacion;
	}	
}
