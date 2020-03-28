package fr.uvsq.exo4;

import Execptions.DivisionParZeroException;
import Execptions.OperandeManquantException;
import Execptions.OperandeTropGrandException;
import Execptions.OperandeTropPetitException;

public enum CalculatriceRPN {
CALCULATRICE(new SaisieRPN());
	
	private SaisieRPN saisierpn;
	
	CalculatriceRPN( SaisieRPN saisie)
	{
		 saisierpn= saisie ;
	}
	public void traitement() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException
	{
		saisierpn.manipulation();
	}
	
	public static void main(String[] args) throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException {
		
		CalculatriceRPN.CALCULATRICE.traitement();
	}
}
