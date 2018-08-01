package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.TipoBE;
import pe.com.optical.middleware.crm.repository.TipoRepository;

@Repository
public class TipoRepositoryImpl implements TipoRepository {

	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	private static final String SELECT_CRM_TIPOS = "SELECT v FROM TipoBE v";
	
	@Override
	public TipoBE buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoBE> obtenerTodos() {
		TypedQuery<TipoBE> query = this.em.createQuery(SELECT_CRM_TIPOS, TipoBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(TipoBE object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(TipoBE object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(TipoBE object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoBE> obtenerTiposPorConcepto(String codigoConcepto) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", codigoConcepto);
        return query.getResultList();
	}

	@Override
	public List<TipoBE> obtenerEstadosServiciosVentas() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_SERVICIOS);
        return query.getResultList();
	}

	@Override
	public List<TipoBE> obtenerEstadosDocumentos() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_DOCUMENTOS);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerEstadoServicioVenta(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_SERVICIOS);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public TipoBE obtenerEstadoDocumento(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_DOCUMENTOS);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerTipoPeriodos() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_TIPOS_PERIODOS);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerTipoPeriodo(String codigoPeriodo) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_TIPOS_PERIODOS);
        query.setParameter("nombreCorto", codigoPeriodo);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerEstadosComerciales() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_COMERCIAL);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerEstadoComercial(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_COMERCIAL);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerEstadosOperativos() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_OPERATIVO);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerEstadoOperativo(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_OPERATIVO);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerEstadosTareaPostVenta() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_TPV);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerEstadoTareaPostVenta(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_TPV);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerEstadosOportunidades() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_OPORTUNIDAD);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerEstadoOportunidad(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_ESTADOS_OPORTUNIDAD);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerTipoMotivosAnulacionTareaPostVenta() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_TPV_TIPOS_MOTIVO_ANULACION);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerTipoMotivoAnulacionTareaPostVenta(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_TPV_TIPOS_MOTIVO_ANULACION);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}

	@Override
	public List<TipoBE> obtenerTipoMotivosCerradoPerdido() {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_OPORTUNIDAD_TIPOS_MOTIVO_CERRADO_PERDIDO);
        return query.getResultList();
	}

	@Override
	public TipoBE obtenerTipoMotivoCerradoPerdido(String codigoEstado) {
		TypedQuery<TipoBE> query = this.em.createNamedQuery(
				TipoBE.NQ_OBTENER_CRM_TIPO_POR_CONCEPTO_Y_NOMBRE_CORTO, TipoBE.class);
        query.setParameter("codigoConcepto", TipoBE.CONST_CRM_TIPO_CONCEPTO_OPORTUNIDAD_TIPOS_MOTIVO_CERRADO_PERDIDO);
        query.setParameter("nombreCorto", codigoEstado);
        return query.getSingleResult();
	}
}
