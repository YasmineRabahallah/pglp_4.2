package fr.uvsq.exo4;

import Execptions.DivisionParZeroException;

public interface SpecifiqueCommande extends Icommande{
	 public double apply(double operande_1, double operande_2) throws DivisionParZeroException  ;
	 
}
