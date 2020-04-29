package fr.uvsq.exo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Execptions.DivisionParZeroException;
import Execptions.OperandeManquantException;
import Execptions.OperandeTropGrandException;
import Execptions.OperandeTropPetitException;


/**
 * class MoteurRPN.
 * @author rabahallah yasmine.
 *
 */

public class MoteurRPN extends Interpreteur {
  public static  final double MAX_VALUE = 7000000;
  public  static final double MIN_VALUE = 0;
  private Stack<Double> stockage;
  private Stack<Double> historique;
  private Map<String,SpecifiqueCommande> commandes;

  /**
   * costructeur MoteurRPN.
   * @param stockage pile de stockage .
   * @param historique pile d'historique.
   */
  public MoteurRPN(final Stack<Double> stockage,final Stack<Double> historique) {
    super(stockage, historique);
    this.commandes = new HashMap<String,SpecifiqueCommande>();
    commandes.put("+", new Addition());
    commandes.put("*", new Multiplication());
    commandes.put("-", new Soustraction());
    commandes.put("/", new Division(stockage));
    this.stockage = stockage;
    this.historique = historique;
  }
 
  /**
   * fonction pour ajouter un operand dans la pile stockage.
   * @param operande  operande.
   * @throws OperandeTropGrandException OperandeTropGrandException.
   * @throws OperandeTropPetitException OperandeTropPetitException.
   * 
   */

  public void ajouterOperande(double operande) throws
      OperandeTropGrandException,OperandeTropPetitException {
    if (operande < MIN_VALUE) {
      throw new OperandeTropPetitException();
    } else if (operande > MAX_VALUE) {
      throw new OperandeTropGrandException();
    }
    this.stockage.push(operande);

  }

  /**
   * methode pour affichage.
   * @return l'affichage de la pile.
   */

  public String afficher() {
    StringBuffer sb = new StringBuffer();
    for (double p :stockage) {
      sb.append(" ");
      sb.append(p);
    }
    return "" + sb;
  }

  /**
   * classe addition pour effectuer l'operation d'addition.
   * @author yasmine.
   *
   */

  private static class Addition implements SpecifiqueCommande {
    public Addition() {
    }

    public double apply(double operande1, double operande2) {
      return operande1 + operande2;
    }
  }

  /**
   *classe multiplication pour effectuer l'operation de multiplication. 
   * @author yasmine.
   */

  private static class Multiplication implements SpecifiqueCommande {
    public Multiplication(){
    }

    public double apply(double operande1, double operande2) {
      return operande1 * operande2;
    }

  }
  
  /**
   * classe division pour effectuer l'operation de division.
   * @author yasmine.
   *
   */

  private class Division implements SpecifiqueCommande {
    public Division(Stack<Double> stosckage){
    }

    public double apply(double operande1, double operande2)throws DivisionParZeroException {
      if (operande1 != 0) {
        return operande2 / operande1;
      } else {
        stockage.push(operande2);
        stockage.push(operande1);
        historique.pop();
        historique.pop();
        throw new DivisionParZeroException();
      }
    }
  }

  /**
   *  classe soustraction  pour effectuer l'operation soustraction.
   * @author yasmine.
   */

  private static  class Soustraction implements SpecifiqueCommande {
    public Soustraction() {
    } 

    public double apply(double operande1, double operande2) {
      return operande2 - operande1;
    }
  }

  /**
   * methode calcule.
   * @param comd la commande .
   * @return resultat d execution de la commande. 
   * @throws OperandeManquantException OperandeManquantException.
   * @throws DivisionParZeroException  DivisionParZeroException.
   */

  public double calcule(SpecifiqueCommande comd) throws 
      OperandeManquantException, DivisionParZeroException {
    if (this.stockage.size() >= 2) {
      double operande1 = this.stockage.pop(); 
      double operande2 = this.stockage.pop(); 
      this.historique.push(operande1);
      this.historique.push(operande2);
      double k = comd.apply(operande1, operande2);
      stockage.push(k);
      return k;
    } else {
      throw new OperandeManquantException();
    }
  }

  /**
   * methoode calculecommande.
   * @param operation qui vas défnir la commande.
   * @return  la commande comd qui va definir le type de la commande. 
   * @throws OperandeManquantException OperandeManquantException.
   * @throws DivisionParZeroException DivisionParZeroException.
   */
  public double calculecommande(String operation) throws 
      OperandeManquantException, DivisionParZeroException {
    return  this.calcule(this.commandes.get(operation));
  }
   
}


