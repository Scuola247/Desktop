package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.ValutazioneAlunno", readMethod = "valutazioniService.listValutazioniByClasse", paging = true)
public class ValutazioneAlunno {
	
	@ModelField
	private Long alunno;

	@ModelField
	private String foto_miniatura;
	
	@ModelField
	private String cognome;
	
	@ModelField
	private String nome;
	
	public ValutazioneAlunno(Long alunno, String foto_miniatura, String cognome, String nome) {
		super();
		this.alunno = alunno;
		this.foto_miniatura = foto_miniatura;
		this.cognome = cognome;
		this.nome = nome;
	}

	public Long getAlunno() {
		return alunno;
	}

	public void setAlunno(Long alunno) {
		this.alunno = alunno;
	}

	public String getFoto_miniatura() {
		return foto_miniatura;
	}

	public void setFoto_miniatura(String foto_miniatura) {
		this.foto_miniatura = foto_miniatura;
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
}