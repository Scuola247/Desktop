package org.scuola247.desktop.beans;

import java.util.Date;

import org.joda.time.DateTime;

import ch.rasc.edsutil.jackson.ISO8601DateTimeSerializer;
import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Model(value = "Desktop.model.AlunnoEx", readMethod="alunnoService.listClasseAlunniEx", paging=true)
public class AlunnoEx {
	@ModelField
	private Long classe;
	
	@ModelField
	private Long alunno;
	
	@ModelField
	private String foto_miniatura;
	
	@ModelField
	private String codice_fiscale;
	
	@ModelField
	private String nome;
	
	@ModelField
	private String cognome;
	
	@ModelField
	private String sesso;
	
	@ModelField(dateFormat = "c")
	private DateTime nato;
	
	@ModelField
	private String comune_nascita_descrizione;
	
	@ModelField
	private Long assenze;
	
	@ModelField
	private Long assenze_non_giustificate;
	
	@ModelField
	private Long ritardi;
	
	@ModelField
	private Long ritardi_non_giustificati;
	
	@ModelField
	private Long uscite;
	
	@ModelField
	private Long uscite_non_giustificate;
	
	@ModelField
	private Long fuori_classi;

	@ModelField
	private Long note;

	public AlunnoEx(Long classe, Long alunno, String foto_miniatura, String codice_fiscale,
			String nome, String cognome, String sesso, Date nato,
			String comune_nascita_descrizione, Long assenze,
			Long assenze_non_giustificate, Long ritardi,
			Long ritardi_non_giustificati, Long uscite,
			Long uscite_non_giustificate, Long fuori_classi, Long note) {
		super();
		this.classe = classe;
		this.alunno = alunno;
		this.foto_miniatura = foto_miniatura;
		this.codice_fiscale = codice_fiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.nato = new DateTime(nato);
		this.comune_nascita_descrizione = comune_nascita_descrizione;
		this.assenze = assenze;
		this.assenze_non_giustificate = assenze_non_giustificate;
		this.ritardi = ritardi;
		this.ritardi_non_giustificati = ritardi_non_giustificati;
		this.uscite = uscite;
		this.uscite_non_giustificate = uscite_non_giustificate;
		this.fuori_classi = fuori_classi;
		this.note = note;
	}

	public Long getClasse() {
		return classe;
	}

	public void setClasse(Long classe) {
		this.classe = classe;
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

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	@JsonSerialize(using = ISO8601DateTimeSerializer.class)
	public DateTime getNato() {
		return nato;
	}

	public void setNato(DateTime nato) {
		this.nato = nato;
	}

	public String getComune_nascita_descrizione() {
		return comune_nascita_descrizione;
	}

	public void setComune_nascita_descrizione(String comune_nascita_descrizione) {
		this.comune_nascita_descrizione = comune_nascita_descrizione;
	}

	public Long getAssenze() {
		return assenze;
	}

	public void setAssenze(Long assenze) {
		this.assenze = assenze;
	}

	public Long getAssenze_non_giustificate() {
		return assenze_non_giustificate;
	}

	public void setAssenze_non_giustificate(Long assenze_non_giustificate) {
		this.assenze_non_giustificate = assenze_non_giustificate;
	}

	public Long getRitardi() {
		return ritardi;
	}

	public void setRitardi(Long ritardi) {
		this.ritardi = ritardi;
	}

	public Long getRitardi_non_giustificati() {
		return ritardi_non_giustificati;
	}

	public void setRitardi_non_giustificati(Long ritardi_non_giustificati) {
		this.ritardi_non_giustificati = ritardi_non_giustificati;
	}

	public Long getUscite() {
		return uscite;
	}

	public void setUscite(Long uscite) {
		this.uscite = uscite;
	}

	public Long getUscite_non_giustificate() {
		return uscite_non_giustificate;
	}

	public void setUscite_non_giustificate(Long uscite_non_giustificate) {
		this.uscite_non_giustificate = uscite_non_giustificate;
	}

	public Long getFuori_classi() {
		return fuori_classi;
	}

	public void setFuori_classi(Long fuori_classi) {
		this.fuori_classi = fuori_classi;
	}

	public Long getNote() {
		return note;
	}

	public void setNote(Long note) {
		this.note = note;
	}
	
}