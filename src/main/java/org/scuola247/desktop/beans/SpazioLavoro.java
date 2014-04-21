package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.SpazioLavoro", createMethod = "spazioLavoroService.ins", readMethod = "spazioLavoroService.list", destroyMethod = "spazioLavoroService.del", paging = true)
public class SpazioLavoro {
	
	@ModelField
	private Long rv;
	
	@ModelField
	private Long spazio_lavoro;

	@ModelField
	private String descrizione;
	
	@ModelField
	private Long istituto;
	
	@ModelField
	private Long anno_scolastico;
	
	@ModelField
	private Long classe;
	
	@ModelField
	private Long materia;
	
	@ModelField
	private Long docente;
	
	@ModelField
	private Long famigliare;
	
	@ModelField
	private Long alunno;
	
	@ModelField
	private boolean spazio_lavoro_default;
	
	public SpazioLavoro() {
		
	}

	public SpazioLavoro(Long rv, Long spazio_lavoro, String descrizione, Long istituto,
			Long anno_scolastico, Long classe, Long materia, Long docente, Long famigliare, Long alunno, boolean spazio_lavoro_default) {
		super();
		this.rv = rv;
		this.spazio_lavoro = spazio_lavoro;
		this.descrizione = descrizione;
		this.istituto = istituto;
		this.anno_scolastico = anno_scolastico;
		this.classe = classe;
		this.materia = materia;
		this.docente = docente;
		this.famigliare = famigliare;
		this.alunno = alunno;
		this.spazio_lavoro_default = spazio_lavoro_default;
	}

	public Long getRv() {
		return rv;
	}

	public void setRv(Long rv) {
		this.rv = rv;
	}

	public Long getSpazio_lavoro() {
		return spazio_lavoro;
	}

	public void setSpazio_lavoro(Long spazio_lavoro) {
		this.spazio_lavoro = spazio_lavoro;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getIstituto() {
		return istituto;
	}

	public void setIstituto(Long istituto) {
		this.istituto = istituto;
	}

	public Long getAnno_scolastico() {
		return anno_scolastico;
	}

	public void setAnno_scolastico(Long anno_scolastico) {
		this.anno_scolastico = anno_scolastico;
	}

	public Long getClasse() {
		return classe;
	}

	public void setClasse(Long classe) {
		this.classe = classe;
	}

	public Long getMateria() {
		return materia;
	}

	public void setMateria(Long materia) {
		this.materia = materia;
	}

	public Long getDocente() {
		return docente;
	}

	public void setDocente(Long docente) {
		this.docente = docente;
	}

	public Long getFamigliare() {
		return famigliare;
	}

	public void setFamigliare(Long famigliare) {
		this.famigliare = famigliare;
	}

	public Long getAlunno() {
		return alunno;
	}

	public void setAlunno(Long alunno) {
		this.alunno = alunno;
	}

	public boolean isSpazio_lavoro_default() {
		return spazio_lavoro_default;
	}

	public void setSpazio_lavoro_default(boolean spazio_lavoro_default) {
		this.spazio_lavoro_default = spazio_lavoro_default;
	}

	
}
