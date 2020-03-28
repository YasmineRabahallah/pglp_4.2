package fr.uvsq.exo4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import Execptions.DivisionParZeroException;
import Execptions.OperandeManquantException;
import Execptions.OperandeTropGrandException;
import Execptions.OperandeTropPetitException;


public class MoteurRPNtest {
	private Stack<Double> s = new Stack<Double>();
	private Stack<Double> h = new Stack<Double>();
	MoteurRPN m = new MoteurRPN(s,h);
	@Test
	public void testinterpreteur1() {
		
		assertNotNull(m);
	}
	
	@Test(expected=OperandeTropPetitException.class)
	public void testOperandeTropPetit() throws DivisionParZeroException, OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException{
		m.AjouterOperande(-10.00);
		}
	@Test(expected=DivisionParZeroException.class)
	public void testDivisionParZeroException() throws DivisionParZeroException, OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException{
		m.AjouterOperande(7.0);
		m.AjouterOperande(0.0);
		m.Calculecommande("/");
		}
	@Test(expected=OperandeTropGrandException.class)
	public void testOperandeTropGrand() throws DivisionParZeroException, OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException{
		
		m.AjouterOperande(8000000000000000000.0);
		}
	@Test
	public void testaddion() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
	
		m.AjouterOperande(5.0);
		m.AjouterOperande(3.0);
		assertEquals(m.Calculecommande("+"), 8.0, 0);
	}
	@Test
	public void testsous() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(5.0);
		m.AjouterOperande(3.0);
		assertEquals(m.Calculecommande("-"), 2, 0);
	}
	
	@Test
	public void testdivision() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(12);
		m.AjouterOperande(6);
		assertEquals(m.Calculecommande("/"), 2, 0);
	}
	@Test
	public void testmult() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		assertEquals(m.Calculecommande("*"),30, 0);
	}
	
	@Test
	public void testmult2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(5);
		assertEquals(m.Calculecommande("*"),75, 0);
	}
	
	@Test
	public void testsous2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		assertEquals(m.Calculecommande("-"), -35, 0);
	}
	
	@Test
	public void testaddition2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		assertEquals(m.Calculecommande("+"), 52, 0);
		
	}
	
	@Test
	public void testundo() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		m.Calculecommande("+");
		m.traite("undo");
		assertEquals(s.size(),4, 0);
	}
	@Test
	public void testsize() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		m.Calculecommande("+");
		assertEquals(s.size(),3, 0);
	}
	public void testsizehistorique() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		m.Calculecommande("+");
		assertEquals(h.size(),2, 0);
	}
	public void testsizehistorique2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		m.Calculecommande("+");
		m.Calculecommande("/");
		assertEquals(h.size(),4, 0);
	}
	public void testhistorique3() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		m.Calculecommande("+");
		m.Calculecommande("/");
		m.traite("undo");
		m.traite("undo");
		assertEquals(h.size(),0, 0);
	}
	public void testundo2() throws OperandeTropGrandException, OperandeTropPetitException, OperandeManquantException, DivisionParZeroException{
		m.AjouterOperande(2);
		m.AjouterOperande(15);
		m.AjouterOperande(50);
		m.AjouterOperande(2);
		m.Calculecommande("+");
		m.Calculecommande("/");
		m.traite("undo");
		m.traite("undo");
		assertEquals(s.size(),4, 0);
	}
	
	
	
	

	
	
	
	
	
}
