package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Institutes", readMethod = "institutesService.sel", destroyMethod = "institutesService.del", paging = true)
public class Institute {
	
	@ModelField
	private Long rv;

	@ModelField
	private Long istituto;
	
	@ModelField
	private String descrizione;
	
	@ModelField
	private String codice_meccanografico;
	
	@ModelField
	private String mnemonico;
	
	@ModelField
	private boolean esempio;
	
	public Institute() {
		
	}
	
	public Institute(Long rv, Long istituto, String descrizione, String codice_meccanografico, String mnemonico, boolean esempio) {
		this.setRv(rv);
		this.istituto = istituto;
		this.descrizione = descrizione;
		this.codice_meccanografico = codice_meccanografico;
		this.mnemonico = mnemonico;
		this.esempio = esempio;
	}
	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}
	
	public Long getIstituto() {
		return istituto;
	}
	public void setIstituto(Long istituto) {
		this.istituto = istituto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCodice_meccanografico() {
		return codice_meccanografico;
	}
	public void setCodice_meccanografico(String codice_meccanografico) {
		this.codice_meccanografico = codice_meccanografico;
	}
	public String getMnemonico() {
		return mnemonico;
	}
	public void setMnemonico(String mnemonico) {
		this.mnemonico = mnemonico;
	}
	public boolean isEsempio() {
		return esempio;
	}
	public void setEsempio(boolean esempio) {
		this.esempio = esempio;
	}
}
