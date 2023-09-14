package testNG.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1
{
	
	// need to give dataProvider flag to read data from taht
@Test (dataProvider = "getdata")

//Parameterize the data
public void addProductToCart(String type, float price, String color, String material)
{
	System.out.println(type+"-" +price+ "-"+color+"-"+material);
}

//it is used to aload data to test script. Test script will read data frpm data provider one after another. the number of execution= no of set of data
@DataProvider
//always return type will be 2 dimensional object array. as it is object array we can store any data type data
public Object[][] getdata()
{
	//create object of array
	//first []represents row second[]represents column
	//here we have 3 set of data and 4 information
	Object[][]  data= new Object[3][4];
	
	//entering data
	data[0][0]="Kurtha";
	data[0][1]=700f;
	data[0][2]="red";
	data[0][3]="cotton";
	
	data[1][0]="Saree";
	data[1][1]=1800.00f;
	data[1][2]="White";
	data[1][3]="geoget";
	
	data[2][0]="Top";
	data[2][1]=900.00f;
	data[2][2]="Black";
	data[2][3]="Silk";
	
	return data;
	
}
}
