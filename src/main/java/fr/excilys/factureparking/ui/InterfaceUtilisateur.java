package fr.excilys.factureparking.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.excilys.factureparking.modele.Facture;
import fr.excilys.factureparking.modele.vehicle.EPropulsion;
import fr.excilys.factureparking.modele.vehicle.Moto;
import fr.excilys.factureparking.modele.vehicle.Vehicule;
import fr.excilys.factureparking.modele.vehicle.Voiture;

public class InterfaceUtilisateur {

	private static final Scanner SCANNER = new Scanner(System.in);
	
	/**
	 * Permet de récupérer une heure en entré console sous le format hh:mm
	 * 
	 * @param type, le type d'heure que l'utilisateur doit rentrer
	 * @return l'heure en LocalDateTime avec la date du jour
	 */
	public static LocalDateTime getHeure(ETypeHeure type) {
		do {
			System.out.println("Entrez une heure "+type.getAvecPreposition());
			System.out.println("L'heure doit être au format hh:mm");
			try {
				return LocalDateTime.of(LocalDate.now(), LocalTime.parse(SCANNER.nextLine()));
			} catch(DateTimeParseException e) {
				System.out.println("Erreur de saisie");
			}
		} while(true);
	}

	/**
	 * Permet de récupérer un type de véhicule en entré console
	 * par l'indice 1 ou 2
	 * 
	 * @return le véhicule sélectionné
	 */
	public static Vehicule getVehicule() {
		do {
			System.out.println("Choisissez un type de véhicule.");
			System.out.println("Tapez 1 ou 2");
			System.out.println("1: voiture, 2: moto");
			try {
				switch(SCANNER.nextInt()) {
					case 1:
						return new Voiture(EPropulsion.ESSENCE);
					case 2:
						return new Moto(EPropulsion.ESSENCE);
					default:
						throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				System.out.println("Erreur de saisie");
			}
		} while(true);
	}
	
	public static void afficherFacture(Facture facture) {
		System.out.println(String.format("- véhicule : %s %s\n",
				facture.getVehicule().getClass().getSimpleName().toLowerCase(),
				facture.getVehicule().getPropulsion().name().toLowerCase())
			+String.format("- temps passé :  %dh%02d\n",
				facture.getDureeStationement().toHours(),
				facture.getDureeStationement().toMinutes()%60)
			+String.format("- montant dû : %.0f euros",
				facture.getMontantDu()));
	}
}
