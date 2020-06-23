package fr.excilys.factureparking.exception;

public class ParkingPropertyDoubleCastException extends RuntimeException {

	private final String property;
	
	public ParkingPropertyDoubleCastException(Throwable e, String property) {
		super(e);
		this.property = property;
	}
	
	@Override
	public String getMessage() {
		return String.format("La propriété %s n'est pas au format double", this.property);
	}
}
