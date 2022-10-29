package pro.sky.java.course2.calculator;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.calculator.exception.DivideByZeroException;
import pro.sky.java.course2.calculator.service.CalculatorServiceImp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorServiceImpTest {

    private final CalculatorServiceImp calculatorServiceImp = new CalculatorServiceImp();

    @Test
    public void plusTest() {
        Number actual = calculatorServiceImp.plus(2,5);
        assertThat(actual).isEqualTo(7);

        actual = calculatorServiceImp.plus(7,3);
        assertThat(actual).isEqualTo(10);
    }
    @Test
    public void minusTest(){
        Number actual = calculatorServiceImp.minus(8,5);
        assertThat(actual).isEqualTo(3);

        actual = calculatorServiceImp.minus(8,2);
        assertThat(actual).isEqualTo(6);
    }
    @Test
    public void multipleTest(){
        Number actual = calculatorServiceImp.multiple(1,2);
        assertThat(actual).isEqualTo(2);

        actual = calculatorServiceImp.multiple( 2,2);
        assertThat(actual).isEqualTo(4);
    }
    @Test
    public void dividePositiveTes(){
        Number actual = calculatorServiceImp.divide(8,2);
        assertThat(actual).isEqualTo(4.0);

        actual = calculatorServiceImp.divide(12,2);
        assertThat(actual).isEqualTo(6.0);
    }
    @Test
    public void divideNegativeTest(){
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy( () -> calculatorServiceImp.divide(2,0))
                .withMessage(" Нельзя делить на 0! ");

        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy( () -> calculatorServiceImp.divide(9,0))
                .withMessage(" Нельзя делить на 0! ");
    }
}
