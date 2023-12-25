package org.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService{
    public int plus(int val1, int val2){
        return val1 + val2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
