package fr.uvsq.exo4;

import Execptions.OperandeManquantException;

/**
 * interface GeneriqueCommande.
 * @author rabahallah yasmine.
 *
 */

public interface GeneriqueCommande extends Icommande  {

  /**
   * appliquer la commande genirique.
   */

  public void apply() throws OperandeManquantException;

}
