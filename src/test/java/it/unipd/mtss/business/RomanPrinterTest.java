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
    public void testPrint_WithLegalInput() throws RomanNumberException {
        
        try (MockedStatic<IntegerToRoman> utilities = Mockito.mockStatic(IntegerToRoman.class)) {
            utilities.when(() -> IntegerToRoman.convert(1))
                .thenReturn("I");
            
            assertEquals(null, RomanPrinter.print(1));
        }       
    }
}
