package execptions;

/**
 * class OperandeTropPetitException.
 * @author rabahallah yasmine.
 *
 */

public class OperandeTropPetitException  extends Exception {

  /**
   *Exception Operande Trop Petit.
   */

  public OperandeTropPetitException() {
    super("Operande trop petit  , la valeur de l' Operande dois etre  >= 0");
  }

}
