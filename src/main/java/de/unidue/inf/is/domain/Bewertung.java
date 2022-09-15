package de.unidue.inf.is.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Bewertung {
       private int id;
       private String textnachricht;
       private LocalDateTime erstellungsdatum;
       private int rating ;
	public Bewertung(int id, String textnachricht, LocalDateTime erstellungsdatum, int rating) {
		super();
		this.id = id;
		this.textnachricht = textnachricht;
		this.erstellungsdatum = erstellungsdatum;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTextnachricht() {
		return textnachricht;
	}
	public void setTextnachricht(String textnachricht) {
		this.textnachricht = textnachricht;
	}
	public LocalDateTime getErstellungsdatum() {
		return erstellungsdatum;
	}
	public void setErstellungsdatum(LocalDateTime erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
       
       
}
