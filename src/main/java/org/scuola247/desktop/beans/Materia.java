package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Materia", readMethod = "materiaService.list", paging = true)
public class Materia {
	
	@ModelField
	private Long rv;
	
	@ModelField
	private Long materia;

	@ModelField
	private Long istituto;

	@ModelField
	private String descrizione;

	public Materia(Long rv, Long materia, Long istituto , String descrizione) {
		super();
		this.rv = rv;
		this.istituto = istituto;
		this.materia = materia;
		this.descrizione = descrizione;
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

	public Long getMateria() {
		return materia;
	}

	public void setMateria(Long materia) {
		this.materia = materia;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}