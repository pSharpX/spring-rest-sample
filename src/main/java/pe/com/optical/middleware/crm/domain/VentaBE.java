package pe.com.optical.middleware.crm.domain;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CRM_VENTA", schema = "crm")
@NamedQueries(
        @NamedQuery(
                name = VentaBE.NQ_OBTENER_CRM_VENTA_POR_CLIENTE,
                query = "SELECT v FROM VentaBE v WHERE v.cliente.id = :idCliente"
        )
)
public class VentaBE implements Serializable {
	
	private static final long serialVersionUID = -4151724127052912117L;
	
	public static final String NQ_OBTENER_CRM_VENTA_POR_CLIENTE = "nq_obtener_crm_venta_por_cliente";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VENI_COD_VENTA", nullable = false)
	private Long id;

	/*@Column(name = "VENI_COD_DOCUMENTO")
	public int codigoDocumento;*/

	@Column(name = "VENI_COD_DIRECCION")
	private int codigoDireccion;

	/*@Column(name = "VENI_COD_CLIENTE")
	public int codigoCliente;*/

	@Column(name = "VENI_COD_PLANTILLA")
	private int codigoPlantilla;

	@Column(name = "VENI_INDICE_MODELADOR")
	private int indiceModelador;

	@Column(name = "VENV_NOMBRE", nullable = false)
	@NotNull
	@Size(max = 100)
	private String nombre;

	// @Column(name = "VENI_COD_TIPO_ESTADO_COMERCIAL")
	// private int codigoTipoEstadoComercial;
	//
	// @Column(name = "VENI_COD_TIPO_ESTADO_OPERACIONES")
	// private int codigoTipoEstadoOperaciones;

	@Column(name = "VEND_FECHA_ALTA")
	private Date fechaAlta;

	@Column(name = "VENI_COD_TIPO_MONEDA")
	private int codigoTipoMoneda;

	@Column(name = "VENN_TOTAL_RECURRENTE")
	private double totalRecurrente;

	@Column(name = "VENN_TOTAL_NO_RECURRENTE")
	private double totalNoRecurrente;

	@Column(name = "VENI_COD_TIPO_CAMBIO")
	private int codigoTipoCambio;

	@Column(name = "VENI_COD_MODELADOR")
	private int codigoModelador;

	@Column(name = "VENI_COD_VENTA_REFERENCIA")
	private Integer codigoVentaReferencia;

	@Column(name = "VENI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "VENV_USUARIO_CREACION")
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "VEND_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "VENV_USUARIO_ACTUALIZACION")
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "VEND_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	
	@ManyToOne(optional = false)
    @JoinColumn(name = "VENI_COD_DOCUMENTO")
	private DocumentoBE documento;
		
	@ManyToOne(optional = false)
    @JoinColumn(name = "VENI_COD_CLIENTE")
	private ClienteBE cliente;
	
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "VENI_COD_TIPO_ESTADO_COMERCIAL")
	private TipoBE tipoEstadoComercial;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "VENI_COD_TIPO_ESTADO_OPERACIONES")
	private TipoBE tipoEstadoOperaciones;
	
	
	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
	private List<VentaDetalleBE> ventaDetalles;
	
	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
	private List<VentaCircuitoBE> ventaCircuitos;
	/* 
	 * public CRM_DIRECCION CRM_DIRECCION;  
	 * public CRM_MODELACION CRM_MODELACION;
	 * 
	 * public ICollection<CRM_MODELACION_DETALLE> CRM_MODELACION_DETALLE;
	 * 
	 * public CRM_TIPO CRM_TIPO; public CRM_TIPO CRM_TIPO1; 
	 * public CRM_TIPO RM_TIPO2; 
	 * public CRM_TIPO_CAMBIO CRM_TIPO_CAMBIO;
	 * 
	 * public ICollection<CRM_VENTA> CRM_VENTA1;
	 * 
	 * public CRM_VENTA CRM_VENTA2;
	 * 
	 * 
	 * public ICollection<CRM_VENTA_TAREA> CRM_VENTA_TAREA; 
	 * 	 * 
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

	public int getIndiceModelador() {
		return indiceModelador;
	}

	public void setIndiceModelador(int indiceModelador) {
		this.indiceModelador = indiceModelador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// public int getCodigoTipoEstadoComercial() {
	// return codigoTipoEstadoComercial;
	// }
	//
	// public void setCodigoTipoEstadoComercial(int codigoTipoEstadoComercial) {
	// this.codigoTipoEstadoComercial = codigoTipoEstadoComercial;
	// }
	//
	// public int getCodigoTipoEstadoOperaciones() {
	// return codigoTipoEstadoOperaciones;
	// }
	//
	// public void setCodigoTipoEstadoOperaciones(int codigoTipoEstadoOperaciones) {
	// this.codigoTipoEstadoOperaciones = codigoTipoEstadoOperaciones;
	// }

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

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

	public int getCodigoTipoCambio() {
		return codigoTipoCambio;
	}

	public void setCodigoTipoCambio(int codigoTipoCambio) {
		this.codigoTipoCambio = codigoTipoCambio;
	}

	public int getCodigoModelador() {
		return codigoModelador;
	}

	public void setCodigoModelador(int codigoModelador) {
		this.codigoModelador = codigoModelador;
	}

	public Integer getCodigoVentaReferencia() {
		return codigoVentaReferencia;
	}

	public void setCodigoVentaReferencia(Integer codigoVentaReferencia) {
		this.codigoVentaReferencia = codigoVentaReferencia;
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

	public ClienteBE getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBE cliente) {
		this.cliente = cliente;
	}
	
	public TipoBE getTipoEstadoComercial() {
		return tipoEstadoComercial;
	}

	public void setTipoEstadoComercial(TipoBE tipoEstadoComercial) {
		this.tipoEstadoComercial = tipoEstadoComercial;
	}

	public TipoBE getTipoEstadoOperaciones() {
		return tipoEstadoOperaciones;
	}

	public void setTipoEstadoOperaciones(TipoBE tipoEstadoOperaciones) {
		this.tipoEstadoOperaciones = tipoEstadoOperaciones;
	}

	public List<VentaDetalleBE> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(List<VentaDetalleBE> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

	public List<VentaCircuitoBE> getVentaCircuitos() {
		return ventaCircuitos;
	}

	public void setVentaCircuitos(List<VentaCircuitoBE> ventaCircuitos) {
		this.ventaCircuitos = ventaCircuitos;
	}	
}
