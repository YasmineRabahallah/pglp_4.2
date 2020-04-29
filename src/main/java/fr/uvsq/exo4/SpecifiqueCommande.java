package fr.uvsq.exo4;

import execptions.DivisionParZeroException;

public interface SpecifiqueCommande extends Icommande {
  public double apply(double op1, double op2) 
		  throws DivisionParZeroException ;
}
