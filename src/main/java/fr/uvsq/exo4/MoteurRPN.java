package fr.uvsq.exo4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Execptions.DivisionParZeroException;
import Execptions.OperandeManquantException;
import Execptions.OperandeTropGrandException;
import Execptions.OperandeTropPetitException;
/**
 * 
 * @author yasmine
 *
 */
public class MoteurRPN extends Interpreteur {
	public final double MAX_VALUE = 7000000;
	public final double MIN_VALUE = 0;
	private Stack<Double> stockage ;
	private Stack<Double> historique ;
	private Map<String , SpecifiqueCommande> commandes ;
	/**
	 * 
	 * @param stockage pile de stockage 
	 * @param historique pile d'historique
	 */
	public MoteurRPN(final Stack<Double> stockage,final Stack<Double> historique) {
		super(stockage, historique);
		this.commandes = new HashMap<String,SpecifiqueCommande>();
		commandes.put("+", new Addition());
		commandes.put("*", new Multiplication());
		commandes.put("-", new Soustraction());
		commandes.put("/", new Division(stockage));
        this.stockage=stockage ;
        this.historique=historique;
		
	}
	/**
	 * 
	 * @param operande  operande
	 * 
	 * 
	 * @throws OperandeTropGrandException OperandeTropGrandException
	 * @throws OperandeTropPetitException OperandeTropPetitException
	 * fonction pour ajouter un operand dans la pile stockage
	 */
	public void AjouterOperande(double operande) throws OperandeTropGrandException , OperandeTropPetitException
	{
       if(operande < MIN_VALUE) {
    	   throw new OperandeTropPetitException() ;
       }
       else if (operande >MAX_VALUE){
    	   throw new OperandeTropGrandException();
       }
       this.stockage.push(operande);

	}
	/**
	 * 
	 * @return l'affichage de la pile 
	 */
	public String afficher()
	{
		String i = "";
		for(double p :stockage)
		{
			i += p + " ";
		}
		return i;
	}
	/**
	 * 
	 * @author yasmine
	 * classe addition pour effectuer l'operation d'addition
	 *
	 */
	private class Addition implements SpecifiqueCommande{
        public Addition(){
        }
		public double apply(double operande_1, double operande_2) {
			
			return operande_1+operande_2;
		}

		
	}
	/**
	 * 
	 * @author yasmine
	 *classe multiplication pour effectuer l'operation de multiplication
	 */
	private class Multiplication implements SpecifiqueCommande{
         public Multiplication(){
         }
		public double apply(double operande_1, double operande_2) {
			
			return operande_1*operande_2;
		}
		
			}
/**
 * 
 * @author yasmine
 * classe division pour effectuer l'operation de division
 *
 */
	private class Division implements SpecifiqueCommande {
        public Division(Stack<Double> stosckage){
        }
        
		public double apply(double operande_1, double operande_2)throws DivisionParZeroException {
			if (operande_1 != 0){
				return operande_2/operande_1;
			}
			else{
				stockage.push(operande_2);
				stockage.push(operande_1);
				historique.pop();
				historique.pop();
				throw new DivisionParZeroException() ;
			}
		}
		
			}
	/**
	 * 
	 * @author yasmine
	 * 
	 * classe soustraction  pour effectuer l'operation soustraction
	 *
	 */
	private class Soustraction implements SpecifiqueCommande{
        public Soustraction(){
        }
		public double apply(double operande_1, double operande_2) {
			
			return operande_2-operande_1;
		}
		
		
		
			}
	/**
	 * 
	 * @param comd la commande 
	 * @return resultat d execution de la commande 
	 * @throws OperandeManquantException OperandeManquantException
	 * @throws DivisionParZeroException  DivisionParZeroException
	 */

	public double calcule(SpecifiqueCommande comd) throws OperandeManquantException, DivisionParZeroException
	{
	
			if (this.stockage.size() >= 2){
				double operande1 = this.stockage.pop(); 
				double operande2 = this.stockage.pop(); 
				this.historique.push(operande1);
				this.historique.push(operande2);
				double k=comd.apply(operande1, operande2);
				stockage.push(k);
				return k;
				
			} else throw new OperandeManquantException();
	}
	/**
	 * 
	 * @param operation qui vas défnir la commande
	 * @return  la commande comd qui va definir le type de la commande 
	 * @throws OperandeManquantException OperandeManquantException
	 * @throws DivisionParZeroException DivisionParZeroException
	 */
      public double Calculecommande(String operation) throws OperandeManquantException, DivisionParZeroException {
		
		 return  this.calcule(this.commandes.get(operation));
	}
      
}


