package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import wrappers.Annotations;

public class Items extends Annotations {
	
	public AddItems clickNewItemButton() {
		WebElement newItemButton = driver.findElement(By.xpath("//div[@class='col-md-12 text-right']//a"));
		newItemButton.click();
		System.out.println("Clicked New Item button");
		return new AddItems();
	}
	
	public Items displayItemsForTenPerPage() throws Exception {
		driver.findElement(By.id("select2-chosen-2")).click();
		List<WebElement> displayPagination = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		for(int a=0;a<displayPagination.size();a++) {
			if(a==0) {
				WebElement element = displayPagination.get(a);
				element.click();
			}
		}
		Thread.sleep(10000);
		List<WebElement> totalItemsInPageOne = driver.findElements(By.xpath("//table[@id='PRData']//tbody//tr"));
		System.out.println(totalItemsInPageOne.size());
		if(totalItemsInPageOne.size()==10) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new Items();
	}
	
	public Items displayItemsForTwentyFivePerPage() throws Exception {
		driver.findElement(By.id("select2-chosen-2")).click();
		List<WebElement> displayPagination = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		for(int a=0;a<displayPagination.size();a++) {
			if(a==1) {
				WebElement element = displayPagination.get(a);
				element.click();
			}
		}
		Thread.sleep(10000);
		List<WebElement> totalItemsInPageOne = driver.findElements(By.xpath("//table[@id='PRData']//tbody//tr"));
		System.out.println(totalItemsInPageOne.size());
		if(totalItemsInPageOne.size()==25) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new Items();
	}
	
	public Items displayItemsForFiftyPerPage() throws Exception {
		driver.findElement(By.id("select2-chosen-2")).click();
		List<WebElement> displayPagination = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		for(int a=0;a<displayPagination.size();a++) {
			if(a==2) {
				WebElement element = displayPagination.get(a);
				element.click();
			}
		}
		Thread.sleep(10000);
		List<WebElement> totalItemsInPageOne = driver.findElements(By.xpath("//table[@id='PRData']//tbody//tr"));
		System.out.println(totalItemsInPageOne.size());
		if(totalItemsInPageOne.size()==50) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new Items();
	}
	
	public Items displayItemsForHundredPerPage() throws Exception {
		driver.findElement(By.id("select2-chosen-2")).click();
		List<WebElement> displayPagination = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		for(int a=0;a<displayPagination.size();a++) {
			if(a==3) {
				WebElement element = displayPagination.get(a);
				element.click();
			}
		}
		Thread.sleep(10000);
		List<WebElement> totalItemsInPageOne = driver.findElements(By.xpath("//table[@id='PRData']//tbody//tr"));
		System.out.println(totalItemsInPageOne.size());
		if(totalItemsInPageOne.size()==100) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new Items();
	}
	
	public Items clickActionsButton() {
		
		List<WebElement> actionsButton = driver.findElements(By.xpath("//button[@class='btn btn-default dropdown-toggle btn-xs']"));
		for(int a=0;a<actionsButton.size();a++) {
			if(a==0) {
				WebElement element = actionsButton.get(a);
				element.click();
			}
		}
		return new Items();
	}
	
	public EditItems clickEditItem() {
		WebElement editItem = driver.findElement(By.xpath("//div[@class='btn-group text-left dropdown open']//ul//li[1]//a"));
		editItem.click();
		return new EditItems();
	}
	
	

}
