package fr.excilys.factureparking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.excilys.factureparking.ui.ETypeHeure;
import fr.excilys.factureparking.vehicle.EPropulsion;
import fr.excilys.factureparking.vehicle.Moto;
import fr.excilys.factureparking.vehicle.Vehicule;
import fr.excilys.factureparking.vehicle.Voiture;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Point d'entré de l'application. L'utilisateur séléctionne un type de véhicule,
	 * entre une heure d'arrivé et de départ, et enfin le programme calcule le coût du
	 * stationnement et l'affiche en console.
	 * 
	 * @param args inutilisé dans notre cas mais indispensable à toute fonction main
	 */
	public static void main(String[] args) {
		//Récupération des paramètres d'entré
		Vehicule vehicule = getVehicule();
		LocalDateTime heureArrive = getHeure(ETypeHeure.ARRIVE);
		LocalDateTime heureDepart = getHeure(ETypeHeure.DEPART);
		
		//Prise en compte du cas où l'heure de départ est le lendemain de l'heure d'arrivé
		if(heureArrive.getHour() > heureDepart.getHour()) {
			heureDepart = heureDepart.plusDays(1);
		}
		
		//Calcule et affichage de la facture
		Facture facture = new Facture(vehicule, heureArrive, heureDepart);
		System.out.println(facture.toString());
	}

	/**
	 * Permet de récupérer une heure en entré console sous le format hh:mm
	 * 
	 * @param type, le type d'heure que l'utilisateur doit rentrer
	 * @return l'heure en LocalDateTime avec la date du jour
	 */
	private static LocalDateTime getHeure(ETypeHeure type) {
		do {
			System.out.println("Entrez une heure "+type.getAvecPreposition());
			System.out.println("L'heure doit être au format hh:mm");
			try {
				return LocalDateTime.of(LocalDate.now(), LocalTime.parse(scan.nextLine()));
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
	private static Vehicule getVehicule() {
		do {
			System.out.println("Choisissez un type de véhicule.");
			System.out.println("Tapez 1 ou 2");
			System.out.println("1: voiture, 2: moto");
			try {
				switch(scan.nextInt()) {
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

}
