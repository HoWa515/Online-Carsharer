package de.unidue.inf.is.domain;

public class Reserve {
     int kunde;
     int fahrt;
     int reserP;  //1 or 2
	public Reserve(int kunde, int fahrt, int reserP) {
		super();
		this.kunde = kunde;
		this.fahrt = fahrt;
		this.reserP = reserP;
	}
	public int getKunde() {
		return kunde;
	}
	public void setKunde(int kunde) {
		this.kunde = kunde;
	}
	public int getFahrt() {
		return fahrt;
	}
	public void setFahrt(int fahrt) {
		this.fahrt = fahrt;
	}
	public int getReserP() {
		return reserP;
	}
	public void setReserP(int reserP) {
		this.reserP = reserP;
	}
     
     
     
}
