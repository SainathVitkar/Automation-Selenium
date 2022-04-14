package TestNG;

import org.testng.annotations.Test;

public class Groups1 
{
	@Test (groups = {"Sainath"})
	public void test1()
	{
		System.out.println("test1");
	}
	
	@Test (groups = {"Vitkar"})
	public void test2()
	{
		System.out.println("test2");
	
	}
	
	@Test (groups = {"Sainath"})
	public void test3()
	{
		System.out.println("test3");
	}
	
	@Test (groups = {"Vitkar"})
	public void test4()
	{
		System.out.println("test4");
	}

}
