package fr.excilys.factureparking.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import fr.excilys.factureparking.modele.ETarif;
import fr.excilys.factureparking.modele.Facture;
import fr.excilys.factureparking.modele.vehicle.EPropulsion;
import fr.excilys.factureparking.modele.vehicle.Moto;
import fr.excilys.factureparking.modele.vehicle.Vehicule;
import fr.excilys.factureparking.modele.vehicle.Voiture;
import fr.excilys.factureparking.ui.CLI;
import fr.excilys.factureparking.ui.ETypeHeure;
import fr.excilys.factureparking.util.ParkingPropertiesLoader;

public class CLIController {

	private static final String MESSAGE_ERREUR = "Erreur de saisie";
	
	/**
	 * Récupère l'heure entré par un utilisateur en console et la renvoie en LocalDateTime
	 * 
	 * @param type, le type d'heure demandé cf. ETypeHeure
	 * @return l'heure entré par un utilisateur au format LocalDateTime
	 */
	public static LocalDateTime getHeure(ETypeHeure type) {
		do {
			try {
				LocalDateTime temp = LocalDateTime.of(LocalDate.now(), LocalTime.parse(CLI.getHeure(type)));
				return temp;
			} catch(DateTimeParseException e) {
				CLI.afficherMessage(MESSAGE_ERREUR);
			}
		} while(true);
	}

	/**
	 * Récupère le choix d'un véhicule par une entré utilisateur et renvoie un véhicule concret
	 * 
	 * @return un véhicule concret
	 */
	public static Vehicule getVehicule() {
		do {
			try {
				switch(Integer.valueOf(CLI.getTypeVehicule())) {
					case 1:
						return new Voiture(EPropulsion.ESSENCE);
					case 2:
						return new Moto(EPropulsion.ESSENCE);
					default:
						throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				CLI.afficherMessage(MESSAGE_ERREUR);
			}
		} while(true);
	}
	
	/**
	 * Tranforme la facture en paramètre pour pouvoir l'afficher en console à l'utilisateur
	 * 
	 * @param facture, la facture à afficher
	 */
	public static void afficherFacture(Facture facture) {
		CLI.afficherMessage(
			String.format("- véhicule : %s %s\n",
				facture.getVehicule().getClass().getSimpleName().toLowerCase(),
				facture.getVehicule().getPropulsion().name().toLowerCase())
			+String.format("- temps passé :  %dh%02d\n",
				facture.getDureeStationnement().toHours(),
				facture.getDureeStationnement().toMinutes()%60)
			+String.format("- montant dû : %.0f euros",
				facture.getMontantDu()));
	}
	
	/**
	 * Point d'entré de l'application. L'utilisateur séléctionne un type de véhicule,
	 * entre une heure d'arrivé et de départ, et enfin le programme calcule le coût du
	 * stationnement et l'affiche en console.
	 * 
	 * @param args inutilisé dans notre cas mais indispensable à toute fonction main
	 */
	public static void main(String[] args) {
		ParkingPropertiesLoader.load();
		
		//Récupération des paramètres d'entré
		Vehicule vehicule = getVehicule();
		LocalDateTime heureArrive = getHeure(ETypeHeure.ARRIVE);
		LocalDateTime heureDepart = getHeure(ETypeHeure.DEPART);
		
		//Prise en compte du cas où l'heure de départ est le lendemain de l'heure d'arrivé
		if(heureArrive.getHour() > heureDepart.getHour()) {
			heureDepart = heureDepart.plusDays(1);
		}
		
		//Calcule et affichage de la facture
		Facture facture = new Facture(vehicule, heureArrive, heureDepart, ETarif.HORAIRE);
		afficherFacture(facture);
	}
}
