package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.VentaDetalleBE;
import pe.com.optical.middleware.crm.repository.VentaDetalleRepository;

@Repository
public class VentaDetalleRepositoryImpl implements VentaDetalleRepository {
	
	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	private static final String SELECT_CRM_VENTAS_DETALLES = "SELECT v FROM VentaDetalleBE v";

	@Override
	public VentaDetalleBE buscar(Long id) {
		return this.em.find(VentaDetalleBE.class, id);
	}

	@Override
	public List<VentaDetalleBE> obtenerTodos() {
		TypedQuery<VentaDetalleBE> query = this.em.createQuery(SELECT_CRM_VENTAS_DETALLES, VentaDetalleBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(VentaDetalleBE object) {
		this.em.persist(object);		
	}

	@Override
	public void actualizar(VentaDetalleBE object) {
		this.em.merge(object);		
	}

	@Override
	public void eliminar(VentaDetalleBE object) {
		this.em.remove(object);		
	}

	@Override
	public List<VentaDetalleBE> obtenerPorVenta(Long codigoVenta) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VentaDetalleBE> cq = cb.createQuery(VentaDetalleBE.class);
        Root<VentaDetalleBE> ventaDetalle = cq.from(VentaDetalleBE.class);
        cq
                .select(ventaDetalle)
                .where(cb.equal(ventaDetalle.get("venta").get("id"), codigoVenta))
                .orderBy(cb.desc(ventaDetalle.get("fechaActualizacion")));
        TypedQuery<VentaDetalleBE> query = this.em.createQuery(cq);
        return query.getResultList();
	}

}
