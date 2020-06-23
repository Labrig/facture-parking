package fr.excilys.factureparking.modele;

import java.time.Duration;

import fr.excilys.factureparking.modele.vehicle.Vehicule;
import fr.excilys.factureparking.util.ParkingPropertiesLoader;

public enum ETarif {
	
	HORAIRE("tarif.horaire");
	
	private final double valeur;
	
	private ETarif(String property) {
		this.valeur = ParkingPropertiesLoader.getDoubleProperty(property);
	}

	public double getValeur() {
		return this.valeur;
	}
	
	public double calculeMontantDu(Vehicule vehicule, Duration dureeStationement) {
		double taux = 1 - vehicule.getReduction().getPourcentage();
		long nombreHeureContabilise = dureeStationement.toHours() + (dureeStationement.toMinutes()%60 != 0 ? 1 : 0);
		return nombreHeureContabilise * this.valeur * taux;
	}
}
