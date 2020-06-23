package fr.excilys.factureparking.modele.vehicle;

public abstract class Vehicule {

	private final EPropulsion propulsion;
	private final EReduction reduction;
	
	public Vehicule(EPropulsion propulsion, EReduction reduction) {
		this.propulsion = propulsion;
		this.reduction = reduction;
	}

	public EPropulsion getPropulsion() {
		return this.propulsion;
	}

	public EReduction getReduction() {
		return this.reduction;
	}
	
}
