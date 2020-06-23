package fr.excilys.factureparking.exception;

public class ReductionLoadPropertiesException extends RuntimeException {

	public ReductionLoadPropertiesException(Throwable exception) {
		super(exception);
	}
	
	@Override
	public String getMessage() {
		return "Un problème est survenu lors du chargement des propriétés de réduction.";
	}
}
