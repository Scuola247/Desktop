package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.DocenteIstituto", readMethod = "docenteService.listDocenteIstituto", paging = true)
public class DocenteIstituto {
	
	@ModelField
	private Long docente;
	
	@ModelField
	private String nome_cognome;
	
	@ModelField
	private String cognome;
	
	@ModelField
	private String nome;
	
	@ModelField
	private String codice_fiscale;
	
	@ModelField
	private String foto_miniatura;
	
	public DocenteIstituto(Long docente, String nome_cognome, String cognome, String nome,
			String codice_fiscale, String foto_miniatura) {
		super();
		this.docente = docente;
		this.nome_cognome = nome_cognome;
		this.cognome = cognome;
		this.nome = nome;
		this.codice_fiscale = codice_fiscale;
		this.foto_miniatura = foto_miniatura;
	}

	public Long getDocente() {
		return docente;
	}

	public void setDocente(Long docente) {
		this.docente = docente;
	}

	public String getNome_cognome() {
		return nome_cognome;
	}

	public void setNome_cognome(String nome_cognome) {
		this.nome_cognome = nome_cognome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getFoto_miniatura() {
		return foto_miniatura;
	}

	public void setFoto_miniatura(String foto_miniatura) {
		this.foto_miniatura = foto_miniatura;
	}
	
    
	
}