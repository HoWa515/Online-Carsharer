package de.unidue.inf.is.domain;

public class OffenFahrt {
	int id;
	String von;
	String nach;
	int freiePlaetze;
	double fahrkosten;
	
	public OffenFahrt(int id, String von, String nach, int freiePlaetze, double fahrkosten) {
		super();
		this.id = id;
		this.von = von;
		this.nach = nach;
		this.freiePlaetze = freiePlaetze;
		this.fahrkosten = fahrkosten;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getNach() {
		return nach;
	}

	public void setNach(String nach) {
		this.nach = nach;
	}

	public int getFreiePlaetze() {
		return freiePlaetze;
	}

	public void setFreiePlaetze(int freiePlaetze) {
		this.freiePlaetze = freiePlaetze;
	}

	public double getFahrkosten() {
		return fahrkosten;
	}

	public void setFahrkosten(double fahrkosten) {
		this.fahrkosten = fahrkosten;
	}
	
	
	
	

}
