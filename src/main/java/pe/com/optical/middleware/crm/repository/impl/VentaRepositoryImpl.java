package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.VentaBE;
import pe.com.optical.middleware.crm.repository.VentaRepository;

@Repository
public class VentaRepositoryImpl implements VentaRepository {
	
	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	 private static final String SELECT_CRM_VENTAS = "SELECT v FROM VentaBE v";

	@Override
	public VentaBE buscar(Long id) {
		 return this.em.find(VentaBE.class, id);
	}

	@Override
	public List<VentaBE> obtenerTodos() {
		TypedQuery<VentaBE> query = this.em.createQuery(SELECT_CRM_VENTAS, VentaBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(VentaBE object) {
		this.em.persist(object);
	}

	@Override
	public void actualizar(VentaBE object) {
		this.em.merge(object);
	}

	@Override
	public void eliminar(VentaBE object) {
		this.em.remove(object);
	}

	@Override
	public List<VentaBE> obtenerPorDocumento(Long idDocumento) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VentaBE> cq = cb.createQuery(VentaBE.class);
        Root<VentaBE> venta = cq.from(VentaBE.class);
        cq
                .select(venta)
                .where(cb.equal(venta.get("documento").get("id"), idDocumento))
                .orderBy(cb.desc(venta.get("fechaActualizacion")));
        TypedQuery<VentaBE> query = this.em.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public List<VentaBE> obtenerPorCliente(Long idCliente) {
		TypedQuery<VentaBE> query = this.em.createNamedQuery(
				VentaBE.NQ_OBTENER_CRM_VENTA_POR_CLIENTE, VentaBE.class);
        query.setParameter("idCliente", idCliente);
        return query.getResultList();
	}

}
