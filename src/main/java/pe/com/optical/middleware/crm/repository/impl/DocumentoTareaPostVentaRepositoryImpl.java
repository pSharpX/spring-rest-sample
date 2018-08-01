package pe.com.optical.middleware.crm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.com.optical.middleware.crm.domain.DocumentoTareaPostVentaBE;
import pe.com.optical.middleware.crm.repository.DocumentoTareaPostVentaRepository;

@Repository
public class DocumentoTareaPostVentaRepositoryImpl implements DocumentoTareaPostVentaRepository {

	@PersistenceContext(unitName = "CRM_PERSISTENCE_UNIT")
    private EntityManager em;

	private static final String SELECT_CRM_DOCUMENTO_TAREA_POST_VENTA = "SELECT dt FROM DocumentoTareaPostVentaBE dt";
	
	@Override
	public DocumentoTareaPostVentaBE buscar(Long id) {
		return this.em.find(DocumentoTareaPostVentaBE.class, id);
	}

	@Override
	public List<DocumentoTareaPostVentaBE> obtenerTodos() {
		TypedQuery<DocumentoTareaPostVentaBE> query = this.em.createQuery(SELECT_CRM_DOCUMENTO_TAREA_POST_VENTA, DocumentoTareaPostVentaBE.class);
        return query.getResultList();
	}

	@Override
	public void crear(DocumentoTareaPostVentaBE object) {
		this.em.persist(object);		
	}

	@Override
	public void actualizar(DocumentoTareaPostVentaBE object) {
		this.em.merge(object);
	}

	@Override
	public void eliminar(DocumentoTareaPostVentaBE object) {
		this.em.remove(object);
	}

	@Override
	public List<DocumentoTareaPostVentaBE> obtenerDocumentosPorTareaPostVenta(Long codigoTareaPostVenta) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DocumentoTareaPostVentaBE> cq = cb.createQuery(DocumentoTareaPostVentaBE.class);
        Root<DocumentoTareaPostVentaBE> documentosTareaPostVenta = cq.from(DocumentoTareaPostVentaBE.class);
        cq
                .select(documentosTareaPostVenta)
                .where(cb.equal(documentosTareaPostVenta.get("tareaPostVenta").get("id"), codigoTareaPostVenta))
                .orderBy(cb.desc(documentosTareaPostVenta.get("fechaActualizacion")));
        TypedQuery<DocumentoTareaPostVentaBE> query = this.em.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public List<DocumentoTareaPostVentaBE> obtenerPorDocumento(Long codigoDocumento) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DocumentoTareaPostVentaBE> cq = cb.createQuery(DocumentoTareaPostVentaBE.class);
        Root<DocumentoTareaPostVentaBE> documentosTareaPostVenta = cq.from(DocumentoTareaPostVentaBE.class);
        cq
                .select(documentosTareaPostVenta)
                .where(cb.equal(documentosTareaPostVenta.get("documento").get("id"), codigoDocumento))
                .orderBy(cb.desc(documentosTareaPostVenta.get("fechaActualizacion")));
        TypedQuery<DocumentoTareaPostVentaBE> query = this.em.createQuery(cq);
        return query.getResultList();
	}

}
