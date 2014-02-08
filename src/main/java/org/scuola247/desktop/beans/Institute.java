package org.scuola247.desktop.beans;

import java.math.BigInteger;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Institutes", readMethod = "institutesService.read")
public class Institute {
	
	@ModelField
	private BigInteger istituto;
	
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
	
	public Institute(BigInteger istituto, String descrizione, String codice_meccanografico, String mnemonico, boolean esempio) {
		this.istituto = istituto;
		this.descrizione = descrizione;
		this.codice_meccanografico = codice_meccanografico;
		this.mnemonico = mnemonico;
		this.esempio = esempio;
	}
	
	public BigInteger getIstituto() {
		return istituto;
	}
	public void setIstituto(BigInteger istituto) {
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
