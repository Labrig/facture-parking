package fr.excilys.factureparking.ui;

public enum ETypeHeure {

	ARRIVE("d'arrive"), DEPART("de départ");

	private final String avecPreposition;
	
	private ETypeHeure(String avecPreposition) {
		this.avecPreposition = avecPreposition;
	}

	public String getAvecPreposition() {
		return this.avecPreposition;
	}
}
