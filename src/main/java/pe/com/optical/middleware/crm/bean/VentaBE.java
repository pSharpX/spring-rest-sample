/*
 * Optical Networks Copyright (c) 2016. All rights reserved. 07/06/2016
 */
package pe.com.optical.middleware.crm.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class VentaBE.
 */
public class VentaBE implements Serializable {

	private static final long	serialVersionUID	= -7922526135624993649L;

	private int					id;

	private double				monto;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date				fechaCreacion;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "VentaBE [id=" + id + ", monto=" + monto + "]";
	}


}
