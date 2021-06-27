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

public class AddItems extends Annotations {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public AddItems clickSaveAndNextButtonWithoutFillingAnything() throws InterruptedException {
		
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		WebElement saveAndNextButton = driver.findElement(By.id("formSaveNew"));
		saveAndNextButton.click();
		System.out.println("Save&Next button is clicked");
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
		String text = alert.getText();
		driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
		if(text.equals("Select Category")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		return new AddItems();
	}
	
	public AddItems clickSaveAndNextButtonAfterFillingCategory() throws InterruptedException {
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.id("select2-chosen-5")).click();
		List<WebElement> category = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		for(int k=0;k<category.size();k++) {
			if(k==14) {
			WebElement element = category.get(k);
			element.click();
			}
		}
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		WebElement saveAndNextButton = driver.findElement(By.id("formSaveNew"));
		saveAndNextButton.click();
		System.out.println("Save&Next button is clicked");
		Thread.sleep(5000);
		List<WebElement> throwError = driver.findElements(By.xpath("//small[@class='help-block']"));
		String error = null;
		for(int a=0;a<throwError.size();a++) {
			if(a==1 || a==2 || a==3) {
				WebElement element = throwError.get(a);
				error = element.getText();
			}
		}
		if(error.equals("Please enter/select a value")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		return new AddItems();
	}
	
	public AddItems checkISBNFieldGetsEnabledWhileSelectingAreYouSellingBooksCheckBox() throws InterruptedException {
		
		List<WebElement> sellingBooks = driver.findElements(By.xpath("//ins[@class='iCheck-helper']"));
		for(int a=0;a<sellingBooks.size();a++) {
			if(a==0) {
				WebElement element = sellingBooks.get(a);
				element.click();
				element.isSelected();
			}
		}
		System.out.println("Are You Selling Books Checkbox is clicked");
		Thread.sleep(2000);
		WebElement isbnEnabled = driver.findElement(By.xpath("//label[@style='display: inline-block;']"));
		String isbn = isbnEnabled.getText();
		if(isbn.equals("ISBN")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new AddItems();
	}
	
	public EditItems addItemwithoutVariant(String nameOfItem, String dimenLength,String dimenWidth,
															   String dimenHeight, String weightOfItem, String unit,
															   String cp, String sp, String expResult) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement itemName = driver.findElement(By.id("name"));
		wait.until(ExpectedConditions.visibilityOf(itemName));
		itemName.sendKeys(nameOfItem);
		WebElement itemSKU = driver.findElement(By.xpath("//div[@class='input-group-addon']//a//i"));
		itemSKU.click();
		WebElement length = driver.findElement(By.id("length"));
		length.sendKeys(dimenLength);
		WebElement width = driver.findElement(By.id("width"));
		width.sendKeys(dimenWidth);
		WebElement height = driver.findElement(By.id("height"));
		height.sendKeys(dimenHeight);
		WebElement weight = driver.findElement(By.id("weight"));
		weight.sendKeys(weightOfItem);
		WebElement unitOfMeasurement = driver.findElement(By.id("unit"));
		unitOfMeasurement.sendKeys(unit);
		WebElement costPrice = driver.findElement(By.id("cost"));
		for(int i=0;i<3;i++) {
			costPrice.sendKeys(Keys.BACK_SPACE);
		}
		costPrice.sendKeys(cp);
		jse.executeScript("window.scrollBy(0,300)");
		WebElement sellingPrice = driver.findElement(By.id("price"));
		for(int j=0;j<3;j++) {
			sellingPrice.sendKeys(Keys.BACK_SPACE);
		}
		sellingPrice.sendKeys(sp);
		driver.findElement(By.id("select2-chosen-5")).click();
		List<WebElement> category = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		System.out.println(category.size());
		for(int k=0;k<category.size();k++) {
			if(k==14) {
			WebElement element = category.get(k);
			element.click();
			}
		}
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		WebElement saveAndNext = driver.findElement(By.id("formSaveNew"));
		saveAndNext.click();
		
		Thread.sleep(2000);
		
		String toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		
		if(toastMessage.contains(expResult)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		return new EditItems();
		
	}
	
	public EditItems addItemWithVariant() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement itemName = driver.findElement(By.id("name"));
		wait.until(ExpectedConditions.visibilityOf(itemName));
		itemName.sendKeys("Item 1");
		WebElement itemSKU = driver.findElement(By.xpath("//div[@class='input-group-addon']//a//i"));
		itemSKU.click();
		jse.executeScript("window.scrollBy(0,300)");
		WebElement sellingPrice = driver.findElement(By.id("price"));
		for(int j=0;j<3;j++) {
			sellingPrice.sendKeys(Keys.BACK_SPACE);
		}
		sellingPrice.sendKeys("100");
		driver.findElement(By.id("select2-chosen-5")).click();
		List<WebElement> category = driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		System.out.println(category.size());
		for(int k=0;k<category.size();k++) {
			if(k==14) {
			WebElement element = category.get(k);
			element.click();
			}
		}
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)");
		
