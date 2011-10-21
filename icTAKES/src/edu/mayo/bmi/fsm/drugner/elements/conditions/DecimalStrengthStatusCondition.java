package edu.mayo.bmi.fsm.drugner.elements.conditions;

import net.openai.util.fsm.Condition;
import edu.mayo.bmi.fsm.drugner.output.util.DecimalStrengthToken;
/**
 * Checks whether a token is a FractionToken.
 * @author Mayo Clinic
 */
public class DecimalStrengthStatusCondition extends Condition
{
	public boolean satisfiedBy(Object conditional)
	{
		if (conditional instanceof DecimalStrengthToken)
		{
			return true;
		}
        	
		return false;
	}		
}
