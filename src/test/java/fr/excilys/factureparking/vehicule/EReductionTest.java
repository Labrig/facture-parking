package fr.excilys.factureparking.vehicule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.excilys.factureparking.vehicle.EReduction;

class EReductionTest {

	@Test
	void testPourcentageVoiture() {
		assertEquals(0, EReduction.VOITURE.getPourcentage());
	}
	
	@Test
	void testPourcentageMoto() {
		assertEquals(50, EReduction.MOTO.getPourcentage());
	}

}
