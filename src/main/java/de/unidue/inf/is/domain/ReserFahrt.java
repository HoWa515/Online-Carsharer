package de.unidue.inf.is.domain;

public class ReserFahrt {
	private int id;
	private int kunde;
	private String von;
	private String nach;
	private String status;
	public ReserFahrt(int id, int kunde, String von, String nach, String status) {
		super();
		this.id = id;
		this.kunde = kunde;
		this.von = von;
		this.nach = nach;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKunde() {
		return kunde;
	}
	public void setKunde(int kunde) {
		this.kunde = kunde;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
