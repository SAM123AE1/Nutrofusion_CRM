package Nutro_CRM_AssertUtility;

import org.testng.Assert;


public class HardAssertCalling {
	
	
	
	public void  hardAssertforboolean(String expvalue,String actvalue)
	{
		 boolean value=expvalue.contains(actvalue);
		Assert.assertTrue(value);
	}
	

}
