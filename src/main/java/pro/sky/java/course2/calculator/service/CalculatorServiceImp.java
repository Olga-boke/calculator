package pro.sky.java.course2.calculator.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.calculator.exception.DivideByZeroException;

@Service
public class CalculatorServiceImp implements CalculatorService {

    @Override
    public int plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public int minus(Integer a, Integer b) {
        return a- b;
    }

    @Override
    public int multiple(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public double divide(Integer a, Integer b) {
        if(b==0) {
            throw new DivideByZeroException(" Нельзя делить на 0! ");
        }
        return (double) a / b;
    }
}

