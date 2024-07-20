package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void getFamilyShouldReturnCatFamily(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }
    @Test
    public void getKittensShouldReturnOneKitten(){
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void getKittensWithKittensCountShouldReturnKittensCount(){
        Feline feline = new Feline();
        int expected = 3;
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual);
    }


    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expected = feline.eatMeat();
        assertEquals(expected, List.of("Животные", "Птицы", "Рыба"));

    }
}