package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.VentaCircuitoBE;
import pe.com.optical.middleware.crm.repository.VentaCircuitoRepository;

@Repository
public class VentaCircuitoRepositoryImpl implements VentaCircuitoRepository {
	
	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;

	private static final String SELECT_CRM_VENTA_CIRCUITOS = "SELECT vc FROM VentaCircuitoBE vc";
	
	@Override
	public VentaCircuitoBE buscar(Long id) {
		return this.em.find(VentaCircuitoBE.class, id);
	}

	@Override
	public List<VentaCircuitoBE> obtenerTodos() {
		TypedQuery<VentaCircuitoBE> query = this.em.createQuery(SELECT_CRM_VENTA_CIRCUITOS, VentaCircuitoBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(VentaCircuitoBE object) {
		this.em.persist(object);		
	}

	@Override
	public void actualizar(VentaCircuitoBE object) {
		this.em.merge(object);
	}

	@Override
	public void eliminar(VentaCircuitoBE object) {
		this.em.remove(object);		
	}

	@Override
	public VentaCircuitoBE obtenerPorCodigoCircuito(Long codigoCircuito) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VentaCircuitoBE> cq = cb.createQuery(VentaCircuitoBE.class);
        Root<VentaCircuitoBE> ventaCircuito = cq.from(VentaCircuitoBE.class);
        cq
                .select(ventaCircuito)
                .where(cb.and(cb.notEqual(ventaCircuito.get("codigoCircuito"), 0), cb.equal(ventaCircuito.get("codigoCircuito"), codigoCircuito)))
                .orderBy(cb.desc(ventaCircuito.get("fechaActualizacion")));
        TypedQuery<VentaCircuitoBE> query = this.em.createQuery(cq);
        return query.getSingleResult();
	}

}
