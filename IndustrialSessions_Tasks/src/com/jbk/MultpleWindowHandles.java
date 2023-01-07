package com.jbk;

import java.util.Iterator;
import java.util.Set;

public class MultpleWindowHandles {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Windows.html");
	
	String parent=driver.getWindowHandle();
	
	Set<String> s=driver.getWindowHandles();
	
	Iterator<String> I1=s.iterator();
	
	while(I1.hasNext())
	{
		String childWindow=I1.next();
		
		if(!parent.equals(childWindow))
		{
			driver.switchTo().window(childWindow);
			System.out.println(driver.switchTo().window(childWindow).getTitle());
			driver.close();
		}
	}
	driver.switchTo().window(parent);
}
}
