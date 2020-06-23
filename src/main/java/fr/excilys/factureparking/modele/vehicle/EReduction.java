package fr.excilys.factureparking.modele.vehicle;

import fr.excilys.factureparking.util.ParkingPropertiesLoader;

public enum EReduction {

	VOITURE("reduction.voiture"),
	MOTO("reduction.moto");

	private final double pourcentage;
	
	/**
	 * Récupère le pourcentage de réduction pour un véhicule donné
	 * 
	 * @param property, la propriété contenant le pourcentage de réduction lié au véhicule
	 */
	private EReduction(String property) {
		this.pourcentage = ParkingPropertiesLoader.getDoubleProperty(property);
	}

	public double getPourcentage() {
		return this.pourcentage;
	}
}
