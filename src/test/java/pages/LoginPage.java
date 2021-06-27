package pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import wrappers.Annotations;

public class LoginPage extends Annotations {
	
	public Dashboard login(String uname, String pwd, String expected) throws IOException, Exception {
		WebElement username = driver.findElement(By.id("identity"));
		username.sendKeys(uname);
		System.out.println("Username entered");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);
		System.out.println("Password entered");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='btn loginbtn pull-right']"));
		loginBtn.click();
		System.out.println("Login button is clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals(expected)) {
			Assert.assertTrue(true);
			System.out.println("Login Test Passed");
		}
		else if(title.equals("Asalta POS & Inventory")) {
			
			List<WebElement> text = driver.findElements(By.xpath("//span[@class='forgot-error']//p"));
			String failedText = null;
			for(int a=0;a<text.size();a++) {
				if(a==0) {
					WebElement element = text.get(a);
					failedText = element.getText();
				}
			}
			System.out.println(failedText);
			if(failedText.equals(expected)) {
				Assert.assertTrue(true);
				System.out.println("Login Test Passed");
			}else {
				Assert.assertTrue(false);
				System.out.println("Login Test Faled");
				
			}
		}
		
		return new Dashboard();
		}

	}

