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
@Table(name = "CRM_TAREA_POST_VENTA", schema = "crm")
public class TareaPostVentaBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TARI_COD_TAREA", nullable = false)
	private Long id;

	@Column(name = "TARV_CODIGO_TAREA", nullable = false)
	@NotNull
	@Size(max = 30)
	private String codigoTarea;

	@Column(name = "TARV_COMENTARIO")
	private String comentario;

	@Column(name = "TARI_COD_TIPO_TAREA")
	private int codigoTipoTarea;

	@Column(name = "TARI_COD_TIPO_ORIGEN")
	private int codigoTipoOrigen;

	@Column(name = "TARI_COD_TIPO_MOTIVO")
	private Integer codigoTipoMotivo;

//	@Column(name = "TARI_COD_TIPO_ESTADO_COMERCIAL")
//	private int codigoTipoEstadoComercial;
//
//	@Column(name = "TARI_COD_TIPO_POTENCIAL_CIERRE")
//	private int codigoTipoPotencialCierre;

	@Column(name = "TARI_COD_TIPO_MONEDA")
	private int codigoTipoMoneda;

	@Column(name = "TARN_TOTAL_RECURRENTE")
	private double totalRecurrente;

	@Column(name = "TARN_TOTAL_NO_RECURRENTE")
	private double totalNoRecurrente;

	@Column(name = "TARI_DIAS_SUSPENSION")
	private int diasSuspension;

	@Column(name = "TARI_COD_TIPO_MODALIDAD_TRASLADO")
	private Integer codigoTipoModalidadTraslado;

	@Column(name = "TARD_FECHA_CORTE_ORIGEN")
	private Date fechaCorteOrigen;

	@Column(name = "TARB_RETIRO_EQUIPOS")
	private boolean retiroEquipos;

	@Column(name = "TARI_PLAZO_INSTALACION")
	private int plazoInstalacion;

	@Column(name = "TARI_VALIDEZ_OFERTA")
	private int validezOferta;

	@Column(name = "TARB_ACEPTACION")
	private Boolean aceptacion;

	@Column(name = "TARI_COD_CONTACTO_DESTINATARIO")
	private Integer codigoContactoDestinatario;

	@Column(name = "TARI_COD_TIPO_CAMBIO")
	private int codigoTipoCambio;

	// @Column(name = "TARI_COD_TIPO_MOTIVO_ANULA")
	// private Integer codigoTipoMotivoAnulacion;

	@Column(name = "TARD_FECHA_EJECUTA")
	private Date fechaEjecucion;

	@Column(name = "TARD_FECHA_CIERRE_ESTIMADO")
	private Date fechaCierreEstimado;

	@Column(name = "TARD_FECHA_CIERRE_REAL")
	private Date fechaCierreReal;

	@Column(name = "TARI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "TARV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "TARD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "TARV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "TARD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Column(name = "TARI_PLAZO_CONTRATACION")
	private Integer plazoContratacion;

	@ManyToOne(optional = true)
	@JoinColumn(name = "TARI_COD_TIPO_MOTIVO_ANULA")
	private TipoBE tipoMotivoAnulacion;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "TARI_COD_TIPO_ESTADO_COMERCIAL")
	private TipoBE tipoEstadoComercial;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "TARI_COD_TIPO_POTENCIAL_CIERRE")
	private TipoBE tipoPotencialCierre;

	
	@OneToMany(mappedBy = "tareaPostVenta", fetch = FetchType.LAZY)
	private List<DocumentoTareaPostVentaBE> documentosTareaPostVenta;

	// public ICollection<CRM_AUTORIZACION_TAREA_POST_VENTA>
	// CRM_AUTORIZACION_TAREA_POST_VENTA;
	//
	// public CRM_CONTACTO CRM_CONTACTO;
	//
	//
	// public CRM_TIPO_CAMBIO CRM_TIPO_CAMBIO;
	//
	//
	// public CRM_TIPO CRM_TIPO1;
	//
	// public CRM_TIPO CRM_TIPO2;
	//
	// public CRM_TIPO CRM_TIPO3;
	//
	// public CRM_TIPO CRM_TIPO4;
	//
	// public CRM_TIPO CRM_TIPO5;
	//
	// public CRM_TIPO CRM_TIPO6;
	//
	// public ICollection<CRM_TAREA_POST_VENTA_LLAMADA>
	// CRM_TAREA_POST_VENTA_LLAMADA;
	//
	// public ICollection<CRM_TAREA_POST_VENTA_LOG> CRM_TAREA_POST_VENTA_LOG;
	//
	// public ICollection<CRM_TAREA_POST_VENTA_REUNION>
	// CRM_TAREA_POST_VENTA_REUNION;
	//
	// public ICollection<CRM_VENTA_TAREA> CRM_VENTA_TAREA;
	//
	// public CRM_TIPO CRM_TIPO7;
	//
	// public ICollection<CRM_TAREA_POST_VENTA_DETALLE>
	// CRM_TAREA_POST_VENTA_DETALLE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoTarea() {
		return codigoTarea;
	}

	public void setCodigoTarea(String codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCodigoTipoTarea() {
		return codigoTipoTarea;
	}

	public void setCodigoTipoTarea(int codigoTipoTarea) {
		this.codigoTipoTarea = codigoTipoTarea;
	}

	public int getCodigoTipoOrigen() {
		return codigoTipoOrigen;
	}

	public void setCodigoTipoOrigen(int codigoTipoOrigen) {
		this.codigoTipoOrigen = codigoTipoOrigen;
	}

	public Integer getCodigoTipoMotivo() {
		return codigoTipoMotivo;
	}

	public void setCodigoTipoMotivo(Integer codigoTipoMotivo) {
		this.codigoTipoMotivo = codigoTipoMotivo;
	}

	// public int getCodigoTipoEstadoComercial() {
	// return codigoTipoEstadoComercial;
	// }
	//
	// public void setCodigoTipoEstadoComercial(int codigoTipoEstadoComercial) {
	// this.codigoTipoEstadoComercial = codigoTipoEstadoComercial;
	// }
	//
	// public int getCodigoTipoPotencialCierre() {
	// return codigoTipoPotencialCierre;
	// }
	//
	// public void setCodigoTipoPotencialCierre(int codigoTipoPotencialCierre) {
	// this.codigoTipoPotencialCierre = codigoTipoPotencialCierre;
	// }

	public int getCodigoTipoMoneda() {
		return codigoTipoMoneda;
	}

	public void setCodigoTipoMoneda(int codigoTipoMoneda) {
		this.codigoTipoMoneda = codigoTipoMoneda;
	}

	public double getTotalRecurrente() {
		return totalRecurrente;
	}

	public void setTotalRecurrente(double totalRecurrente) {
		this.totalRecurrente = totalRecurrente;
	}

	public double getTotalNoRecurrente() {
		return totalNoRecurrente;
	}

	public void setTotalNoRecurrente(double totalNoRecurrente) {
		this.totalNoRecurrente = totalNoRecurrente;
	}

	public int getDiasSuspension() {
		return diasSuspension;
	}

	public void setDiasSuspension(int diasSuspension) {
		this.diasSuspension = diasSuspension;
	}

	public Integer getCodigoTipoModalidadTraslado() {
		return codigoTipoModalidadTraslado;
	}

	public void setCodigoTipoModalidadTraslado(Integer codigoTipoModalidadTraslado) {
		this.codigoTipoModalidadTraslado = codigoTipoModalidadTraslado;
	}

	public Date getFechaCorteOrigen() {
		return fechaCorteOrigen;
	}

	public void setFechaCorteOrigen(Date fechaCorteOrigen) {
		this.fechaCorteOrigen = fechaCorteOrigen;
	}

	public boolean isRetiroEquipos() {
		return retiroEquipos;
	}

	public void setRetiroEquipos(boolean retiroEquipos) {
		this.retiroEquipos = retiroEquipos;
	}

	public int getPlazoInstalacion() {
		return plazoInstalacion;
	}

	public void setPlazoInstalacion(int plazoInstalacion) {
		this.plazoInstalacion = plazoInstalacion;
	}

	public int getValidezOferta() {
		return validezOferta;
	}

	public void setValidezOferta(int validezOferta) {
		this.validezOferta = validezOferta;
	}

	public Boolean getAceptacion() {
		return aceptacion;
	}

	public void setAceptacion(Boolean aceptacion) {
		this.aceptacion = aceptacion;
	}

	public Integer getCodigoContactoDestinatario() {
		return codigoContactoDestinatario;
	}

	public void setCodigoContactoDestinatario(Integer codigoContactoDestinatario) {
		this.codigoContactoDestinatario = codigoContactoDestinatario;
	}

	public int getCodigoTipoCambio() {
		return codigoTipoCambio;
	}

	public void setCodigoTipoCambio(int codigoTipoCambio) {
		this.codigoTipoCambio = codigoTipoCambio;
	}

	// public Integer getCodigoTipoMotivoAnulacion() {
	// return codigoTipoMotivoAnulacion;
	// }
	//
	// public void setCodigoTipoMotivoAnulacion(Integer codigoTipoMotivoAnulacion) {
	// this.codigoTipoMotivoAnulacion = codigoTipoMotivoAnulacion;
	// }

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public Date getFechaCierreEstimado() {
		return fechaCierreEstimado;
	}

	public void setFechaCierreEstimado(Date fechaCierreEstimado) {
		this.fechaCierreEstimado = fechaCierreEstimado;
	}

	public Date getFechaCierreReal() {
		return fechaCierreReal;
	}

	public void setFechaCierreReal(Date fechaCierreReal) {
		this.fechaCierreReal = fechaCierreReal;
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

	public Integer getPlazoContratacion() {
		return plazoContratacion;
	}

	public void setPlazoContratacion(Integer plazoContratacion) {
		this.plazoContratacion = plazoContratacion;
	}

	public TipoBE getTipoMotivoAnulacion() {
		return tipoMotivoAnulacion;
	}

	public void setTipoMotivoAnulacion(TipoBE tipoMotivoAnulacion) {
		this.tipoMotivoAnulacion = tipoMotivoAnulacion;
	}

	public List<DocumentoTareaPostVentaBE> getDocumentosTareaPostVenta() {
		return documentosTareaPostVenta;
	}

	public void setDocumentosTareaPostVenta(List<DocumentoTareaPostVentaBE> documentosTareaPostVenta) {
		this.documentosTareaPostVenta = documentosTareaPostVenta;
	}

	public TipoBE getTipoEstadoComercial() {
		return tipoEstadoComercial;
	}

	public void setTipoEstadoComercial(TipoBE tipoEstadoComercial) {
		this.tipoEstadoComercial = tipoEstadoComercial;
	}

	public TipoBE getTipoPotencialCierre() {
		return tipoPotencialCierre;
	}

	public void setTipoPotencialCierre(TipoBE tipoPotencialCierre) {
		this.tipoPotencialCierre = tipoPotencialCierre;
	}
}
