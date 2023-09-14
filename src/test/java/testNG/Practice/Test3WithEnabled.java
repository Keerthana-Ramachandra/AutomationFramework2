package testNG.Practice;

import org.testng.annotations.Test;

public class Test3WithEnabled

{
	
	//Priority can be positive integer
@Test (enabled=false)
public void create()
{
	System.out.println("create customer");
}
//Priority can be zero. default value is zero if we wont give priority to any method then that will be considered as default
@Test 
public void modify()
{
	System.out.println("modify customer");
}

//Priority can be negative integer. if priority ois not given then it will execute based on ascii value
@Test 
public void delete()
{
	System.out.println("delete customer");
}
}
