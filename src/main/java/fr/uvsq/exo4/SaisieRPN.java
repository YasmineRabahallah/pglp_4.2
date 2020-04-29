package fr.uvsq.exo4;

import execptions.DivisionParZeroException;
import execptions.OperandeManquantException;
import execptions.OperandeTropGrandException;
import execptions.OperandeTropPetitException;
import java.util.Scanner;
import java.util.Stack;

/**
 * class SaisieRpn. 
 * @author rabahallah yasmine.
 *
 */

public class SaisieRpn {

  private Stack<Double> stockage;
  private Stack<Double> historique;
  private MoteurRpn monMoteurrpn;

  /**
   * constructeur SaisieRpn.
   */

  public SaisieRpn() {
    this.historique = new Stack<Double>();
    this.stockage = new Stack<Double>();
    this.monMoteurrpn = new MoteurRpn(stockage,historique);
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
