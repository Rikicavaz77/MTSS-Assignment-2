package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.BeforeClass;

public class IntegerToRomanTest {

    @BeforeClass 
    public static void classSetUp() {
        new IntegerToRoman();
    }
    
    @Test
    public void testConvert_WithNegativeNumberAsInput() {
        
        RomanNumberException exc = assertThrows(
            RomanNumberException.class,
            () -> IntegerToRoman.convert(-1)
        );
            
        assertEquals("Negative numbers are not convertible into Roman ones", exc.getMessage());
    }

    @Test
    public void testConvert_With0AsInput() {
        
        RomanNumberException exc = assertThrows(
            RomanNumberException.class,
            () -> IntegerToRoman.convert(0)
        );
            
        assertEquals("0 is not convertible into a Roman number", exc.getMessage());
    }

    @Test
    public void testConvert_WithMoreThan3999AsInput() {
        
        RomanNumberException exc = assertThrows(
            RomanNumberException.class,
            () -> IntegerToRoman.convert(4000)
        );
            
        assertEquals("I, V, X, L, C, D and M only support numbers from 1 to 3999", exc.getMessage());
    }

    @Test
    public void testConvert_One() {
        
        assertRomanNumberEquals("I", 1);
    }

    @Test
    public void testConvert_Two() {
        
        assertRomanNumberEquals("II", 2);
    }

    @Test
    public void testConvert_Four() {
        
        assertRomanNumberEquals("IV", 4);
    }
    
    @Test
    public void testConvert_Five() {
        
        assertRomanNumberEquals("V", 5);
    }

    @Test
    public void testConvert_Six() {
        
        assertRomanNumberEquals("VI", 6);
    }

    @Test
    public void testConvert_Nine() {
        
        assertRomanNumberEquals("IX", 9);
    }

    @Test
    public void testConvert_Ten() {
        
        assertRomanNumberEquals("X", 10);
    }

    @Test
    public void testConvert_Fourteen() {
        
        assertRomanNumberEquals("XIV", 14);
    }

    @Test
    public void testConvert_Thirtynine() {
        
        assertRomanNumberEquals("XXXIX", 39);
    }

    @Test
    public void testConvert_Forty() {
        
        assertRomanNumberEquals("XL", 40);
    }

    @Test
    public void testConvert_FourtyOne() {
        
        assertRomanNumberEquals("XLI", 41);
    }

    @Test
    public void testConvert_Fifty() {
        
        assertRomanNumberEquals("L", 50);
    }

    @Test
    public void testConvert_SixtyTwo() {
        
        assertRomanNumberEquals("LXII", 62);
    }

    @Test
    public void testConvert_EightyNine() {
        
        assertRomanNumberEquals("LXXXIX", 89);
    }

    @Test
    public void testConvert_Ninety() {
        
        assertRomanNumberEquals("XC", 90);
    }

    @Test
    public void testConvert_NinetyNine() {
        
        assertRomanNumberEquals("XCIX", 99);
    }

    @Test
    public void testConvert_Hundred() {
        
        assertRomanNumberEquals("C", 100);
    }

    @Test
    public void testConvert_ThreeHundredAndNinetyNine() {
        
        assertRomanNumberEquals("CCCXCIX", 399);
    }

    @Test
    public void testConvert_FourHundred() {
        
        assertRomanNumberEquals("CD", 400);
    }

    @Test
    public void testConvert_FiveHundred() {
        
        assertRomanNumberEquals("D", 500);
    }

    @Test
    public void testConvert_EightHundredAndNinetyEight() {
        
        assertRomanNumberEquals("DCCCXCVIII", 898);
    }

    @Test
    public void testConvert_NineHundred() {
        
        assertRomanNumberEquals("CM", 900);
    }

    @Test
    public void testConvert_OneThousand() {
        
        assertRomanNumberEquals("M", 1000);
    }

    private static void assertRomanNumberEquals(String roman, int number) 
    {
        try {
            assertEquals(roman, IntegerToRoman.convert(number));
        } catch (RomanNumberException e) {};
    }
}
