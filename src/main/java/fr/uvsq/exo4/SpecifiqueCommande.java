package fr.uvsq.exo4;

public interface SpecifiqueCommande extends Icommande{
	 public void apply();
	 public double operation(double operande_1, double operande_2) ;
}
