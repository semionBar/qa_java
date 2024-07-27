package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnCorrectValue() throws Exception {

        int expectedAmountOfKittens = 1;

        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

        int actualAmountOfKittens = lion.getKittens();

        assertEquals(expectedAmountOfKittens, actualAmountOfKittens);
    }

    @Test
    public void doesHaveManeHasShouldReturnTrue() throws Exception {

        Lion lion = new Lion("Самец", feline);

        boolean expectedResult = true;

        boolean actualResult = lion.doesHaveMane();

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void doesHaveManeHasShouldReturnFalse() throws Exception {

        Lion lion = new Lion("Самка", feline);

        boolean expectedResult = false;

        boolean actualResult = lion.doesHaveMane();

        assertEquals(expectedResult, actualResult);

    }

    @Test(expected = Throwable.class)
    public void doesHaveManeHasShouldTrowException() throws Exception {

        Lion lion = new Lion("Тест", feline);

        lion.doesHaveMane();

    }

    @Test
    public void getFoodTest() throws Exception {

        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");

        Lion lion = new Lion("Самка", feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> actualList = lion.getFood();

        assertEquals(expectedList, actualList);

    }
}
