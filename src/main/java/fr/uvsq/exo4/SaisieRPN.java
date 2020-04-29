package fr.uvsq.exo4;

import java.util.Scanner;
import java.util.Stack;

import Execptions.DivisionParZeroException;
import Execptions.OperandeManquantException;
import Execptions.OperandeTropGrandException;
import Execptions.OperandeTropPetitException;

/**
 * class SaisieRpn. 
 * @author rabahallah yasmine.
 *
 */

public class SaisieRPN {

  private Stack<Double> stockage;
  private Stack<Double> historique;
  private MoteurRPN monMoteurrpn;

  /**
   * constructeur SaisieRpn.
   */

  public SaisieRPN() {
    this.historique = new Stack<Double>();
    this.stockage = new Stack<Double>();
    this.monMoteurrpn = new MoteurRPN(stockage,historique);
  }

  /**
   * methode  traitement.
   * @throws OperandeTropGrandException OperandeTropGrandException.
   * @throws OperandeTropPetitException OperandeTropPetitException.
   * @throws OperandeManquantException OperandeManquantException.
   * @throws DivisionParZeroException  DivisionParZeroException.
   * 
   * 
   */

  public void traitement() throws OperandeTropGrandException,
      OperandeTropPetitException, OperandeManquantException, DivisionParZeroException {
    Scanner sc = new Scanner(System.in,"UTF8");
    System.out.println("Entrez une operande ou exit pour quitter "
        + "le programme ou undo pour retour en arrière ");
    String saisie = sc.nextLine();
    Double d;
    while (true) { 
      if (saisie.equals("undo") || saisie.equals("exit")) {
        monMoteurrpn.traite(saisie);
        if (saisie.equals("exit")) {
          System.exit(0);
        } else {
          System.out.println(monMoteurrpn.afficher());
          saisie = sc.nextLine();
        }
      } else {
        try {
          if (saisie.equals("+") || saisie.equals("-")
              || saisie.equals("*") || saisie.equals("/")) {
            monMoteurrpn.calculecommande(saisie);
          } else {
            d = new Double(saisie);
            monMoteurrpn.ajouterOperande(d);
          }
        } catch (OperandeManquantException | DivisionParZeroException
            | OperandeTropPetitException | OperandeTropGrandException e) {
          System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
          System.out.println("saisie incorrecte (Entrez une operande ou exit pour quitter le "
              + "programme  ou undo pour retour en arrière )");
        } finally {
          System.out.println(monMoteurrpn.afficher());
          saisie = sc.nextLine();
        }
      }

    }
  }
}
