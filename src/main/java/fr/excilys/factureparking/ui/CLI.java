package fr.excilys.factureparking.ui;

import java.util.Scanner;

public class CLI {

	private static final Scanner SCANNER = new Scanner(System.in);
	
	/**
	 * Demmande en console à l'utilisateur de spécifier une heure au format hh:mm
	 * 
	 * @param type, le type d'heure demandé cf. ETypeHeure
	 * @return l'entré de l'utilisateur
	 */
	public static String getHeure(ETypeHeure type) {
		System.out.println("Entrez une heure "+type.getAvecPreposition());
		System.out.println("L'heure doit être au format hh:mm");
		return SCANNER.nextLine();
	}

	/**
	 * Demmande en console à l'utilisateur de spécifier un type de véhicule
	 * par un entier
	 * 
	 * @return l'entré de l'utilisateur
	 */
	public static String getTypeVehicule() {
		System.out.println("Choisissez un type de véhicule.");
		System.out.println("Tapez 1 ou 2");
		System.out.println("1: voiture, 2: moto");
		return SCANNER.nextLine();
	}
	
	/**
	 * Affiche en console le message passé en paramètre
	 * 
	 * @param message, le message à afficher
	 */
	public static void afficherMessage(String message) {
		System.out.println(message);
	}
}
