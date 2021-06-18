package com.fngeno.sonarqubedockerexercise1.mathtestservice;

import com.fngeno.sonarqubedockerexercise1.mathservice.MathService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MathServiceTest {
    private MathService mathService;

    @BeforeEach
    public void setUp() {
        mathService = new MathService();
    }

    @Test
    public void multipliesNumbers() {
        int result = mathService.multiply(2, 4);

        assertEquals(result, 8);
    }

    @Test
    public void subtraction() {
        int result = mathService.subtract(4, 2);
        assertEquals(result, 2);
    }
}