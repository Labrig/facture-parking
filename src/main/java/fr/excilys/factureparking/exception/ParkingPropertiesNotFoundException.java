package fr.excilys.factureparking.exception;

public class ParkingPropertiesNotFoundException extends RuntimeException {

	public ParkingPropertiesNotFoundException(Throwable e) {
		super(e);
	}
	
	@Override
	public String getMessage() {
		return "Le fichier de proprité du parking est introuvable.";
	}
}
