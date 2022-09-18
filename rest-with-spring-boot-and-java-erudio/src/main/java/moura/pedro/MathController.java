package moura.pedro;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import moura.pedro.converters.StringToDouble;
import moura.pedro.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double sum(@PathVariable (value = "numberOne") String numberOne,
					  @PathVariable (value = "numberTwo") String numberTwo) 
	throws Exception {
	{
		
		if (!StringToDouble.isNumeric(numberOne) || !StringToDouble.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
			}
		return math.sum(numberOne, numberTwo);
	} 
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double sub(@PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) 
					throws Exception {
		{
			
			if (!StringToDouble.isNumeric(numberOne) || !StringToDouble.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
			return math.sub(numberOne, numberTwo);
		} 
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double mult(@PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) 
					throws Exception {
		{
			
			if (!StringToDouble.isNumeric(numberOne) || !StringToDouble.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
			return math.mult(numberOne, numberTwo);
		} 
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double div(@PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) 
					throws Exception {
		{
			
			if (!StringToDouble.isNumeric(numberOne) || !StringToDouble.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
			return math.div(numberOne, numberTwo);
		} 
	}
	
	@RequestMapping(value = "/ava/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double ava(@PathVariable (value = "numberOne") String numberOne,
			@PathVariable (value = "numberTwo") String numberTwo) 
					throws Exception {
		{
			
			if (!StringToDouble.isNumeric(numberOne) || !StringToDouble.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
			return math.ava(numberOne, numberTwo);
		} 
	}
	
	
	@RequestMapping(value = "/sour/{numberOne}",
			method = RequestMethod.GET)
	public Double sour(@PathVariable (value = "numberOne") String numberOne) 
					throws Exception {
		{
			
			if (!StringToDouble.isNumeric(numberOne)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
			return math.sour(numberOne);
		} 
	}
	
	

}
