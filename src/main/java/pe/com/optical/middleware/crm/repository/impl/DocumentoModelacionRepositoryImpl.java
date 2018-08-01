package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.DocumentoModelacionBE;
import pe.com.optical.middleware.crm.repository.DocumentoModelacionRepository;

@Repository
public class DocumentoModelacionRepositoryImpl implements DocumentoModelacionRepository {

	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;
	
	private static final String SELECT_CRM_DOCUMENTO_MODELACION = "SELECT dm FROM DocumentoModelacionBE dm";

	@Override
	public DocumentoModelacionBE buscar(Long id) {
		return this.em.find(DocumentoModelacionBE.class, id);
	}

	@Override
	public List<DocumentoModelacionBE> obtenerTodos() {
		TypedQuery<DocumentoModelacionBE> query = this.em.createQuery(SELECT_CRM_DOCUMENTO_MODELACION, DocumentoModelacionBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(DocumentoModelacionBE object) {
		this.em.persist(object);		
	}

	@Override
	public void actualizar(DocumentoModelacionBE object) {
		this.em.merge(object);		
	}

	@Override
	public void eliminar(DocumentoModelacionBE object) {
		this.em.remove(object);
	}

	@Override
	public List<DocumentoModelacionBE> obtenerDocumentosPorModelacion(Long codigoModelacion) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DocumentoModelacionBE> cq = cb.createQuery(DocumentoModelacionBE.class);
        Root<DocumentoModelacionBE> documentosModelacion = cq.from(DocumentoModelacionBE.class);
        cq
                .select(documentosModelacion)
                .where(cb.equal(documentosModelacion.get("modelacion").get("id"), codigoModelacion))
                .orderBy(cb.desc(documentosModelacion.get("fechaActualizacion")));
        TypedQuery<DocumentoModelacionBE> query = this.em.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public List<DocumentoModelacionBE> obtenerPorDocumento(Long codigoDocumento) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DocumentoModelacionBE> cq = cb.createQuery(DocumentoModelacionBE.class);
        Root<DocumentoModelacionBE> documentosModelacion = cq.from(DocumentoModelacionBE.class);
        cq
                .select(documentosModelacion)
                .where(cb.equal(documentosModelacion.get("documento").get("id"), codigoDocumento))
                .orderBy(cb.desc(documentosModelacion.get("fechaActualizacion")));
        TypedQuery<DocumentoModelacionBE> query = this.em.createQuery(cq);
        return query.getResultList();
	}
	
}
