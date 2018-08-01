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
@Table(name = "CRM_VENTA_DETALLE", schema = "crm")
public class VentaDetalleBE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VDEI_CODIGO_DETALLE", nullable = false)
	private Long id;

	@Column(name = "VDEI_CORRELATIVO")
	private int correlativo;

	/*@Column(name = "VDEI_CODIGO_VENTA")
	public int codigoVenta;*/

	@Column(name = "VDEI_CODIGO_DIRECCION")
	private int codigoDireccion;

	@Column(name = "VDEI_CODIGO_PLANTILLA")
	private int codigoPlantilla;

	@Column(name = "VDEI_CODIGO_PLANTILLA_PADRE")
	private Integer codigoPlantillaPadre;

	@Column(name = "VDEI_INDICE")
	private int indice;

	@Column(name = "VDEI_INDICE_PADRE")
	private int indicePadre;

	@Column(name = "VDEI_TABULACION")
	private int tabulacion;

	@Column(name = "VDEI_CANTIDAD")
	private int cantidad;

	@Column(name = "VDEI_COD_TIPO_MONEDA")
	private Integer codigoTipoMoneda;

	@Column(name = "VDEN_MONTO")
	private double monto;

	@Column(name = "VDEI_COD_TIPO_NATURALEZA")
	private Integer codigoTipoNaturaleza;

	@Column(name = "VDEI_COD_TIPO_MODALIDAD")
	private Integer codigoTipoModalidad;

	@Column(name = "VDEI_COD_TIPO_ESTADO")
	private int codigoTipoEstado;

	@Column(name = "VDEI_EST_REGISTRO")
	private int estadoRegistro;

	@Column(name = "VDEV_USUARIO_CREACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioCreacion;

	@Column(name = "VDED_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "VDEV_USUARIO_ACTUALIZACION", nullable = false)
	@NotNull
	@Size(max = 20)
	private String usuarioActualizacion;

	@Column(name = "VDED_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	@Column(name = "VDEI_COSTO_UNITARIO")
	private double costoUnitario;

	@Column(name = "VDEN_PRECIO_TARIFA")
	private double precioTarifa;

	@Column(name = "VDEN_PRECIO_AJUSTE")
	private double precioAjuste;

	@Column(name = "VDEN_DESCUENTO")
	private double descuento;

	@Column(name = "VDEI_COD_PLANTILLA_TARIFA")
	private Integer codigoPlantillaTarifa;

	@Column(name = "VDEI_COD_TIPO_FRECUENCIA_TARIFA")
	private Integer codigoTipoFrecuenciaTarifa;

	@Column(name = "VDEI_COD_TIPO_DCTO")
	private Integer codigoTipoDescuento;
	

	@ManyToOne(optional = false)
    @JoinColumn(name = "VDEI_CODIGO_VENTA")
	private VentaBE venta;

	/*
	 * public CRM_DIRECCION CRM_DIRECCION;
	 * 
	 * public CRM_PLANTILLA CRM_PLANTILLA;
	 * 
	 * public CRM_PLANTILLA CRM_PLANTILLA1;
	 * 
	 * public CRM_PLANTILLA_TARIFA CRM_PLANTILLA_TARIFA;
	 * 
	 * public CRM_TIPO CRM_TIPO;
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
	 * 	 * 
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(int correlativo) {
		this.correlativo = correlativo;
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

	public Integer getCodigoPlantillaPadre() {
		return codigoPlantillaPadre;
	}

	public void setCodigoPlantillaPadre(Integer codigoPlantillaPadre) {
		this.codigoPlantillaPadre = codigoPlantillaPadre;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getIndicePadre() {
		return indicePadre;
	}

	public void setIndicePadre(int indicePadre) {
		this.indicePadre = indicePadre;
	}

	public int getTabulacion() {
		return tabulacion;
	}

	public void setTabulacion(int tabulacion) {
		this.tabulacion = tabulacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCodigoTipoMoneda() {
		return codigoTipoMoneda;
	}

	public void setCodigoTipoMoneda(Integer codigoTipoMoneda) {
		this.codigoTipoMoneda = codigoTipoMoneda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Integer getCodigoTipoNaturaleza() {
		return codigoTipoNaturaleza;
	}

	public void setCodigoTipoNaturaleza(Integer codigoTipoNaturaleza) {
		this.codigoTipoNaturaleza = codigoTipoNaturaleza;
	}

	public Integer getCodigoTipoModalidad() {
		return codigoTipoModalidad;
	}

	public void setCodigoTipoModalidad(Integer codigoTipoModalidad) {
		this.codigoTipoModalidad = codigoTipoModalidad;
	}

	public int getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	public void setCodigoTipoEstado(int codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
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

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getPrecioTarifa() {
		return precioTarifa;
	}

	public void setPrecioTarifa(double precioTarifa) {
		this.precioTarifa = precioTarifa;
	}

	public double getPrecioAjuste() {
		return precioAjuste;
	}

	public void setPrecioAjuste(double precioAjuste) {
		this.precioAjuste = precioAjuste;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Integer getCodigoPlantillaTarifa() {
		return codigoPlantillaTarifa;
	}

	public void setCodigoPlantillaTarifa(Integer codigoPlantillaTarifa) {
		this.codigoPlantillaTarifa = codigoPlantillaTarifa;
	}

	public Integer getCodigoTipoFrecuenciaTarifa() {
		return codigoTipoFrecuenciaTarifa;
	}

	public void setCodigoTipoFrecuenciaTarifa(Integer codigoTipoFrecuenciaTarifa) {
		this.codigoTipoFrecuenciaTarifa = codigoTipoFrecuenciaTarifa;
	}

	public Integer getCodigoTipoDescuento() {
		return codigoTipoDescuento;
	}

	public void setCodigoTipoDescuento(Integer codigoTipoDescuento) {
		this.codigoTipoDescuento = codigoTipoDescuento;
	}

	public VentaBE getVenta() {
		return venta;
	}

	public void setVenta(VentaBE venta) {
		this.venta = venta;
	}	
}
