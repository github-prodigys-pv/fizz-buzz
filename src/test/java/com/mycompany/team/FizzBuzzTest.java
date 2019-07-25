package com.mycompany.team;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FizzBuzzTest {

    private FizzBuzz instance;

    @BeforeEach
    public void init() {
        instance = new FizzBuzz();
    }

    private void testWith(int input, String expected) {
        String given = instance.execute(input);
        assertEquals(expected, given);
    }

    @Test
    public void executionWithNumberOneReturnsOne() {
        testWith(1, "1");
    }

    @Test
    public void executionWithMultipleOf3ReturnsStringFizz() {
        testWith(3, "Fizz");
    }

    @Test
    public void executionWithMultipleOf5NumberReturnsStringBuzz() {
        testWith(5, "Buzz");
    }

    @Test()
    public void executionWithNumberLowerThan0ThrowsError() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            instance.execute(-1);
        });

    }

    @Test()
    public void nonRegressionTest_executionWithNumberLowerThan0AndMultipleOf3ThrowsError() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            instance.execute(-3);
        });

    }

    @Test
    public void executionWithMultipleOf3AndMultipleOf5ResturnsStringFizzBuzz() {
        testWith(15, "Fizz Buzz");
    }

    @Test
    public void executionWithNumberFourReturnsFour() {
        testWith(4, "4");
    }

    @Test
    public void executionWithRandomNumberNotMultipleOF3OR5ReturnTheSameNumber() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                continue;
            }
            testWith(i, String.valueOf(i));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2,4,7,11,22,101,1001}) 
    public void dataDrivenTestWithNumbersThatAreNotMultipleOf3And5(int number) {
        testWith(number, String.valueOf(number));
    }

}
