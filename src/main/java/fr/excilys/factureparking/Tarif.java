package fr.excilys.factureparking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import fr.excilys.factureparking.vehicle.Vehicule;

public class Tarif {

	private static final Tarif INSTANCE = new Tarif();
	private int horaire;
	
	private Tarif() {
		Properties prop = new Properties();
		try(InputStream input = getClass().getClassLoader().getResourceAsStream("tarif.properties");){
			prop.load(input);
			this.horaire = Integer.valueOf(prop.getProperty("horaire"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tarif getInstance() {
		return INSTANCE;
	}
	
	public int getHoraire() throws Exception {
		return this.horaire;
	}
	
	public int calculeMontanDu(Vehicule vehicule, Duration dureeStationement) {
		double taux = 1 - vehicule.getReduction().getPourcentage()/100.0;
		int nombreHeureContabilise = (int)(dureeStationement.toHours() + (dureeStationement.toMinutes()%60 != 0 ? 1 : 0));
		return (int)(nombreHeureContabilise * this.horaire * taux);
	}
}
