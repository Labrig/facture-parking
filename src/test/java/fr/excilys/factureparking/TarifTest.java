package fr.excilys.factureparking;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.excilys.factureparking.vehicle.EPropulsion;
import fr.excilys.factureparking.vehicle.Moto;
import fr.excilys.factureparking.vehicle.Voiture;

class TarifTest {

	private Voiture voiture;
	private Moto moto;
	
	@BeforeEach
	void setUp() {
		this.voiture = new Voiture(EPropulsion.ESSENCE);
		this.moto = new Moto(EPropulsion.ESSENCE);
	}
	
	@Test
	void testCalculeMontantVoitureDureePositive() {
		double result = Tarif.getInstance().calculeMontanDu(this.voiture, Duration.ofMinutes(2));
		assertEquals(2, result);
	}
	
	@Test
	void testCalculeMontantVoitureDureePositive2() {
		double result = Tarif.getInstance().calculeMontanDu(this.voiture, Duration.ofHours(4));
		assertEquals(8, result);
	}
	
	@Test
	void testCalculeMontantVoitureDureeNul() {
		double result = Tarif.getInstance().calculeMontanDu(this.voiture, Duration.ofMinutes(0));
		assertEquals(0, result);
	}
	
	@Test
	void testCalculeMontantVoitureDureeNegative() {
		double result = Tarif.getInstance().calculeMontanDu(this.voiture, Duration.ofMinutes(-2));
		assertEquals(2, result);
	}
	
	@Test
	void testCalculeMontantMotoDureePositive() {
		double result = Tarif.getInstance().calculeMontanDu(this.moto, Duration.ofMinutes(2));
		assertEquals(1, result);
	}
	
	@Test
	void testCalculeMontantMotoDureePositive2() {
		double result = Tarif.getInstance().calculeMontanDu(this.moto, Duration.ofHours(4));
		assertEquals(4, result);
	}
	
	@Test
	void testCalculeMontantMotoDureeNul() {
		double result = Tarif.getInstance().calculeMontanDu(this.moto, Duration.ofMinutes(0));
		assertEquals(0, result);
	}
	
	@Test
	void testCalculeMontantMotoDureeNegative() {
		double result = Tarif.getInstance().calculeMontanDu(this.moto, Duration.ofMinutes(-2));
		assertEquals(1, result);
	}

}
