package fr.excilys.factureparking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fr.excilys.factureparking.controller.ETarif;
import fr.excilys.factureparking.exception.ParkingPropertiesNotFoundException;
import fr.excilys.factureparking.exception.ParkingPropertyDoubleCastException;
import fr.excilys.factureparking.modele.vehicle.EReduction;

public class ParkingPropertiesLoader {

	private static final String PROPERTIES_FILENAME = "parking.properties";
	private static final Properties PROPERTIES = new Properties();
	
	/**
	 * Charge l'ensemble des proprités essentielles à la vie de l'application.
	 * En cas d'échec, l'application ne doit pas démarrer.
	 * 
	 * @throws ParkingPropertiesNotFoundException si le fichier de propriété est introuvable
	 */
	public static void load() throws ParkingPropertiesNotFoundException {
		try(InputStream input = ParkingPropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);){
			PROPERTIES.load(input);
			Class.forName(EReduction.class.getName());
			Class.forName(ETarif.class.getName());
		} catch (IOException | ClassNotFoundException e) {
			throw new ParkingPropertiesNotFoundException(e);
		}
	}
	
	/**
	 * Permet de récupéré une propriété du fichier de propriété au format double
	 * 
	 * @param property, la propriété souhaité
	 * @return la valeur de la propriété au format double
	 * @throws ParkingPropertyDoubleCastException si la valeur de la proprité ne peut pas être convertie en double
	 */
	public static double getDoubleProperty(String property) throws ParkingPropertyDoubleCastException {
		try {
			return Double.valueOf(ParkingPropertiesLoader.PROPERTIES.getProperty(property));
		} catch(NumberFormatException e) {
			throw new ParkingPropertyDoubleCastException(e, property);
		}
		
	}
}
