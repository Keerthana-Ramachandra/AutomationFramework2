package vtiger.practice;

import org.openqa.selenium.WebDriver;

public class Addition
{
	
	public  static int add(int q, int w, int e)
	
	{
		int r= q+w+e;
		return r;
	}
	
	
	public static void main(String[] args)
	{
		Addition a= new Addition();
	int sum= a.add(7, 8, 9);
	System.out.println(sum);
	

	}

}
