class UtilityMethods {

    // --- Listing 1 start ---
    boolean isPrime(int x) {
        if (x < 0) 
            throw new IllegalArgumentException('argument must be > 0')
        if (x == 2) return true
        for ( i in 2..<(Math.sqrt(x) + 1)) {
            if (x % i == 0) return false
        }
        return true
    }
    // --- Listing 1 end ---
    
    boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll(/[ ,']/,'')
        return str.reverse() == str
    }

}
