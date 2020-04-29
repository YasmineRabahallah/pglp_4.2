package Execptions;

/**
 * class OperandeTropGrandException.
 * @author rabahallah yasmine.
 *
 */

public class OperandeTropGrandException extends Exception {

  /**
   *Exception Operande Trop Grand.
   */

  public OperandeTropGrandException() {
    super("Operande trop grande, la valeur de l' Operande dois etre <= 4000000");
  }


}
