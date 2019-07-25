package com.mycompany.team;

import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz instance;

    @Before
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
    public void executionWithMultiple3NumberResturnsStringFizz() {
        testWith(3, "Fizz");
    }

    @Test
    public void executionWithMultiple5NumberResturnsStringBuzz() {
        testWith(5, "Buzz");
    }

    @Test(expected = IllegalArgumentException.class)
    public void executionWithNumberLowerThan0ThrowsError() {

        instance.execute(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void executionWithNumberLowerThan0AndMultipleOf3ThrowsError() {
        instance.execute(-3);
    }
    

    @Test
    public void executionWithMultiple3AndMultiple5NumberResturnsStringFizzBuzz() {
        testWith(15, "Fizz Buzz");
    }

    
    
    @Test
    public void executionWithNumberFourReturnsFour() {
        testWith(4, "4");
    }
    
     
    @Test
    public void executionWithRandomNumberNotMultipleOF3OR5ReturnTheSameNumber() {
        for(int i=1;i<=100;i++){
            if(i%3==0 || i%5==0){
                continue;
            }
            testWith(i,String.valueOf(i));
        }
    }

   

}
