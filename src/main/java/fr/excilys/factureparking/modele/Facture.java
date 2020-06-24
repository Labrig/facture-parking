package fr.excilys.factureparking.modele;

import java.time.Duration;

import fr.excilys.factureparking.modele.vehicle.Vehicule;

public class Facture {

	private final Vehicule vehicule;
	private final Duration dureeStationnement;
	private final double montantDu;
	
	public Facture(Vehicule vehicule, Duration dureeStationnement, double montantDu) {
		this.vehicule = vehicule;
		this.dureeStationnement = dureeStationnement;
		this.montantDu = montantDu;
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public Duration getDureeStationnement() {
		return this.dureeStationnement;
	}

	public double getMontantDu() {
		return this.montantDu;
	}
	
}
