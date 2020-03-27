package Execptions;

public class DivisionParZeroException extends Exception  {
	
	
	private static final long serialVersionUID = -9154690906821473044L;
	

	public DivisionParZeroException(){
		super ("Impossible de diviser par zéro ");
	}

}
