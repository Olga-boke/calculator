package pro.sky.java.course2.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.calculator.exception.DivideByZeroException;
import pro.sky.java.course2.calculator.service.CalculatorServiceImp;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParameterizeCalculatorServiceTest {



    private final CalculatorServiceImp calculatorServiceImp = new CalculatorServiceImp();


    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest(Integer a,
                         Integer b,
                         Integer expected) {
        assertThat( calculatorServiceImp.plus(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(Integer a,
                         Integer b,
                         Integer expected) {
        assertThat( calculatorServiceImp.minus(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiple")
    public void multipleTest(Integer a,
                         Integer b,
                         Integer expected) {
        assertThat( calculatorServiceImp.multiple(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest(Integer a,
                           Integer b,
                           Double expected) {
            if ( b==0 ) {
                assertThatExceptionOfType(DivideByZeroException.class)
                        .isThrownBy(() -> calculatorServiceImp.divide(a, b))
                        .withMessage(" Нельзя делить на 0! ");
            } else {
                assertThat( calculatorServiceImp.divide(a,b)).isEqualTo(expected);
            }


    }


    public static Stream<Arguments> paramsForPlus() {
        return Stream.of(
                    Arguments.of(1,2,3),
                    Arguments.of(5,4,9),
                    Arguments.of(1,1,2),
                    Arguments.of(4,4,8),
                    Arguments.of(1,1,2)
            );
        }
    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(1,2,-1),
                Arguments.of(5,4,1),
                Arguments.of(1,1,0),
                Arguments.of(4,4,0),
                Arguments.of(10,9,1)
        );
    }
    public static Stream<Arguments> paramsForMultiple() {
        return Stream.of(
                Arguments.of(1,2,2),
                Arguments.of(5,4,20),
                Arguments.of(1,1,1),
                Arguments.of(4,4,16),
                Arguments.of(1,5,5)
        );
    }
    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(2,1,2.0),
                Arguments.of(15,3,5.0),
                Arguments.of(1,1,1.0),
                Arguments.of(4,0,null),
                Arguments.of(1,0,null)
        );
    }
}

