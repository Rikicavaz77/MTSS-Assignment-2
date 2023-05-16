////////////////////////////////////////////////////////////////////
// Riccardo Cavalli 2042893
// Pietro Giovanni Marchiorato 2042365
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exceptions.RomanNumberException;

public class IntegerToRoman {

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
    return null;
  }
}
