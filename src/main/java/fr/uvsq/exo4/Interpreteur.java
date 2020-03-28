package fr.uvsq.exo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Execptions.OperandeManquantException;

public class Interpreteur {
private Map<String , GeneriqueCommande> commandes ;


public Interpreteur ( final  Stack<Double> stockage , final  Stack<Double> historique )
{
	this.commandes = new HashMap <String , GeneriqueCommande> ();
	this.commandes.put("undo", new Undo(stockage, historique));
	this.commandes.put("exit", new Quit());
}
public void traite(String value) throws OperandeManquantException {
	GeneriqueCommande commande = this.commandes.get(value);
    commande.apply();
	
}
     private class Quit implements GeneriqueCommande {

		public void apply() {
			System.out.println("vous avez quitter !!!! ");
			
		}
     }
     
	private class Undo implements GeneriqueCommande {
          private Stack<Double> stockage;
          private Stack<Double>  hist;
		public Undo(final Stack<Double>  stockage ,final Stack<Double> hist) {
			this.hist=hist; 
			this.stockage=stockage;
			
		}
		public void apply() throws OperandeManquantException{
               if (!this.stockage.empty()){
            	   this.stockage.pop();
             if (this.hist.size()>= 2){
            	double a = this.hist.pop();
            	double b = this.hist.pop();
            	this.stockage.push(a);
            	this.stockage.push(b);
             }
             else throw new OperandeManquantException();
			
		} else throw new IllegalStateException();
		}
		
		
	}
    	 
     
}


