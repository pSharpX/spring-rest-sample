/*
 * Optical Networks
 * Copyright (c) 2016. All rights reserved.
 * 03/06/2016
 */
package pe.com.optical.middleware.crm.mapper;

import java.util.List;

import pe.com.optical.middleware.crm.bean.VentaBE;

// TODO: Auto-generated Javadoc
/**
 * The Interface VentaMapperSQLServer.
 */
public interface VentaMapper {

	/**
	 * Buscar por id.
	 * 14/06/2016
	 *
	 * @param id
	 *            the id
	 * @return the venta be
	 */
	public VentaBE buscarPorId(int id);

	/**
	 * Buscar.
	 * 14/06/2016
	 *
	 * @return the list
	 */
	public List<VentaBE> buscar();

	/**
	 * Crear.
	 * 14/06/2016
	 *
	 * @param ventaBE
	 *            the venta be
	 * @return the int
	 */
	public int crear(VentaBE ventaBE);

	/**
	 * Actualizar.
	 * 14/06/2016
	 *
	 * @param ventaBE
	 *            the venta be
	 * @return the int
	 */
	public int actualizar(VentaBE ventaBE);

	/**
	 * Eliminar.
	 * 14/06/2016
	 *
	 * @param id
	 *            the id
	 * @return the int
	 */
	public int eliminar(int id);

}
