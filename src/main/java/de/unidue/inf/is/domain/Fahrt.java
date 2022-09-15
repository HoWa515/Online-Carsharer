package de.unidue.inf.is.domain;

import java.util.Date;

public class Fahrt {
	private int id;
	private String startort;
	private String zielort;
  	private Date fahrtdatumzeit;  
	private int maxPlaetze;  
	private double fahrtkosten; 
	private String status;  
  	private int anbieter;
  	private int transportmittel;
  	private String beschreibung;
	public Fahrt(int id,int anbieter,Date fahrtdatumzeit,String startort, String zielort, int maxPlaetze, double fahrtkosten,
			String status, String beschreibung) {
		super();
		this.id=id;
		this.startort = startort;
		this.zielort = zielort;
		this.fahrtdatumzeit = fahrtdatumzeit;
		this.maxPlaetze = maxPlaetze;
		this.fahrtkosten = fahrtkosten;
		this.status = status;
		this.anbieter = anbieter;
		 
		this.beschreibung = beschreibung;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartort() {
		return startort;
	}
	public void setStartort(String startort) {
		this.startort = startort;
	}
	public String getZielort() {
		return zielort;
	}
	public void setZielort(String zielort) {
		this.zielort = zielort;
	}
	public Date getFahrtdatumzeit() {
		return fahrtdatumzeit;
	}
	public void setFahrtdatumzeit(Date fahrtdatumzeit) {
		this.fahrtdatumzeit = fahrtdatumzeit;
	}
	public int getMaxPlaetze() {
		return maxPlaetze;
	}
	public void setMaxPlaetze(int maxPlaetze) {
		this.maxPlaetze = maxPlaetze;
	}
	public double getFahrtkosten() {
		return fahrtkosten;
	}
	public void setFahrtkosten(double fahrtkosten) {
		this.fahrtkosten = fahrtkosten;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAnbieter() {
		return anbieter;
	}
	public void setAnbieter(int anbieter) {
		this.anbieter = anbieter;
	}
	public int getTransportmittel() {
		return transportmittel;
	}
	public void setTransportmittel(int transportmittel) {
		this.transportmittel = transportmittel;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
  	
  	

}
