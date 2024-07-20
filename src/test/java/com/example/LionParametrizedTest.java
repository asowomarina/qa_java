package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;


    public LionParametrizedTest(String sex) {
        this.sex = sex;

    }

    @Parameterized.Parameters
    public static Object[][] createTestsParameters() {
        return new Object[][]{
                {"Львенок"},
                {"null"},
                {"Кошка"},
        };
    }

    @Mock
    private Feline feline;

    @Test
    public void createFailLionTest(){
        boolean thrown = false;
        try {
            Lion lion = new Lion(sex, feline);
        } catch (Exception exception) {
            thrown = true;
            assertEquals("Используйте только значения пола животного - самец или самка", exception.getMessage());
        }
        assertTrue("Ожидалось исключение для несуществующего пола", thrown);
    }
}