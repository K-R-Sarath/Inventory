package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import wrappers.Annotations;

public class EditItems extends Annotations {

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public EditItems editItem() throws InterruptedException {
		
		WebElement sellingPrice = driver.findElement(By.id("price"));
		for(int j=0;j<3;j++) {
			sellingPrice.sendKeys(Keys.BACK_SPACE);
		}
		for(int a=0;a<4;a++) {
			sellingPrice.sendKeys(Keys.BACK_SPACE);
		}
		sellingPrice.sendKeys("1200");
		
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		
		WebElement saveAndNext = driver.findElement(By.id("formSaveNew"));
		saveAndNext.click();
		
		String toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		
		if(toastMessage.contains("Item successfully updated")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
		return new EditItems();
	}
	
	public EditItems goToLocationsTab() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement locationsTab = driver.findElement(By.xpath("//div[@class='box-content']//ul[@id='myTab']//li[2]"));
		wait.until(ExpectedConditions.visibilityOf(locationsTab));
		locationsTab.click();
		Thread.sleep(1000);
		locationsTab.click();
		Thread.sleep(1000);
		locationsTab.click();
		System.out.println("Clicked Locations Tab");
		return new EditItems();
	}
	
//	public EditItems editQuantity() throws Exception {
//		
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement location = driver.findElement(By.xpath("//div[@class='box']//div[@class='box-header']//h2"));
//		wait.until(ExpectedConditions.visibilityOf(location));
//		
//		jse.executeScript("window.scrollBy(0,300)");
//		System.out.println("Scrolled down");
//		WebElement editQuantity = driver.findElement(By.xpath("//tbody[@role='alert']//tr[1]//td[4]"));
//		editQuantity.click();
//		
//		Thread.sleep(3000);
//		WebElement editQuantity1 = driver.findElement(By.name("wh_qty_20"));
//		editQuantity1.clear();
//		editQuantity1.sendKeys("1000");
//		
//		WebElement saveQuantity = driver.findElement(By.id("formSaveWarehouse"));
//		saveQuantity.click();
//		
//		String toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
//	    if(toastMessage.equals("Location details updated successfully")) {
//	    	Assert.assertTrue(true);
//	    }else {
//	    	Assert.assertTrue(false);
//	    }
//		
//		return new EditItems();
//		
//	}
	
	public EditItems clickAddNewLocationButton() throws Exception {
		
		List<WebElement> addNewLocationBtn = driver.findElements(By.xpath("//div[@class='form-group text-right']//a//button[@class='btn btn-default']"));
		for(int a=0;a<2;a++) {
			if(a==0) {
				WebElement element = addNewLocationBtn.get(a);
				element.click();
			}
		}
		System.out.println("Clicked Add New Location Button");
		Thread.sleep(2000);
		return new EditItems();
	}
	
	public EditItems clickSaveLocationBtnWithoutFillingAnything() throws Exception {
		
		WebElement saveLocationBtn = driver.findElement(By.xpath("//div[@class='modal-footer']//div//div//input[@name='add_warehouse']"));
		Thread.sleep(2000);
		saveLocationBtn.click();
		
		System.out.println("Clicked Save Location button");
		
		List<WebElement> actual = driver.findElements(By.xpath("//small[@class='help-block']"));
		System.out.println(actual.size());
		String result = null;
		for(int a=0;a<actual.size();a++) {
			if(a==7 || a==8 || a==10 || a==12) {
				WebElement element = actual.get(a);
				result = element.getText();
				Thread.sleep(1000);
			}
		}
		System.out.println("Errors captured");
		if(result.equals("Please enter/select a value")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new EditItems();
	}
	
	public EditItems clickSaveLocationBtnByFillingMandatoryFields() throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement locationCode = driver.findElement(By.xpath("//div[@class='input-group']//div[@class='input-group-addon']//a[@id='genWarehouseCode']//i[@class='fa fa-cogs']"));
		wait.until(ExpectedConditions.visibilityOf(locationCode));
		Thread.sleep(1000);
		locationCode.click();
		WebElement locationName = driver.findElement(By.xpath("//div[@class='col-md-8 controls']//input[@id='name']"));
		locationName.sendKeys("Test Location 001");
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("56 Lavender street");
		WebElement postalCode = driver.findElement(By.id("postal_code"));
		postalCode.sendKeys("656532");
		
		WebElement saveLocationBtn = driver.findElement(By.xpath("//div[@class='modal-footer']//div//div//input[@name='add_warehouse']"));
		Thread.sleep(2000);
		saveLocationBtn.click();
		
		return new EditItems();
	}
	
	public EditItems addCustomField() throws Exception {
		
		WebElement addCustomFieldButton = driver.findElement(By.xpath("//div[@class='col-md-6 text-right']//button[@class='btn btn-default']"));
		jse.executeScript("arguments[0].scrollIntoView();", addCustomFieldButton);
		addCustomFieldButton.click();
		
		Thread.sleep(1000);
		WebElement saveBtn = driver.findElement(By.id("formSaveCustom"));
		saveBtn.click();
		
		WebElement getError = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
		String result = getError.getText();
		WebElement closeError = driver.findElement(By.xpath("//div[@class='modal-footer']//button[@data-bb-handler='ok']"));
		closeError.click();
		if(result.equals("All fields are required")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		Thread.sleep(5000);
		return new EditItems();
	}
	
	public EditItems addAnotherCustomField() throws Exception {
		
		WebElement addCustomFieldButton = driver.findElement(By.xpath("//div[@class='col-md-6 text-right']//button[@class='btn btn-default']"));
		jse.executeScript("arguments[0].scrollIntoView();", addCustomFieldButton);
		addCustomFieldButton.click();
		
		Thread.sleep(1000);
		
		WebElement anotherCustomField = driver.findElement(By.xpath("//button[@id='addCustomField']"));
		anotherCustomField.click();
		Thread.sleep(1000);
		
		WebElement deleteAnotherCustomField = driver.findElement(By.xpath("//button[@class='btn btn-xs qudel']//i"));
		deleteAnotherCustomField.click();
		Thread.sleep(1000);
		List<WebElement> close = driver.findElements(By.xpath("//button[@class='close']//i"));
		for(int a=close.size()-1;a>=0;a--) {
			if(a==1 || a==0) {
				WebElement element = close.get(a);
				element.click();
				Thread.sleep(1000);
			}
		}
		
		return this;
		
	}
	
	public EditItems goToChannelsTab() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement channelsTab = driver.findElement(By.xpath("//div[@class='box-content']//ul[@id='myTab']//li[3]"));
		wait.until(ExpectedConditions.visibilityOf(channelsTab));
		channelsTab.click();
		Thread.sleep(1000);
		channelsTab.click();
		
		return this;
	}
	
	
	
	
	
}
