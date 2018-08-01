package pe.com.optical.middleware.crm.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentoDto implements Serializable {
	
	private static final long serialVersionUID = 6033017083225145940L;
	
	private int documentoId;
	private String codigoDocumento;
	private int codigoOS;
	private String codigoTipo;
	public String codigoOrigenAutorizacion;
    public String usuario;	
		
	public DocumentoDto() {
		super();
	}

	public DocumentoDto(int documentoId, String codigoDocumento, int codigoOS, String codigoTipo,
			String codigoOrigenAutorizacion, String usuario) {
		super();
		this.documentoId = documentoId;
		this.codigoDocumento = codigoDocumento;
		this.codigoOS = codigoOS;
		this.codigoTipo = codigoTipo;
		this.codigoOrigenAutorizacion = codigoOrigenAutorizacion;
		this.usuario = usuario;
	}

	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}

	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public int getCodigoOS() {
		return codigoOS;
	}

	public void setCodigoOS(int codigoOS) {
		this.codigoOS = codigoOS;
	}

	public String getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(String codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public String getCodigoOrigenAutorizacion() {
		return codigoOrigenAutorizacion;
	}

	public void setCodigoOrigenAutorizacion(String codigoOrigenAutorizacion) {
		this.codigoOrigenAutorizacion = codigoOrigenAutorizacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
