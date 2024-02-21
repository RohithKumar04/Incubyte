package com.incubyte.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    private StringCalc stringCalc;

    @BeforeEach
    void setup() {
        stringCalc=new StringCalc();
    }

    @Test
    void whenEmpty_defaultToZero() {

        int result=stringCalc.calculate("");
        Assertions.assertEquals(result,0);

    }

    @Test
    void whenSizeIsOne_returnAsNumber() {

        int result=stringCalc.calculate("1");
        Assertions.assertEquals(result,1);

    }

    @Test
    void whenCommaSeparated_sum() {

        int result=stringCalc.calculate("1,2");
        Assertions.assertEquals(result,3);

    }

    @Test
    void splitByCommaOrNewLine_Sum() {

        Assertions.assertEquals(stringCalc.calculate("1,2"),3);

        Assertions.assertEquals(stringCalc.calculate("1/n2"),3);

    }

    @Test
    void splitByCommaOrNewLine_AddNumbers_InvalidInput() {

        Assertions.assertThrows(InvalidException.class,() -> {
            stringCalc.calculate("/n1,2");
        });

        Assertions.assertThrows(InvalidException.class,() -> {
            stringCalc.calculate("1,2/n");
        });

    }

    @Test
    void ignore1000_thenSum() {

        int result=stringCalc.calculate("1000,2,3");
        Assertions.assertEquals(result,5);
    }
}
