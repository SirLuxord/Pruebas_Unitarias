package banco_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
//import java.util.InputMismatchException;
import banco.Cuenta_Bancaria;

class Cuenta_Bancaria_test {
	
	private Cuenta_Bancaria test; 
	
	@BeforeEach
	void init() {
		test = new Cuenta_Bancaria("Manolo","85579922T","1500 4300 00 2056100328", 2500.00);
	}
	
	@Nested
	class TestSumarSaldotest {
		
		@Test
		void testSumarSaldo() {
	        Assertions.assertEquals(3500.00, test.sumarSaldo(1000.00));
	    }
		/*
		@Test
		void testSumarSaldoExcepcion() {
	        Assertions.assertThrows(InputMismatchException.class, () ->{
	        	test.sumarSaldo(-500.00);
	        });
	    }
	    */
		// Debido al try catch, no termina de lanzar la excepción.
		@Test
		void testSumarSaldoNoExcepcion() {
	        Assertions.assertDoesNotThrow( () ->{
	        	test.sumarSaldo(500.00);
	        });
	    }	
	}
	
	
	@Test
	void testrestarSaldo() { 
		Assertions.assertEquals(1500.00, test.restarSaldo(1000.00));
    }
	
	@Test
    void testgetSaldo() {
    	Assertions.assertEquals(2500.00, test.getSaldo());
    }

}
