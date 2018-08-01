/*
 * Optical Networks
 * Copyright (c) 2016. All rights reserved.
 * 03/06/2016
 */
package pe.com.optical.middleware.crm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.optical.middleware.crm.bean.VentaBE;
import pe.com.optical.middleware.crm.mapper.VentaMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class LogService.
 */
@Service("ventaService")
public class VentaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VentaService.class);

	@Autowired
	private VentaMapper mapperSQLServer;

	/**
	 * Buscar por id.
	 * 14/06/2016
	 *
	 * @param id
	 *            the id
	 * @return the venta be
	 */
	public VentaBE buscarPorId(int id) {

		LOGGER.info("buscarPorId.id: " + id);
		return mapperSQLServer.buscarPorId(id);

	}

	/**
	 * Buscar.
	 * 14/06/2016
	 *
	 * @return the list
	 */
	public List<VentaBE> buscar() {

		List<VentaBE> lstLogsSQL = mapperSQLServer.buscar();
		LOGGER.info("lstLogsSQL.size: " + lstLogsSQL.size());
		return lstLogsSQL;

	}

	/**
	 * Crear.
	 * 14/06/2016
	 *
	 * @param ventaBE
	 *            the venta be
	 * @return the int
	 */
	public int crear(VentaBE ventaBE) {

		return mapperSQLServer.crear(ventaBE);
	}

	/**
	 * Actualizar.
	 * 14/06/2016
	 *
	 * @param ventaBE
	 *            the venta be
	 * @return the int
	 */
	public int actualizar(VentaBE ventaBE) {

		return mapperSQLServer.actualizar(ventaBE);
	}

	/**
	 * Eliminar.
	 * 14/06/2016
	 *
	 * @param id
	 *            the id
	 * @return the int
	 */
	public int eliminar(int id) {

		return mapperSQLServer.eliminar(id);
	}

}
