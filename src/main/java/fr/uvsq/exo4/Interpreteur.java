package fr.uvsq.exo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Execptions.OperandeManquantException;


/**
 * class Interpreteur .
 * @author rabahallah yasmine.
 *
 */

public class Interpreteur {
  /**
   * map pour enregistrer les geniriques commandes.
   */

  private Map<String,GeneriqueCommande> commandes;

  /**
   * constructeur Interpreteur.
   * @param stockage pile de stockage. 
   * @param historique pile d'historique.
   */

  public Interpreteur(final Stack<Double> stockage,final Stack<Double> historique) {
    this.commandes = new HashMap<String,GeneriqueCommande>();
    this.commandes.put("undo", new Undo(stockage, historique));
    this.commandes.put("exit", new Quit());
  }

  /**
   * methode pour appliquer la commande genirique.
   * @param str pour definir la commande undo ou quit .
   * @throws OperandeManquantException OperandeManquantException.
   * 
   */

  public void traite(String str) throws OperandeManquantException {
    GeneriqueCommande commande = this.commandes.get(str);
    commande.apply();
  }

  /**
   * class Quit.
   * @author rabahallah yasmine.
   */

  private  static class Quit implements GeneriqueCommande {
    public void apply() {
      System.out.println("vous avez quitter !!!! ");

    }
  }
  /**
   *  class pour retour en arriere et avoir le dernier historique.
   * @author rabahallah yasmine.
   *
   */

  private static class Undo implements GeneriqueCommande {
    private Stack<Double> stockage;
    private Stack<Double>  hist;

    public Undo(final Stack<Double> stockage,final Stack<Double> hist) {
      this.hist = hist; 
      this.stockage = stockage;
    }

    public void apply() throws OperandeManquantException {
      if (!this.stockage.empty()) {
        this.stockage.pop();
        if (this.hist.size() >= 2) {
          double a = this.hist.pop();
          double b = this.hist.pop();
          this.stockage.push(a);
          this.stockage.push(b);
        } else {
          throw new OperandeManquantException();
        }

      } else {
        throw new IllegalStateException();
      }
    }


  }


}


