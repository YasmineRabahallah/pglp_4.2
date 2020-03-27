package Execptions;

public class OperandeManquantException extends Exception  {
 
	private static final long serialVersionUID = 4107965386239317568L;

public OperandeManquantException(){
	   super("Operation impossible il faut deux operandes");
   }
}
