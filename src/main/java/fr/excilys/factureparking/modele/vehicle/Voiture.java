package fr.excilys.factureparking.modele.vehicle;

public class Voiture extends Vehicule {

	public Voiture(EPropulsion propulsion) {
		super(propulsion, EReduction.VOITURE);
	}
}
