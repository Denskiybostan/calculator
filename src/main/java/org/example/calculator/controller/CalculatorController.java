package org.example.calculator.controller;

import org.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    public final CalculatorService service;

    public CalculatorController(CalculatorService service) {

        this.service = service;
    }

    @GetMapping("/calculator")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    // /calculator/plus?num1=5&num2=5
    @GetMapping("/calculator/plus")
    public String plus(@RequestParam("num1") int param1, @RequestParam("num2") int param2) {
        return param1 + " + " + param2 + " = " + service.plus(param1, param2);
    }

    // /calculator/plus?num1=5
    @GetMapping("/calculator/minus")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан";
        }
        return num1 + " - " + num2 + " = " + service.minus(num1, num2);
    }

    // /calculator/plus?num1=5
    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + " * " + num2 + " = " +service.multiply(num1,num2);
}
    @GetMapping("/calculator/divide")
    public String division(@RequestParam int num1, @RequestParam int num2){
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        return num1 + " / " + num2 + " = " + service.divide(num1, num2);
    }
}
