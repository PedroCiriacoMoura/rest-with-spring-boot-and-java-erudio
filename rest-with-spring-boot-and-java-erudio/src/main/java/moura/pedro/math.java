package moura.pedro;

import moura.pedro.converters.StringToDouble;

public class math {

	public static Double sum (String numberOne, String numberTwo){return StringToDouble.convertToDouble(numberOne) + StringToDouble.convertToDouble(numberTwo);}
	
	public static Double sub (String numberOne, String numberTwo){return StringToDouble.convertToDouble(numberOne) - StringToDouble.convertToDouble(numberTwo);}
	
	public static Double mult (String numberOne, String numberTwo){return StringToDouble.convertToDouble(numberOne) * StringToDouble.convertToDouble(numberTwo);}
	
	public static Double div (String numberOne, String numberTwo){return StringToDouble.convertToDouble(numberOne) / StringToDouble.convertToDouble(numberTwo);}
	
	public static Double ava (String numberOne, String numberTwo){return (StringToDouble.convertToDouble(numberOne) + StringToDouble.convertToDouble(numberTwo))/2;}
	
	public static Double sour (String numberOne){return StringToDouble.convertToDouble(numberOne) * StringToDouble.convertToDouble(numberOne);}
}
