package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception{
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals(1, actual);

    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные","Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(List.of("Животные","Птицы", "Рыба"), actualFood);
    }

    @Test
    public void createLionMaleTest()throws Exception{
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void createLionFemaleTest()throws Exception{
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void createLionInvalidGenderTest() {
        try {
            Lion lion = new Lion("Оно", feline);
            lion.doesHaveMane();
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            String expectedMessage = "Используйте только значения пола животного - самец или самка";
            assertEquals(expectedMessage, e.getMessage());
        }
    }
}