package fr.excilys.factureparking;

import java.time.Duration;
import java.time.LocalDateTime;

import fr.excilys.factureparking.vehicle.Vehicule;

public class Facture {

	private final Vehicule vehicule;
	private final Duration dureeStationement;
	private final double montantDu;
	
	public Facture(Vehicule vehicule, LocalDateTime dateDeDebut, LocalDateTime dateDeFin) {
		this.vehicule = vehicule;
		this.dureeStationement = Duration.between(dateDeDebut, dateDeFin);
		this.montantDu = Tarif.getInstance().calculeMontanDu(this.vehicule, this.dureeStationement);
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
	
	@Override
	public String toString() {
		return String.format("- véhicule : %s %s\n",
					this.vehicule.getClass().getSimpleName().toLowerCase(),
					this.vehicule.getPropulsion().name().toLowerCase())
				+String.format("- temps passé :  %dh%d\n",
					this.dureeStationement.toHours(),
					this.dureeStationement.toMinutes()%60)
				+String.format("- montant dû : %d euros",
					this.montantDu);
	}
}
