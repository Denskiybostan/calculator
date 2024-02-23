package org.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public class CalculatorTest {
    private int plus(int val1, int val2) {
        return val1 + val2;
    }

    private int minus(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        return num1 / num2;
    }
    @BeforeEach
    @GetMapping("/calculator")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }
    @Test
    // /calculator/plus?num1=5&num2=5
    @GetMapping("/calculator/plus")
    public String plus(@RequestParam("num1") int param1, @RequestParam("num2") int param2) {
        return param1 + " + " + param2 + " = " + service.plus(param1, param2);
    }
    @Test
    // /calculator/plus?num1=5
    @GetMapping("/calculator/minus")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан";
        }
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }
    @Test
    // /calculator/plus?num1=5
    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
    }
    @Test
    @GetMapping("/calculator/divide")
    public String division(@RequestParam int num1, @RequestParam int num2) {
        try {
            if (num2 == 0) {
                return "На ноль делить нельзя";
            }
            return num1 + " / " + num2 + " = " + service.divide(num1, num2);
        } catch (IllegalArgumentException e) {
            System.out.println("На ноль делить нельзя, повторите снова");
        } finally {
        }
        return null;

    }
}
