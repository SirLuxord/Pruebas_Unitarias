
import junit.framework.TestCase;

public class Cuenta_Bancaria_test {
	
	private Cuenta_Bancaria test; 
	@BeforeEach
	void init() {
		test = new Cuenta_Bancaria("Manolo","85579922T","1500 4300 00 2056100328", 2500.00);
	}
	
	@Test
	void testSumarSaldo() {
        assertEquals(3500.00, test.sumarSaldo(1000.00));
    }
	
	@Test
	void testrestarSaldo() { 
        assertEquals(1500.00, test.restarSaldo(1000.00));
    }
	
    @Test
    void testgetSaldo() {
        assertEquals(2500.00, test.getSaldo());
}
