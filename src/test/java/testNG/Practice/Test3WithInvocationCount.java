package testNG.Practice;

import org.testng.annotations.Test;

public class Test3WithInvocationCount

{
	
	//Priority can be positive integer
@Test (invocationCount =7)
public void create()
{
	System.out.println("create customer");
}
//Priority can be zero. default value is zero if we wont give priority to any method then that will be considered as default
@Test ( invocationCount = 2, priority=-1)
public void modify()
{
	System.out.println("modify customer");
}

//Priority can be negative integer. if priority ois not given then it will execute based on ascii value
@Test (invocationCount = 3)
public void delete()
{
	System.out.println("delete customer");
}
}
