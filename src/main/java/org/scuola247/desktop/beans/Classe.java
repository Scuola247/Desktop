package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.Classe", readMethod = "classeService.list", paging = true)
public class Classe {
	
	@ModelField
	private Long rv;
	
	@ModelField
	private Long classe;
	
	@ModelField
	private Long anno_scolastico;
	
	@ModelField
	private Long indirizzo_scolastico;
	
	@ModelField
	private String sezione;

	@ModelField
	private Long anno_corso;

	@ModelField
	private String descrizione;
	
	@ModelField
	private Long plesso;

	public Classe(Long rv, Long classe, Long anno_scolastico,
			Long indirizzo_scolastico, String sezione, Long anno_corso,
			String descrizione, Long plesso) {
		super();
		this.rv = rv;
		this.classe = classe;
		this.anno_scolastico = anno_scolastico;
		this.indirizzo_scolastico = indirizzo_scolastico;
		this.sezione = sezione;
		this.anno_corso = anno_corso;
		this.descrizione = descrizione;
		this.plesso = plesso;
	}

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getClasse() {
		return classe;
	}

	public void setClasse(Long classe) {
		this.classe = classe;
	}

	public Long getAnno_scolastico() {
		return anno_scolastico;
	}

	public void setAnno_scolastico(Long anno_scolastico) {
		this.anno_scolastico = anno_scolastico;
	}

	public Long getIndirizzo_scolastico() {
		return indirizzo_scolastico;
	}

	public void setIndirizzo_scolastico(Long indirizzo_scolastico) {
		this.indirizzo_scolastico = indirizzo_scolastico;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public Long getAnno_corso() {
		return anno_corso;
	}

	public void setAnno_corso(Long anno_corso) {
		this.anno_corso = anno_corso;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getPlesso() {
		return plesso;
	}

	public void setPlesso(Long plesso) {
		this.plesso = plesso;
	}

}