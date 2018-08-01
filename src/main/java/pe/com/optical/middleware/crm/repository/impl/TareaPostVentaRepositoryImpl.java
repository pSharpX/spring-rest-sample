package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.TareaPostVentaBE;
import pe.com.optical.middleware.crm.repository.TareaPostVentaRepository;

@Repository
public class TareaPostVentaRepositoryImpl implements TareaPostVentaRepository {
	
	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	private static final String SELECT_CRM_TAREA_POST_VENTA = "SELECT t FROM TareaPostVentaBE t";

	@Override
	public TareaPostVentaBE buscar(Long id) {
		return this.em.find(TareaPostVentaBE.class, id);
	}

	@Override
	public List<TareaPostVentaBE> obtenerTodos() {
		TypedQuery<TareaPostVentaBE> query = this.em.createQuery(SELECT_CRM_TAREA_POST_VENTA, TareaPostVentaBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(TareaPostVentaBE object) {
		this.em.persist(object);
	}

	@Override
	public void actualizar(TareaPostVentaBE object) {
		this.em.merge(object);
	}

	@Override
	public void eliminar(TareaPostVentaBE object) {
		this.em.remove(object);
	}
}
