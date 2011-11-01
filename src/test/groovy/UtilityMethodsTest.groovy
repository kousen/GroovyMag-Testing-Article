import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class UtilityMethodsTest {
    UtilityMethods impl = new UtilityMethods()

    // --- Listing 2 start ---
    @Test
    void testIsPrime() {
        def primes = [2, 3, 5, 7, 11, 13, 17, 19, 23]
        primes.each { num ->
            assert impl.isPrime(num)
        }
        assert !impl.isPrime(9)
    }

    @Test(expected=IllegalArgumentException)
    void testIsPrimeWithNegative() {
        impl.isPrime(-3)
    }
    // --- Listing 2 end ---

    @Test
    void testIsPalindrome() {
        assert impl.isPalindrome("Madam, in Eden, I'm Adam")
        assert impl.isPalindrome('Sex at noon taxes')
        assert impl.isPalindrome('Flee to me, remote elf')
        assert !impl.isPalindrome('This is not a palindrome')
    }
}
