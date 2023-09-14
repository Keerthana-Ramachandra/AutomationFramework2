package testNG.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertPractice
{
	@Test
public void test()
{
		System.out.println("Stsrted");
	Assert.assertEquals("a", "b");
	System.out.println("All done");
}
}
