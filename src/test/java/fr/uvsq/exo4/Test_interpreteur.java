package fr.uvsq.exo4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import Execptions.OperandeManquantException;


public class Test_interpreteur {
	
		@Test
		public void testinterpreteur1() {
			Stack<Double> s = null;
			Stack<Double> h = null;
			Interpreteur in = new Interpreteur(s,h);
			assertNotNull(in);
		}
		
}
