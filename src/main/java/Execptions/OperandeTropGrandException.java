package Execptions;

public class OperandeTropGrandException extends Exception {

	private static final long serialVersionUID = -1980516901125337636L;

	public OperandeTropGrandException(){
		super("Operande trop grande, la valeur de l' Operande dois etre <= 4000000");
	}
	

}
