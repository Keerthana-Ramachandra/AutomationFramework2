package testNG.Practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//When u are using listners u should mention@listners and copy fully qualified class name. give .class extension as it accept class file path
//u should always give listeners annotation at class level
@Listeners(vtiger.genericUtilities.ListnersImplementation.class)
public class ListnersPractice
{
	@Test
public void test()
{
		System.out.println("Hi");
}

}
