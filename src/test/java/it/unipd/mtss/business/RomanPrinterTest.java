package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.BeforeClass;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class RomanPrinterTest {

    @BeforeClass 
    public static void classSetUp() {
        new RomanPrinter();
    }

    @Test
    public void testPrint_WithNullAsInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(-1))
                .thenReturn(null);

            NullPointerException exc = assertThrows(
                NullPointerException.class,
                () -> RomanPrinter.print(-1)
            );
            
            assertEquals("The roman number must not be null", exc.getMessage());
        }                     
    }

    @Test
    public void testPrint_WithEmptyStringAsInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(0))
                .thenReturn("");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(0)
            );
            
            assertEquals("You cannot print an empty string in Roman AsciiArt", exc.getMessage());
        }                     
    }

    @Test
    public void testPrint_WithTooLongInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(13000))
                .thenReturn("MMMMMMMMMMMMM");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(13000)
            );
            
            assertEquals("You cannot print a Roman number longer than 12 characters", exc.getMessage());
        }       
    }

    @Test
    public void testPrint_WithTooBigInput() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(4000))
                .thenReturn("MMMM");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(4000)
            );
            
            assertEquals("You cannot print a Roman number greater than 3999", exc.getMessage());
        }       
    }

    @Test
    public void testPrint_WithIncompatibleSymbol() {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(-2))
                .thenReturn("ciao");

            RomanNumberException exc = assertThrows(
                RomanNumberException.class,
                () -> RomanPrinter.print(-2)
            );
            
            assertEquals("The string contains incompatible characters", exc.getMessage());
        }       
    }

    @Test
    public void testPrint_One() {

        assertRomanAsciiArtEquals(
            "I",
            " _____ \n" +
            "|_   _|\n" +
            "  | |  \n" +
            "  | |  \n" +
            " _| |_ \n" +
            "|_____|", 
            1
        );
    }  
    
    @Test
    public void testPrint_Two() {

        assertRomanAsciiArtEquals(
            "II",
            " _____   _____ \n" +
            "|_   _| |_   _|\n" +
            "  | |     | |  \n" +
            "  | |     | |  \n" +
            " _| |_   _| |_ \n" +
            "|_____| |_____|", 
            2
        );
    }

    @Test
    public void testPrint_Four() {

        assertRomanAsciiArtEquals(
            "IV",
            " _____  __      __\n" +
            "|_   _| \\ \\    / /\n" +
            "  | |    \\ \\  / / \n" +
            "  | |     \\ \\/ /  \n" +
            " _| |_     \\  /   \n" +
            "|_____|     \\/    ", 
            4
        );
    }

    @Test
    public void testPrint_Five() {

        assertRomanAsciiArtEquals(
            "V",
            "__      __\n" +
            "\\ \\    / /\n" +
            " \\ \\  / / \n" +
            "  \\ \\/ /  \n" +
            "   \\  /   \n" +
            "    \\/    ", 
            5
        );
    }

    @Test
    public void testPrint_Six() {

        assertRomanAsciiArtEquals(
            "VI",
            "__      __  _____ \n" +
            "\\ \\    / / |_   _|\n" +
            " \\ \\  / /    | |  \n" +
            "  \\ \\/ /     | |  \n" +
            "   \\  /     _| |_ \n" +
            "    \\/     |_____|", 
            6
        );
    }

    @Test
    public void testPrint_Nine() {
        
        assertRomanAsciiArtEquals(
            "IX",
            " _____  __   __\n" +
            "|_   _| \\ \\ / /\n" +
            "  | |    \\ V / \n" +
            "  | |     > <  \n" +
            " _| |_   / . \\ \n" +
            "|_____| /_/ \\_\\", 
            9
        );
    } 
    
    @Test
    public void testPrint_Ten(){

        assertRomanAsciiArtEquals(
            "X",
            "__   __\n" +
            "\\ \\ / /\n" +
            " \\ V / \n" +
            "  > <  \n" +
            " / . \\ \n" +
            "/_/ \\_\\", 
            10
        );
    }  

    @Test
    public void testPrint_ThirtySix() {

        assertRomanAsciiArtEquals(
            "XXXVI",
            "__   __ __   __ __   __ __      __  _____ \n" +
            "\\ \\ / / \\ \\ / / \\ \\ / / \\ \\    / / |_   _|\n" +
            " \\ V /   \\ V /   \\ V /   \\ \\  / /    | |  \n" +
            "  > <     > <     > <     \\ \\/ /     | |  \n" +
            " / . \\   / . \\   / . \\     \\  /     _| |_ \n" +
            "/_/ \\_\\ /_/ \\_\\ /_/ \\_\\     \\/     |_____|", 
            36
        );
    }

    @Test
    public void testPrint_FourtyOne() {

        assertRomanAsciiArtEquals(
            "XLI",
            "__   __  _        _____ \n" +
            "\\ \\ / / | |      |_   _|\n" +
            " \\ V /  | |        | |  \n" +
            "  > <   | |        | |  \n" +
            " / . \\  | |____   _| |_ \n" +
            "/_/ \\_\\ |______| |_____|", 
            41
        );
    }

    @Test
    public void testConvert_Fifty() {

        assertRomanAsciiArtEquals(
            "L",
            " _      \n" +
            "| |     \n" +
            "| |     \n" +
            "| |     \n" +
            "| |____ \n" +
            "|______|", 
            50
        );
    }

    private static void assertRomanAsciiArtEquals(String roman, String asciart, int number) 
    {
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(number))
                .thenReturn(roman);

            assertEquals(asciart, RomanPrinter.print(number));
        } catch (RomanNumberException e) {};
    }
}
