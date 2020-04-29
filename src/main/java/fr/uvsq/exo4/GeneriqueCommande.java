package fr.uvsq.exo4;

import execptions.OperandeManquantException;

public interface GeneriqueCommande extends Icommande  {
	 public void apply() throws OperandeManquantException;
	
}
