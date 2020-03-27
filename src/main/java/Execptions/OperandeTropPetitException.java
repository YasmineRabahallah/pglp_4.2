package Execptions;

public class OperandeTropPetitException  extends Exception {

	private static final long serialVersionUID = 8783010290773480918L;

public OperandeTropPetitException(){
		super ("Operande trop petit  , la valeur de l' Operande dois etre  >= 0" );
	}

}
