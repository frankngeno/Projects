package com.fngeno.tautology;

public class NumberValidator {
    public boolean isItPrime(Integer number) {
        int maxDivisor = (int)Math.sqrt(number);
        for (int i = 2; i <= maxDivisor; i++){
            if (number % i== 0)
            return false;
        }
        return true;
    }
}
