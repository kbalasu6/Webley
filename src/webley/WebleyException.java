package webley;

@SuppressWarnings("serial")
public class WebleyException extends Exception {
	private String errorCode;
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	private String errorMessage;
	WebleyException(String eCode, String eMessage){
		super(eMessage);
		this.errorCode=eCode;
		this.errorMessage = eMessage;
	}
	
	
	
	
}
