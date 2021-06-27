package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import wrappers.Annotations;


public class Dashboard extends Annotations {
	
	public Dashboard clickInventoryInSideMenu() throws Exception {
		WebElement sideMenuInventory = driver.findElement(By.xpath("//div[@id='sidebar_menu']//ul//li/a//i[@class='fa fa-cubes']"));
		sideMenuInventory.click();
		System.out.println("Clicked Inventory in Side Menu");
		return new Dashboard();
	}
	
	public Items clickItems() {
		WebElement items = driver.findElement(By.id("products_index"));
		items.click();
		System.out.println("Clicked Items under Inventory in side menu");
		return new Items();
	}
	
	

}
