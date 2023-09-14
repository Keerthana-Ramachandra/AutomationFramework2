package testNG.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3WithDependsOnMethods

{
	
	//Priority can be positive integer
@Test 
public void create()
{
	//for purposefully failing the script
	Assert.fail();
	System.out.println("create customer");
}
//we can give more than one method
@Test (dependsOnMethods = {"create","delete" })
public void modify()
{
	System.out.println("modify customer");
}

//Priority can be negative integer. if priority ois not given then it will execute based on ascii value
@Test (dependsOnMethods = "create")
public void delete()
{
	System.out.println("delete customer");
}
}
