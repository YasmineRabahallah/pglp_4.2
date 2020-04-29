package fr.uvsq.exo4;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import Execptions.OperandeManquantException;


public class Test_interpreteur {
	Stack<Double> s ;
	Stack<Double> h ;
	Interpreteur in = new Interpreteur(s,h);
		@Test
		public void testinterpreteur1() {
			
			assertNotNull(in);
		}
		
		
}
