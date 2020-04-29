package fr.uvsq.exo4;

import execptions.DivisionParZeroException;
import execptions.OperandeManquantException;
import execptions.OperandeTropGrandException;
import execptions.OperandeTropPetitException;

/**
 * enumeration CalculatriceRPN.
 * @author rabahallah yasmine.
 *
 */

public enum CalculatriceRpn {
  CALCULATRICE(new SaisieRPN());

  /**
   * saisierpn.
   */

  private SaisieRPN saisierpn;

  CalculatriceRpn(SaisieRPN saisie) {
    saisierpn = saisie;
  }

  /**
   * methode traite.
   * @throws OperandeTropGrandException OperandeTropGrandException
   * @throws OperandeTropPetitException OperandeTropPetitException
   * @throws OperandeManquantException OperandeManquantException
   * @throws DivisionParZeroException DivisionParZeroException
   */

  public void traite() throws OperandeTropGrandException,
      OperandeTropPetitException, OperandeManquantException, DivisionParZeroException {
    saisierpn.traitement();
  }

  public static void main(String[] args) throws OperandeTropGrandException, 
      OperandeTropPetitException,OperandeManquantException, DivisionParZeroException {
    CalculatriceRpn.CALCULATRICE.traite();
  }
}
