////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;
import java.util.Objects;

public class RomanPrinter {

  static int positionArray[];
  static String romanSymbol[][];

  public RomanPrinter()
  {
    positionArray = new int[100];
    romanSymbol = new String[6][7];

    positionArray[73] = 0;
    romanSymbol[0][0] = " _____ "; 
    romanSymbol[1][0] = "|_   _|";  
    romanSymbol[2][0] = "  | |  "; 
    romanSymbol[3][0] = "  | |  ";
    romanSymbol[4][0] = " _| |_ "; 
    romanSymbol[5][0] = "|_____|"; 

    positionArray[86] = 1;
    romanSymbol[0][1] = "__      __"; 
    romanSymbol[1][1] = "\\ \\    / /";
    romanSymbol[2][1] = " \\ \\  / / "; 
    romanSymbol[3][1] = "  \\ \\/ /  "; 
    romanSymbol[4][1] = "   \\  /   "; 
    romanSymbol[5][1] = "    \\/    ";

    positionArray[88] = 2;
    romanSymbol[0][2] = "__   __"; 
    romanSymbol[1][2] = "\\ \\ / /";
    romanSymbol[2][2] = " \\ V / "; 
    romanSymbol[3][2] = "  > <  "; 
    romanSymbol[4][2] = " / . \\ "; 
    romanSymbol[5][2] = "/_/ \\_\\";

    positionArray[76] = 3;
    romanSymbol[0][3] = " _      "; 
    romanSymbol[1][3] = "| |     ";
    romanSymbol[2][3] = "| |     ";
    romanSymbol[3][3] = "| |     ";
    romanSymbol[4][3] = "| |____ ";
    romanSymbol[5][3] = "|______|";

    positionArray[67] = 4;
    romanSymbol[0][4] = "  _____ "; 
    romanSymbol[1][4] = " / ____|";
    romanSymbol[2][4] = "| |     ";
    romanSymbol[3][4] = "| |     ";
    romanSymbol[4][4] = "| |____ ";
    romanSymbol[5][4] = " \\_____|";

    positionArray[68] = 5;
    romanSymbol[0][5] = " _____  "; 
    romanSymbol[1][5] = "|  __ \\ ";
    romanSymbol[2][5] = "| |  | |";
    romanSymbol[3][5] = "| |  | |";
    romanSymbol[4][5] = "| |__| |";
    romanSymbol[5][5] = "|_____/ ";

    positionArray[77] = 6;
    romanSymbol[0][6] = " __  __ "; 
    romanSymbol[1][6] = "|  \\/  |";
    romanSymbol[2][6] = "| \\  / |";
    romanSymbol[3][6] = "| |\\/| |";
    romanSymbol[4][6] = "| |  | |";
    romanSymbol[5][6] = "|_|  |_|";
  }

  public static String print(int num) 
  throws RomanNumberException {
    return printAsciiArt(IntegerToRoman.convert(num));
  }

  private static String printAsciiArt(String romanNumber) 
  throws RomanNumberException {
    Objects.requireNonNull(romanNumber, "The roman number must not be null");

    if (romanNumber == "") 
    {
      throw new RomanNumberException(
        "You cannot print an empty string in Roman AsciiArt"
      );
    }
    if (romanNumber.length() > 12) 
    {
      throw new RomanNumberException(
        "You cannot print a Roman number longer than 12 characters"
      );
    }
    if (romanNumber.startsWith("MMMM")) 
    {
      throw new RomanNumberException(
        "You cannot print a Roman number greater than 3999"
      );
    }
    if (romanNumber.replaceAll("[IVXLCDM]*", "").length() > 0)
    {
      throw new RomanNumberException(
        "The string contains incompatible characters"
      );
    }
    
    String romanAsciiArt = "";

    for (int i = 0; i < 6; i++)
    {
      for (int j = 0; j < romanNumber.length(); j++)
      {
        romanAsciiArt += romanSymbol[i][positionArray[(romanNumber.charAt(j))]];

        if (j + 1 != romanNumber.length())
        {
          romanAsciiArt += " ";
        }
      }
      if (i + 1 != 6)
      {
        romanAsciiArt += "\n";
      }
    }
    return romanAsciiArt;
  }
}
