////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;

public class IntegerToRoman {

  static int ValuesRange[];
  static String RomanLetters[];

  public IntegerToRoman()
  {
    ValuesRange = new int[]{
      100,90,50,40,10,9,5,4,1
    };  
    RomanLetters = new String[]{
      "C","XC","L","XL","X","IX","V","IV","I"
    };
  }

  public static String convert(int number) throws RomanNumberException {

    if (number < 0) 
    {
      throw new RomanNumberException(
        "Negative numbers are not convertible into Roman ones"
      );
    }
    if (number == 0) 
    {
      throw new RomanNumberException(
        "0 is not convertible into a Roman number"
      );
    }
    if (number >= 4000) 
    {
      throw new RomanNumberException(
        "I, V, X, L, C, D and M only support numbers from 1 to 3999"
      );
    }
    
    StringBuilder RomanNumber = new StringBuilder();  
      
    for(int i = 0; i < ValuesRange.length; i++)   
    {  
      while(number >= ValuesRange[i])   
      {  
        number = number - ValuesRange[i];  
        RomanNumber.append(RomanLetters[i]);  
      }  
    }  
    return RomanNumber.toString();
  }
}
