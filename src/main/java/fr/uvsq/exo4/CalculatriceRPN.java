package fr.uvsq.exo4;

import Execptions.DivisionParZeroException;
import Execptions.OperandeManquantException;
import Execptions.OperandeTropGrandException;
import Execptions.OperandeTropPetitException;
/**
 * 
 * @author yasmine
 *
 */
public enum CalculatriceRPN {
	/**
	 * 
	 */
CALCULATRICE(new SaisieRPN());
	/**
	 * 
	 */
	private SaisieRPN saisierpn;
	
	CalculatriceRPN( SaisieRPN saisie)
	{
		 saisierpn= saisie ;
	}
	/**
	 * 
	 * @throws OperandeTropGrandException OperandeTropGrandException
	 * @throws OperandeTropPetitException OperandeTropPetitException
	 * @throws OperandeManquantException OperandeManquantException
	 * @throws DivisionParZeroException DivisionParZeroException
	 */
	public void traite() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException
	{
		saisierpn.traitement();
	}
	
	public static void main(String[] args) throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException {
		
		CalculatriceRPN.CALCULATRICE.traite();
	}
}
