package pro.sky.java.course2.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.service.CalculatorService;
import pro.sky.java.course2.calculator.service.CalculatorServiceImp;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    @GetMapping
    public String privet(){
        return " <h1>Добро пожаловать</h1>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam (name="num1", required = false) Integer a,
                       @RequestParam (name = "num2", required = false) Integer b){
        if( a== null || b == null) return " Не передано одно из полей";
        int plus = calculatorService.plus(a, b);
       return a + "+" + b + "=" + plus;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam (name="num1", required = false) Integer a,
                       @RequestParam (name = "num2", required = false) Integer b){
        if( a== null || b == null) return " Не передано одно из полей";
        int minus = calculatorService.minus(a, b);
        return a + "-" + b + "=" + minus;
    }

    @GetMapping("/multiple")
    public String multiple(@RequestParam (name="num1", required = false) Integer a,
                       @RequestParam (name = "num2", required = false) Integer b){
        if( a== null || b == null) return " Не передано одно из полей";
        int multiple = calculatorService.multiple(a, b);
        return a + "-" + b + "=" + multiple;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam (name="num1", required = false) Integer a,
                       @RequestParam (name = "num2", required = false) Integer b){
        if( a== null || b == null) return " Не передано одно из полей";
        double divide;

        divide = calculatorService.divide(a, b);

        return a + "-" + b + "=" + divide;
    }


}
