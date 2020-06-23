package fr.excilys.factureparking.vehicule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.excilys.factureparking.modele.vehicle.EReduction;
import fr.excilys.factureparking.util.ParkingPropertiesLoader;

class EReductionTest {

	@BeforeEach
	void setUp() {
		ParkingPropertiesLoader.load();
	}
	
	@Test
	void testPourcentageVoiture() {
		assertEquals(0, EReduction.VOITURE.getPourcentage());
	}
	
	@Test
	void testPourcentageMoto() {
		assertEquals(0.5, EReduction.MOTO.getPourcentage());
	}

}
