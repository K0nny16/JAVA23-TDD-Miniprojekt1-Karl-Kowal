import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

    private PrimeNumbers primeNumbers;

    @BeforeEach
    public void setUp() {
        primeNumbers = new PrimeNumbers();
    }
    @Test
    @DisplayName("Boundary testing")
    void boundaryTest(){
        assertFalse(primeNumbers.isPrime(1));
        assertTrue(primeNumbers.isPrime(2));
        assertTrue(primeNumbers.isPrime(3));
        assertFalse(primeNumbers.isPrime(4));
        assertTrue(primeNumbers.isPrime(5));
        assertFalse(primeNumbers.isPrime(0));
    }
    @Test
    @DisplayName("Null test")
    void nullTest(){
        assertThrows(NullPointerException.class, () -> primeNumbers.addNumbers(null,2));
        assertThrows(NullPointerException.class, () -> primeNumbers.addNumbers(1,null));
    }
    @Test
    @DisplayName("Exemption handling")
    void exemptionTest(){
        assertThrows(IllegalArgumentException.class, () -> primeNumbers.addNumbers(-1,2));
        assertThrows(IllegalArgumentException.class, () -> primeNumbers.addNumbers(2,-1));
        assertThrows(IllegalArgumentException.class, () -> primeNumbers.addNumbers(3,2));
    }
    @Test
    @DisplayName("Input and output")
    void inputAndOutputTest(){
        primeNumbers.addNumbers(1,10);
        assertEquals(4,primeNumbers.getAmountOfPrimes());
        assertEquals(17,primeNumbers.getSum());
    }
    @Test
    @DisplayName("Datatype handling")
    void datatypeTest(){
        primeNumbers.addNumbers(1,10);
        assertInstanceOf(Integer.class, primeNumbers.getAmountOfPrimes());
        assertFalse(primeNumbers.isPrime(Integer.MAX_VALUE));
    }
}