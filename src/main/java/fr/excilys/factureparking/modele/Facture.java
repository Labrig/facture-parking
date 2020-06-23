package fr.excilys.factureparking.modele;

import java.time.Duration;
import java.time.LocalDateTime;

import fr.excilys.factureparking.modele.vehicle.Vehicule;

public class Facture {

	private final Vehicule vehicule;
	private final Duration dureeStationement;
	private final double montantDu;
	
	public Facture(Vehicule vehicule, LocalDateTime dateDeDebut, LocalDateTime dateDeFin, ETarif tarif) {
		this.vehicule = vehicule;
		this.dureeStationement = Duration.between(dateDeDebut, dateDeFin);
		this.montantDu = tarif.calculeMontantDu(this.vehicule, this.dureeStationement);
	}

	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public Duration getDureeStationement() {
		return this.dureeStationement;
	}

	public double getMontantDu() {
		return this.montantDu;
	}
	
}
