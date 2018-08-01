package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.OportunidadBE;
import pe.com.optical.middleware.crm.repository.OportunidadRepository;

@Repository
public class OportunidadRepositoryImpl implements OportunidadRepository {
	
	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	private static final String SELECT_CRM_OPORTUNIDADES = "SELECT o FROM OportunidadBE o";

	@Override
	public OportunidadBE buscar(Long id) {
		return this.em.find(OportunidadBE.class, id);
	}

	@Override
	public List<OportunidadBE> obtenerTodos() {
		TypedQuery<OportunidadBE> query = this.em.createQuery(SELECT_CRM_OPORTUNIDADES, OportunidadBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(OportunidadBE object) {
		this.em.persist(object);
	}

	@Override
	public void actualizar(OportunidadBE object) {
		this.em.merge(object);
	}

	@Override
	public void eliminar(OportunidadBE object) {
		this.em.remove(object);
	}

}
