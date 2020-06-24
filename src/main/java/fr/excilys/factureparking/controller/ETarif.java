package fr.excilys.factureparking.controller;

import java.time.Duration;

import fr.excilys.factureparking.modele.vehicle.Vehicule;
import fr.excilys.factureparking.util.ParkingPropertiesLoader;

public enum ETarif {
	
	HORAIRE("tarif.horaire");
	
	private final double valeur;
	
	/**
	 * Récupère la valeur du tarif pour un tranche donné
	 * 
	 * @param property, la propriété contenant la valeur du tarif lié à sa tranche
	 */
	private ETarif(String property) {
		this.valeur = ParkingPropertiesLoader.getDoubleProperty(property);
	}

	public double getValeur() {
		return this.valeur;
	}
	
	/**
	 * Calcule le montant dû à la sortie du parking en fonction du vehicule et de sa durée de stationnement
	 * 
	 * @param vehicule, le véhicule sortant duparking
	 * @param dureeStationnement, la durée de sationnement du véhicule
	 * @return le montant dû en euros
	 */
	public double calculeMontantDu(Vehicule vehicule, Duration dureeStationnement) {
		double taux = 1 - vehicule.getReduction().getPourcentage();
		long nombreHeureContabilise = dureeStationnement.toHours() + (dureeStationnement.toMinutes()%60 != 0 ? 1 : 0);
		return nombreHeureContabilise * this.valeur * taux;
	}
}
