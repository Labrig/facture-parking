package fr.excilys.factureparking;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.excilys.factureparking.modele.ETarif;
import fr.excilys.factureparking.modele.vehicle.EPropulsion;
import fr.excilys.factureparking.modele.vehicle.Moto;
import fr.excilys.factureparking.modele.vehicle.Voiture;
import fr.excilys.factureparking.util.ParkingPropertiesLoader;

class ETarifTest {

	private Voiture voiture;
	private Moto moto;
	
	@BeforeEach
	void setUp() {
		ParkingPropertiesLoader.load();
		this.voiture = new Voiture(EPropulsion.ESSENCE);
		this.moto = new Moto(EPropulsion.ESSENCE);
	}
	
	@Test
	void testCalculeMontantVoitureDureePositive() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.voiture, Duration.ofMinutes(2));
		assertEquals(2, result);
	}
	
	@Test
	void testCalculeMontantVoitureDureePositive2() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.voiture, Duration.ofHours(4));
		assertEquals(8, result);
	}
	
	@Test
	void testCalculeMontantVoitureDureeNul() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.voiture, Duration.ofMinutes(0));
		assertEquals(0, result);
	}
	
	@Test
	void testCalculeMontantVoitureDureeNegative() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.voiture, Duration.ofMinutes(-2));
		assertEquals(2, result);
	}
	
	@Test
	void testCalculeMontantMotoDureePositive() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.moto, Duration.ofMinutes(2));
		assertEquals(1, result);
	}
	
	@Test
	void testCalculeMontantMotoDureePositive2() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.moto, Duration.ofHours(4));
		assertEquals(4, result);
	}
	
	@Test
	void testCalculeMontantMotoDureeNul() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.moto, Duration.ofMinutes(0));
		assertEquals(0, result);
	}
	
	@Test
	void testCalculeMontantMotoDureeNegative() {
		double result = ETarif.HORAIRE.calculeMontantDu(this.moto, Duration.ofMinutes(-2));
		assertEquals(1, result);
	}

}
