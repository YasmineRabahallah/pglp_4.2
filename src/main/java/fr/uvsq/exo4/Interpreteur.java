package fr.uvsq.exo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreteur {
private Map<String , GeneriqueCommande> commandes ;


public Interpreteur ( final  Stack<Double> stockage , final  Stack<Double> historique )
{
	this.commandes = new HashMap <String , GeneriqueCommande> ();
}
public void addCommande(String name ,  GeneriqueCommande commande)
{
	this.commandes.put(name, commande);
}
     private class Quit implements GeneriqueCommande {

		public void apply() {
			System.out.println("vous avez quitter !!!! ");
			
		}
	private class Undo implements GeneriqueCommande{
          private Stack<Double> stockage;
          private Stack<Double>  hist;
		public Undo(Stack<Double>  stockage ,Stack<Double> hist) {
			this.hist=hist; 
			this.stockage=stockage;
			
		}
		public void apply() {

             if (hist.size()> 2){
            	 this.stockage.push(this.hist.pop());
            	 this.stockage.push(this.hist.pop());
             }
			
		}
		
	}
    	 
     }
}


