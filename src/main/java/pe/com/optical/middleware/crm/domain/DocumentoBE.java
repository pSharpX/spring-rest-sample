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
@Table(name = "CRM_DOCUMENTO", schema = "crm")
public class DocumentoBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCI_COD_DOCUMENTO", nullable = false)
	private Long id;

	@Column(name = "DOCV_COD_DOCUMENTO", nullable = false)
	@NotNull
	@Size(max = 30)
	private String codigoDocumento;

	@Column(name = "DOCI_COD_TIPO_DOCUMENTO")
	private int codigoTipoDocumento;

	@Column(name = "DOCI_COD_CLIENTE")
	private int codigoCliente;

	// @Column(name = "DOCI_COD_TIPO_ESTADO")
	// private int codigoTipoEstado;

	@Column(name = "DOCI_COD_TIPO_SITUACION")
	private int codigoTipoSituacion;

	@Column(name = "DOCD_FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "DOCD_FECHA_FIN")
	private Date fechaFin;

	@Column(name = "DOCD_FECHA_COMPROMISO")
	private Date fechaCompromiso;

	@Column(name = "DOCD_FECHA_FIRMA")
	private Date fechaFirma;

	@Column(name = "DOCI_COD_TIPO_MODALIDAD")
	private int codigoTipoModalidad;

	@Column(name = "DOCI_PLAZO")
	private int plazo;

	// @Column(name = "DOCI_COD_TIPO_PERIODO")
	// private Integer codigoTipoPeriodo;

	@Column(name = "DOCI_COD_TIPO_MONEDA")
	private int codigoTipoMoneda;

	@Column(name = "DOCN_RECURRENTE")
	private double recurrente;

	@Column(name = "DOCN_NO_RECURRENTE")
	private double noRecurrente;

	@Column(name = "DOCB_FORMATO_CLIENTE")
	private boolean formatoCliente;

	@Column(name = "DOCB_HOLD")
	private boolean hold;

	@Column(name = "DOCI_DIAS_HOLD")
	private int diasHold;

	@Column(name = "DOCI_COD_TIPO_MOTIVO_HOLD")
	private Integer codigoTipoMotivoHold;

	@Column(name = "DOCI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "DOCV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "DOCD_FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@Column(name = "DOCV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "DOCD_FECHA_ACTUALIZACION", nullable = false)
	private Date fechaActualizacion;

	@Column(name = "DOCV_COMENTARIO")
	@NotNull
	@Size(max = 2000)
	private String comentario;

	@ManyToOne(optional = false)
	@JoinColumn(name = "DOCI_COD_TIPO_ESTADO")
	private TipoBE tipoEstado;

	@ManyToOne(optional = true)
	@JoinColumn(name = "DOCI_COD_TIPO_PERIODO")
	private TipoBE tipoPeriodo;

	@OneToMany(mappedBy = "documento", fetch = FetchType.LAZY)
	private List<OportunidadBE> oportunidades;

	@OneToMany(mappedBy = "documento", fetch = FetchType.LAZY)
	private List<VentaBE> ventas;
	
	@OneToMany(mappedBy = "documento", fetch = FetchType.EAGER)
	private List<DocumentoModelacionBE> documentosModelacion;
	
	@OneToMany(mappedBy = "documento", fetch = FetchType.EAGER)
	private List<DocumentoTareaPostVentaBE> documentosTareaPostVenta;

	/*
	 * public ICollection<CRM_AUTORIZACION_DOCUMENTO> CRM_AUTORIZACION_DOCUMENTO;
	 * 
	 * public CRM_CLIENTE CRM_CLIENTE;
	 * 
	 * public CRM_TIPO CRM_TIPO1;
	 * 
	 * public CRM_TIPO CRM_TIPO2;
	 * 
	 * public CRM_TIPO CRM_TIPO3;
	 * 
	 * public CRM_TIPO CRM_TIPO4;
	 * 
	 * public CRM_TIPO CRM_TIPO5;
	 *  
	 * 
	 * public ICollection<CRM_DOCUMENTO_COMPROMISOS> CRM_DOCUMENTO_COMPROMISOS {
	 * get; set; }
	 * 
	 * public ICollection<CRM_DOCUMENTO_COMPROMISOS_POSTVENTA>
	 * CRM_DOCUMENTO_COMPROMISOS_POSTVENTA { get; set; }
	 * 
	 * public CRM_DOCUMENTO_RELACIONADO CRM_DOCUMENTO_RELACIONADO { get; set; }
	 * 
	 * public ICollection<CRM_DOCUMENTO_RELACIONADO> CRM_DOCUMENTO_RELACIONADO1 {
	 * get; set; }
	 * 
	 * public CRM_TIPO CRM_TIPO6 { get; set; }
	 * 
	 * public ICollection<CRM_DOCUMENTO_LOG> CRM_DOCUMENTO_LOG { get; set; }
	 * 
	 * public ICollection<CRM_DOCUMENTO_REQUISITO> CRM_DOCUMENTO_REQUISITO { get;
	 * set; }
	 *  
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public int getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(int codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/*
	 * public int getCodigoTipoEstado() { return codigoTipoEstado; }
	 * 
	 * public void setCodigoTipoEstado(int codigoTipoEstado) { this.codigoTipoEstado
	 * = codigoTipoEstado; }
	 */

	public int getCodigoTipoSituacion() {
		return codigoTipoSituacion;
	}

	public void setCodigoTipoSituacion(int codigoTipoSituacion) {
		this.codigoTipoSituacion = codigoTipoSituacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaCompromiso() {
		return fechaCompromiso;
	}

	public void setFechaCompromiso(Date fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public Date getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public int getCodigoTipoModalidad() {
		return codigoTipoModalidad;
	}

	public void setCodigoTipoModalidad(int codigoTipoModalidad) {
		this.codigoTipoModalidad = codigoTipoModalidad;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	// public Integer getCodigoTipoPeriodo() {
	// return codigoTipoPeriodo;
	// }
	//
	// public void setCodigoTipoPeriodo(Integer codigoTipoPeriodo) {
	// this.codigoTipoPeriodo = codigoTipoPeriodo;
	// }

	public int getCodigoTipoMoneda() {
		return codigoTipoMoneda;
	}

	public void setCodigoTipoMoneda(int codigoTipoMoneda) {
		this.codigoTipoMoneda = codigoTipoMoneda;
	}

	public double getRecurrente() {
		return recurrente;
	}

	public void setRecurrente(double recurrente) {
		this.recurrente = recurrente;
	}

	public double getNoRecurrente() {
		return noRecurrente;
	}

	public void setNoRecurrente(double noRecurrente) {
		this.noRecurrente = noRecurrente;
	}

	public boolean isFormatoCliente() {
		return formatoCliente;
	}

	public void setFormatoCliente(boolean formatoCliente) {
		this.formatoCliente = formatoCliente;
	}

	public boolean isHold() {
		return hold;
	}

	public void setHold(boolean hold) {
		this.hold = hold;
	}

	public int getDiasHold() {
		return diasHold;
	}

	public void setDiasHold(int diasHold) {
		this.diasHold = diasHold;
	}

	public Integer getCodigoTipoMotivoHold() {
		return codigoTipoMotivoHold;
	}

	public void setCodigoTipoMotivoHold(Integer codigoTipoMotivoHold) {
		this.codigoTipoMotivoHold = codigoTipoMotivoHold;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public TipoBE getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(TipoBE tipoEstado) {
		this.tipoEstado = tipoEstado;
	}
	
	public TipoBE getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(TipoBE tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public List<OportunidadBE> getOportunidades() {
		return oportunidades;
	}

	public void setOportunidades(List<OportunidadBE> oportunidades) {
		this.oportunidades = oportunidades;
	}

	public List<VentaBE> getVentas() {
		return ventas;
	}

	public void setVentas(List<VentaBE> ventas) {
		this.ventas = ventas;
	}

	public List<DocumentoModelacionBE> getDocumentosModelacion() {
		return documentosModelacion;
	}

	public void setDocumentosModelacion(List<DocumentoModelacionBE> documentosModelacion) {
		this.documentosModelacion = documentosModelacion;
	}

	public List<DocumentoTareaPostVentaBE> getDocumentosTareaPostVenta() {
		return documentosTareaPostVenta;
	}

	public void setDocumentosTareaPostVenta(List<DocumentoTareaPostVentaBE> documentosTareaPostVenta) {
		this.documentosTareaPostVenta = documentosTareaPostVenta;
	}
}
