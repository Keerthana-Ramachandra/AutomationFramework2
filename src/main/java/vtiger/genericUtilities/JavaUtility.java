package vtiger.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * This class consists of reusable methods related to java
 * @author Keerthi
 *
 */
public class JavaUtility 
{
	
/**
 * this method will return random number for every execution	
 * @return
 */
	public int randomNumber()
	{
		Random r= new Random();
		int number = r.nextInt(1000);
		return number;
	}
	
/**
 * This method will generate current system date in specified format
 * @return
 */
	public String getSystemDate()
	{
		Date d= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date = sdf.format(d);
		return date;
	}
}


