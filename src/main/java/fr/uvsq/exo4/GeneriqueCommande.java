package fr.uvsq.exo4;

import Execptions.OperandeManquantException;

public interface GeneriqueCommande extends Icommande  {
	 public void apply() throws OperandeManquantException;
	
}
