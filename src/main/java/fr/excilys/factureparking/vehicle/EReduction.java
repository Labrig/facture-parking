package fr.excilys.factureparking.vehicle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fr.excilys.factureparking.exception.ReductionLoadPropertiesException;

public enum EReduction {

	VOITURE("reduction.voiture"),
	MOTO("reduction.moto");

	private final int pourcentage;
	
	/**
	 * Récupère le pourcentage de réduction pour un véhicule donné
	 * 
	 * @param property, la propriété contenant le pourcentage de réduction lié au véhicule
	 */
	private EReduction(String property) {
		Properties prop = new Properties();
		try(InputStream input = getClass().getClassLoader().getResourceAsStream("tarif.properties");){
			prop.load(input);
			this.pourcentage = Integer.valueOf(prop.getProperty(property));
		} catch (IOException | NumberFormatException e) {
			throw new ReductionLoadPropertiesException(e);
		}
	}

	public int getPourcentage() {
		return this.pourcentage;
	}
}
