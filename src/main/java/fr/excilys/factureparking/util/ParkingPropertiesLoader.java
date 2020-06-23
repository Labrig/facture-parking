package fr.excilys.factureparking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fr.excilys.factureparking.exception.ParkingPropertiesNotFoundException;
import fr.excilys.factureparking.exception.ParkingPropertyDoubleCastException;

public class ParkingPropertiesLoader {

	private static final Properties PROPERTIES = new Properties();
	
	public static void load() throws ParkingPropertiesNotFoundException {
		try(InputStream input = ParkingPropertiesLoader.class.getClassLoader().getResourceAsStream("parking.properties");){
			PROPERTIES.load(input);
		} catch (IOException e) {
			throw new ParkingPropertiesNotFoundException(e);
		}
	}
	
	public static double getDoubleProperty(String property) throws ParkingPropertyDoubleCastException {
		try {
			return Double.valueOf(ParkingPropertiesLoader.PROPERTIES.getProperty(property));
		} catch(NumberFormatException e) {
			throw new ParkingPropertyDoubleCastException(e, property);
		}
		
	}
}
