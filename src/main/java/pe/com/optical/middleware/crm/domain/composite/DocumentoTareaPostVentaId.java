package pe.com.optical.middleware.crm.domain.composite;

import java.io.Serializable;
import java.util.Objects;

public class DocumentoTareaPostVentaId implements Serializable {

	private static final long serialVersionUID = -7468961223715973189L;

	private Long tareaPostVenta;
	private Long documento;

	public Long getTareaPostVenta() {
		return tareaPostVenta;
	}

	public void setTareaPostVenta(Long tareaPostVenta) {
		this.tareaPostVenta = tareaPostVenta;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DocumentoTareaPostVentaId))
			return false;
		DocumentoTareaPostVentaId that = (DocumentoTareaPostVentaId) o;
		return Objects.equals(getTareaPostVenta(), that.getTareaPostVenta())
				&& Objects.equals(getDocumento(), that.getDocumento());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTareaPostVenta(), getDocumento());
	}
}
