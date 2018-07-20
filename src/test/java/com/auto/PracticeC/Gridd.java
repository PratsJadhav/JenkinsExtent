package com.auto.PracticeC;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Gridd {

	public static void main(String args[]) throws MalformedURLException
	{
		String url = "http://192.168.1.100:4444/wd/hub";
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		WebDriver driver = new RemoteWebDriver(new URL(url),dc);
		
		driver.get("https://www.google.com/");
		
	}
}
