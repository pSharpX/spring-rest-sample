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
@Table(name = "CRM_OPORTUNIDAD", schema = "crm")
public class OportunidadBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPOI_COD_OPORTUNIDAD", nullable = false)
	private Long id;

	/*
	 * @Column(name = "OPOI_COD_CLIENTE") private int codigoCliente;
	 */

	@Column(name = "OPOI_COD_TIPO_OPORTUNIDAD")
	private int codigoTipoOportunidad;

	@Column(name = "OPOV_NOMBRE")
	@NotNull
	@Size(max = 255)
	private String nombre;

//	@Column(name = "OPOI_COD_TIPO_ETAPA")
//	private int codigoTipoEtapa;

	@Column(name = "OPOI_PROBABILIDAD")
	private int probabilidad;

	@Column(name = "OPOI_COD_TIPO_POTENCIAL")
	private int codigoTipoPotencial;

	// @Column(name = "OPOI_COD_TIPO_MOTIVO_PERDIDO")
	// private Integer codigoTipoMotivoPerdido;

	@Column(name = "OPOD_FECHA_CIERRE_ESTIMA")
	private Date fechaCierreEstima;

	@Column(name = "OPOD_FECHA_CIERRE_REAL")
	private Date fechaCierreReal;

	@Column(name = "OPOI_COD_TIPO_MONEDA")
	private int codigoTipoMoneda;

	@Column(name = "OPON_MONTO_RECURRENTE")
	private double montoRecurrente;

	@Column(name = "OPON_MONTO_NO_RECURRENTE")
	private double montoNoRecurrente;

	@Column(name = "OPOV_USUARIO_INGENIERO")
	@NotNull
	@Size(max = 20)
	private String usuarioIngeniero;

	/*
	 * @Column(name = "OPOI_DOCUMENTO_RENOVACION") private Integer
	 * codigoDocumentoRenovacion;
	 */

	@Column(name = "OPOI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "OPOV_USUARIO_CREACION")
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "OPOD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "OPOV_USUARIO_ACTUALIZACION")
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "OPOD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Column(name = "OPOI_COD_TIPO_CAMPANA")
	private Integer codigoTipoCampana;

	@ManyToOne(optional = false)
	@JoinColumn(name = "OPOI_COD_CLIENTE")
	private ClienteBE cliente;

	@ManyToOne(optional = false)
	@JoinColumn(name = "OPOI_DOCUMENTO_RENOVACION")
	private DocumentoBE documento;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "OPOI_COD_TIPO_ETAPA")
	private TipoBE tipoEtapa;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "OPOI_COD_TIPO_MOTIVO_PERDIDO")
	private TipoBE tipoMotivoPerdido;

	/*
	 * public virtual ICollection<CRM_MODELACION> CRM_MODELACION;
	 * 
	 * public virtual CRM_TIPO CRM_TIPO;
	 * 
	 * public virtual CRM_TIPO CRM_TIPO1;
	 * 
	 * public virtual CRM_TIPO CRM_TIPO2;
	 * 
	 * public virtual CRM_TIPO CRM_TIPO3;
	 * 
	 * public virtual CRM_TIPO CRM_TIPO4;
	 * 
	 * public virtual CRM_TIPO CRM_TIPO5;
	 * 
	 * public virtual ICollection<CRM_OPORTUNIDAD_LLAMADA> CRM_OPORTUNIDAD_LLAMADA;
	 * 
	 * public virtual ICollection<CRM_OPORTUNIDAD_LOG> CRM_OPORTUNIDAD_LOG;
	 * 
	 * public virtual ICollection<CRM_OPORTUNIDAD_REUNION> CRM_OPORTUNIDAD_REUNION;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoTipoOportunidad() {
		return codigoTipoOportunidad;
	}

	public void setCodigoTipoOportunidad(int codigoTipoOportunidad) {
		this.codigoTipoOportunidad = codigoTipoOportunidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public int getCodigoTipoEtapa() {
//		return codigoTipoEtapa;
//	}
//
//	public void setCodigoTipoEtapa(int codigoTipoEtapa) {
//		this.codigoTipoEtapa = codigoTipoEtapa;
//	}

	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	public int getCodigoTipoPotencial() {
		return codigoTipoPotencial;
	}

	public void setCodigoTipoPotencial(int codigoTipoPotencial) {
		this.codigoTipoPotencial = codigoTipoPotencial;
	}

	// public Integer getCodigoTipoMotivoPeriodo() {
	// return codigoTipoMotivoPerdido;
	// }
	//
	// public void setCodigoTipoMotivoPeriodo(Integer codigoTipoMotivoPeriodo) {
	// this.codigoTipoMotivoPerdido = codigoTipoMotivoPeriodo;
	// }

	public Date getFechaCierreEstima() {
		return fechaCierreEstima;
	}

	public void setFechaCierreEstima(Date fechaCierreEstima) {
		this.fechaCierreEstima = fechaCierreEstima;
	}

	public Date getFechaCierreReal() {
		return fechaCierreReal;
	}

	public void setFechaCierreReal(Date fechaCierreReal) {
		this.fechaCierreReal = fechaCierreReal;
	}

	public int getCodigoTipoMoneda() {
		return codigoTipoMoneda;
	}

	public void setCodigoTipoMoneda(int codigoTipoMoneda) {
		this.codigoTipoMoneda = codigoTipoMoneda;
	}

	public double getMontoRecurrente() {
		return montoRecurrente;
	}

	public void setMontoRecurrente(double montoRecurrente) {
		this.montoRecurrente = montoRecurrente;
	}

	public double getMontoNoRecurrente() {
		return montoNoRecurrente;
	}

	public void setMontoNoRecurrente(double montoNoRecurrente) {
		this.montoNoRecurrente = montoNoRecurrente;
	}

	public String getUsuarioIngeniero() {
		return usuarioIngeniero;
	}

	public void setUsuarioIngeniero(String usuarioIngeniero) {
		this.usuarioIngeniero = usuarioIngeniero;
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

	public Integer getCodigoTipoCampana() {
		return codigoTipoCampana;
	}

	public void setCodigoTipoCampana(Integer codigoTipoCampana) {
		this.codigoTipoCampana = codigoTipoCampana;
	}

	public ClienteBE getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBE cliente) {
		this.cliente = cliente;
	}

	public DocumentoBE getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoBE documento) {
		this.documento = documento;
	}

	public TipoBE getTipoEtapa() {
		return tipoEtapa;
	}

	public void setTipoEtapa(TipoBE tipoEtapa) {
		this.tipoEtapa = tipoEtapa;
	}

	public TipoBE getTipoMotivoPerdido() {
		return tipoMotivoPerdido;
	}

	public void setTipoMotivoPerdido(TipoBE tipoMotivoPerdido) {
		this.tipoMotivoPerdido = tipoMotivoPerdido;
	}

}
