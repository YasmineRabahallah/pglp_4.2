package Execptions;

/**
 * class OperandeManquantException.
 * @author rabahallah yasmine.
 *
 */

public class OperandeManquantException extends Exception {
  /**
   * Exception Operande Manquant.
   */
  public OperandeManquantException() {
    super("Operation impossible il faut deux operandes");
  }
}
