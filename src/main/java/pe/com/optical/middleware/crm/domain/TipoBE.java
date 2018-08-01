package pe.com.optical.middleware.crm.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CRM_TIPO", schema = "crm")
@NamedQueries({
	@NamedQuery(
			name = TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, 
			query = "SELECT t FROM TipoBE t WHERE t.concepto = :codigoConcepto"
			),
	@NamedQuery(
			name = TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, 
			query = "SELECT t FROM TipoBE t WHERE t.concepto = :codigoConcepto and t.nombreCorto = :nombreCorto"
			)
})
public class TipoBE implements Serializable {

	private static final long serialVersionUID = -284439153676653352L;

	public static final String NQ_OBTENER_CRM_TIPO_POR_CONCEPTO = "nq_obtener_crm_tipo_por_concepto";
	public static final String NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO = "nq_obtener_crm_tipo_por_concepto_nombre_corto";
	
	public static final String CONST_CRM_TIPO_CONCEPTO_OPORTUNIDAD_TIPOS_MOTIVO_CERRADO_PERDIDO = "27";
	public static final String CONST_CRM_TIPO_CONCEPTO_TPV_TIPOS_MOTIVO_ANULACION = "79";
	public static final String CONST_CRM_TIPO_CONCEPTO_ESTADOS_TPV = "76";
	public static final String CONST_CRM_TIPO_CONCEPTO_ESTADOS_OPORTUNIDAD = "25";
	public static final String CONST_CRM_TIPO_CONCEPTO_ESTADOS_SERVICIOS = "67";
	public static final String CONST_CRM_TIPO_CONCEPTO_ESTADOS_DOCUMENTOS = "55";
	public static final String CONST_CRM_TIPO_CONCEPTO_TIPOS_PERIODOS = "04";
	public static final String CONST_CRM_TIPO_CONCEPTO_ESTADOS_COMERCIAL = "67";
	public static final String CONST_CRM_TIPO_CONCEPTO_ESTADOS_OPERATIVO = "69";
	
	public static final int CONST_CRM_AUDITORIA_ESTADO_ACTIVO = 1;
	public static final int CONST_CRM_AUDITORIA_ESTADO_INACTIVO = 0;
	
	
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_ACTIVO = "001";
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_POR_INSTALAR = "004";
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_SIN_CONFORMIDAD = "005";
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_BAJA = "002";
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_SUSPENDIDO_FALTA_PAGO = "003";
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_SUSPENDIDO_SOLICITUD_CLIENTE = "020";
	
	public static final String CONST_INTRANET_CIRCUITO_ESTADO_ELIMINADO = "ELIMINADO";
	
	public static final String CONST_CRM_TIPO_TPV_MOTIVO_ANULACION_ELIMINACION_SERVICIO = "ES";
	public static final String CONST_CRM_TIPO_OPORTUNIDAD_MOTIVO_CERRADO_PERDIDO_ELIMINACION_SERVICIO = "ES";
	
	public static final String CONST_CRM_TIPO_TPV_ESTADO_ANULADO = "AN";
	public static final String CONST_CRM_TIPO_TPV_ESTADO_CERRADO = "CE";
	public static final String CONST_CRM_TIPO_TPV_ESTADO_ACEPTADO = "AC";
	
	public static final String CONST_CRM_TIPO_OPORTUNIDAD_ESTADO_CERRADO_PERDIDO = "CP1";
	public static final String CONST_CRM_TIPO_OPORTUNIDAD_ESTADO_CERRADO_GANADO = "CG1";
	
	public static final String CONST_CRM_TIPO_DOCUMENTO_ESTADO_REGISTRADO = "BOR";
	public static final String CONST_CRM_TIPO_DOCUMENTO_ESTADO_APROBADO = "APR";
	public static final String CONST_CRM_TIPO_DOCUMENTO_ESTADO_VIGENTE = "VIG";
	public static final String CONST_CRM_TIPO_DOCUMENTO_ESTADO_ANULADO = "ANU";
	
	public static final String CONST_CRM_TIPO_DOCUMENTO_PERIODO_MESES = "M";
	public static final String CONST_CRM_TIPO_DOCUMENTO_PERIODO_DIAS = "D";
	
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_COMERCIAL_ACTIVO = "ACT";
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_COMERCIAL_POR_INSTALAR = "XIN";
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_COMERCIAL_BAJA = "BAJ";
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_COMERCIAL_SUSPENDIDO = "SUS";
	
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_ACTIVO = "ACT";
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_POR_INSTALAR = "XIN";
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_BAJA = "BAJ";
	public static final String CONST_CRM_TIPO_SERVICIO_ESTADO_OPERATIVO_SUSPENDIDO = "SUS";

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TIPI_COD_TIPO", nullable = false)
	private Long id;

	@Column(name = "TIPV_NOMBRE", nullable = false)
	@NotNull
	@Size(max = 200)
	private String nombre;

	@Column(name = "TIPC_CONCEPTO", nullable = false)
	@NotNull
	@Size(max = 2)
	private String concepto;

	@Column(name = "TIPV_NOMBRE_CORTO", nullable = false)
	@NotNull
	@Size(max = 15)
	private String nombreCorto;

	@Column(name = "TIPV_SIMBOLO", nullable = false)
	@NotNull
	@Size(max = 5)
	private String simbolo;

	@Column(name = "TIPV_EQUIV_PORCENTAJE", nullable = false)
	@NotNull
	@Size(max = 50)
	private String equivalenciaPorcentaje;

	@Column(name = "TIPI_COD_TIPO_PADRE")
	private Integer codigoTipoPadre;

	@Column(name = "TIPI_EQUIV_NUMERICO")
	private Integer equivalenciaNumerico;

	@Column(name = "TIPC_EQUIV_1", nullable = false)
	@NotNull
	@Size(max = 50)
	private String equivalencia1;

	@Column(name = "TIPC_EQUIV_2", nullable = false)
	@NotNull
	@Size(max = 50)
	private String equivalencia2;

	@Column(name = "TIPC_EQUIV_3", nullable = false)
	@NotNull
	@Size(max = 50)
	private String equivalencia3;

	@Column(name = "TIPI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "TIPV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "TIPD_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "TIPV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "TIPD_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getEquivalenciaPorcentaje() {
		return equivalenciaPorcentaje;
	}

	public void setEquivalenciaPorcentaje(String equivalenciaPorcentaje) {
		this.equivalenciaPorcentaje = equivalenciaPorcentaje;
	}

	public Integer getCodigoTipoPadre() {
		return codigoTipoPadre;
	}

	public void setCodigoTipoPadre(Integer codigoTipoPadre) {
		this.codigoTipoPadre = codigoTipoPadre;
	}

	public Integer getEquivalenciaNumerico() {
		return equivalenciaNumerico;
	}

	public void setEquivalenciaNumerico(Integer equivalenciaNumerico) {
		this.equivalenciaNumerico = equivalenciaNumerico;
	}

	public String getEquivalencia1() {
		return equivalencia1;
	}

	public void setEquivalencia1(String equivalencia1) {
		this.equivalencia1 = equivalencia1;
	}

	public String getEquivalencia2() {
		return equivalencia2;
	}

	public void setEquivalencia2(String equivalencia2) {
		this.equivalencia2 = equivalencia2;
	}

	public String getEquivalencia3() {
		return equivalencia3;
	}

	public void setEquivalencia3(String equivalencia3) {
		this.equivalencia3 = equivalencia3;
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
}
