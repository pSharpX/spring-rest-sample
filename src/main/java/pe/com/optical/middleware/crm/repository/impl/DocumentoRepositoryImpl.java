package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.DocumentoBE;
import pe.com.optical.middleware.crm.repository.DocumentoRepository;

@Repository
public class DocumentoRepositoryImpl implements DocumentoRepository {

	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	private static final String SELECT_CRM_DOCUMENTOS = "SELECT v FROM DocumentoBE v";
	
	@Override
	public DocumentoBE buscar(Long id) {
		return this.em.find(DocumentoBE.class, id);
	}

	@Override
	public List<DocumentoBE> obtenerTodos() {
		TypedQuery<DocumentoBE> query = this.em.createQuery(SELECT_CRM_DOCUMENTOS, DocumentoBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(DocumentoBE object) {
		this.em.persist(object);		
	}

	@Override
	public void actualizar(DocumentoBE object) {
		this.em.merge(object);
	}

	@Override
	public void eliminar(DocumentoBE object) {
		this.em.remove(object);
	}

}