		List<WebElement> itemSellInSets = driver.findElements(By.xpath("//div[@class='iradio_square-blue']"));
		System.out.println(itemSellInSets.size());
		for(int b=0;b<itemSellInSets.size();b++) {
			if(b==2) {
				WebElement element = itemSellInSets.get(b);
				element.click();
				System.out.println("radio clicked");
			}
		}
		
		List<WebElement> itemVariants = driver.findElements(By.xpath("//div[@class='iradio_square-blue']"));
		System.out.println(itemVariants.size());
		for(int b=0;b<itemVariants.size();b++) {
			if(b==2) {
				WebElement element = itemVariants.get(b);
				element.click();
				System.out.println("radio clicked");
			}
		}
		
		jse.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement variants = driver.findElement(By.id("attributesInput-selectized"));
		variants.sendKeys("ML");
		variants.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement variantButton = driver.findElement(By.id("addAttributes"));
		variantButton.click();
		
		WebElement varianttypes = driver.findElement(By.id("attribute_variations-ml-selectized"));
		varianttypes.sendKeys("1000ml");
		varianttypes.sendKeys(Keys.ENTER);
		varianttypes.sendKeys("750ml");
		varianttypes.sendKeys(Keys.ENTER);
		
		WebElement generateVariants = driver.findElement(By.id("generateVariations"));
		generateVariants.click();
		
		jse.executeScript("window.scrollBy(0,300)");
		
		List<WebElement> variantSKU = driver.findElements(By.xpath("//div[@class='input-group-addon']//a[@class='genProductCode']//i"));
		System.out.println(variantSKU.size());
		
		for(int a=0;a<variantSKU.size();a++) {
			if(a==0 || a==1) {
				WebElement element = variantSKU.get(a);
				element.click();
			}
		}
		
		List<WebElement> variantLength = driver.findElements(By.xpath("//div[@class='input-group']//input[@class='form-control variationLength']"));
		for(int a=0;a<variantLength.size();a++) {
			if(a==0) {
				WebElement element = variantLength.get(a);
				element.clear();
				element.sendKeys("10");
			}
		}
		
		List<WebElement> variantWidth = driver.findElements(By.xpath("//div[@class='input-group']//input[@class='form-control variationWidth']"));
		for(int a=0;a<variantWidth.size();a++) {
			if(a==0) {
				WebElement element = variantWidth.get(a);
				element.clear();
				element.sendKeys("10");
			}
		}
		
		List<WebElement> variantHeight = driver.findElements(By.xpath("//div[@class='input-group']//input[@class='form-control variationHeight']"));
		for(int a=0;a<variantHeight.size();a++) {
			if(a==0) {
				WebElement element = variantHeight.get(a);
				element.clear();
				element.sendKeys("10");
			}
		}
		
		List<WebElement> variantQty = driver.findElements(By.name("attr_quantity[]"));
		for(int a=0;a<variantQty.size();a++) {
			if(a==0 || a==1 || a==2 || a==3 || a==4 || a==5 || a==6 || a==7 || a==8 || a==9 || a==10 || a==11) {
				WebElement element = variantQty.get(a);
				element.clear();
				element.sendKeys("1000");
			}
		}
		
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,500)");
		
		WebElement saveAndNext = driver.findElement(By.id("formSaveNew"));
		saveAndNext.click();
		
		Thread.sleep(3000);
		String toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	    if (toastMessage.contains("Item successfully added")) {
	        Assert.assertTrue(true);
	        System.out.println("Test - Add item with variant Passed");
	    } else {
	        Assert.assertTrue(false);
	        System.out.println("Test - Add item with variant failed");
	    }
		
		
		return new EditItems();
	}
	

}
