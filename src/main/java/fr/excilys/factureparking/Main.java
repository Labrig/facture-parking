package fr.excilys.factureparking;

import java.time.LocalDateTime;

import fr.excilys.factureparking.ui.InterfaceUtilisateur;
import fr.excilys.factureparking.util.ParkingPropertiesLoader;
import fr.excilys.factureparking.modele.ETarif;
import fr.excilys.factureparking.modele.Facture;
import fr.excilys.factureparking.modele.vehicle.EReduction;
import fr.excilys.factureparking.modele.vehicle.Vehicule;
import fr.excilys.factureparking.ui.ETypeHeure;

public class Main {
	
	/**
	 * Point d'entré de l'application. L'utilisateur séléctionne un type de véhicule,
	 * entre une heure d'arrivé et de départ, et enfin le programme calcule le coût du
	 * stationnement et l'affiche en console.
	 * 
	 * @param args inutilisé dans notre cas mais indispensable à toute fonction main
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		ParkingPropertiesLoader.load();
		Class.forName(EReduction.class.getName());
		Class.forName(ETarif.class.getName());
		
		//Récupération des paramètres d'entré
		Vehicule vehicule = InterfaceUtilisateur.getVehicule();
		LocalDateTime heureArrive = InterfaceUtilisateur.getHeure(ETypeHeure.ARRIVE);
		LocalDateTime heureDepart = InterfaceUtilisateur.getHeure(ETypeHeure.DEPART);
		
		//Prise en compte du cas où l'heure de départ est le lendemain de l'heure d'arrivé
		if(heureArrive.getHour() > heureDepart.getHour()) {
			heureDepart = heureDepart.plusDays(1);
		}
		
		//Calcule et affichage de la facture
		Facture facture = new Facture(vehicule, heureArrive, heureDepart, ETarif.HORAIRE);
		InterfaceUtilisateur.afficherFacture(facture);
	}

}
