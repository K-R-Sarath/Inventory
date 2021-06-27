package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AddItems;
import pages.Dashboard;
import pages.EditItems;
import pages.Items;
import pages.LoginPage;
import wrappers.Annotations;

public class ItemTest extends Annotations {
	
	//@Test(priority=0)
	public void clickSaveAndNextButtonWithoutFillingAnythingInAddItemsPage() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickNewItemButton();
		new AddItems()
		.clickSaveAndNextButtonWithoutFillingAnything();
		
	}
	
	//@Test(priority=1)
	public void clickSaveAndNextButtonAfterFillingCategory() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickNewItemButton();
		new AddItems()
		.clickSaveAndNextButtonAfterFillingCategory();
	}
	
	//@Test(priority=2)
	public void checkISBNFieldGetsEnabledWhileSelectingAreYouSellingBooksCheckBox() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickNewItemButton();
		new AddItems()
		.checkISBNFieldGetsEnabledWhileSelectingAreYouSellingBooksCheckBox();
	}
	
	//@Test(dataProvider="fetchData1",priority=3)
	public void addItemWithoutVariant(String nameOfItem, String dimenLength,String dimenWidth,
			   						  String dimenHeight, String weightOfItem, String unit,
			   						  String cp, String sp, String expResult) throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickNewItemButton();
		new AddItems()
		.addItemwithoutVariant(nameOfItem, dimenLength, dimenWidth, dimenHeight, weightOfItem, unit, cp, sp, expResult);
	}
	
	//@Test(priority=4)
	public void addItemWithVariant() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickNewItemButton();
		new AddItems()
		.addItemWithVariant();
	}
	
	//@Test(priority=0)
	public void displayTenItemsPerPage() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.displayItemsForTenPerPage();
	}
	
	//@Test(priority=1)
	public void displayTwentyFiveItemsPerPage() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.displayItemsForTwentyFivePerPage();
	}
	
	//@Test(priority=2)
	public void displayFiftyItemsPerPage() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.displayItemsForFiftyPerPage();
		
	}
	
	//@Test(priority=3)
	public void displayHundredItemsPerPage() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.displayItemsForHundredPerPage();
		
	}
	
	//@Test
	public void editItem() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickActionsButton()
		.clickEditItem()
		.editItem();
	}
	
	/*@Test
	public void editQuantity() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickActionsButton()
		.clickEditItem()
		.goToLocationsTab()
		.editQuantity();
	}*/
	
	//@Test
	public void clickSaveLocationBtnWithoutFillingAnything() throws Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickActionsButton()
		.clickEditItem()
		.goToLocationsTab()
		.clickAddNewLocationButton()
		.clickSaveLocationBtnWithoutFillingAnything();
	}
	
	@Test
	public void clickSaveLocationBtnByFillingMandatoryFields() throws IOException, Exception {
		new LoginPage()
		.login("asalta.trial@gmail.com", "Welc0me.12", "Dashboard - Asalta Inventory");
		new Dashboard()
		.clickInventoryInSideMenu()
		.clickItems();
		new Items()
		.clickActionsButton()
		.clickEditItem();
		new EditItems()
		.goToLocationsTab()
		.clickAddNewLocationButton()
		.clickSaveLocationBtnByFillingMandatoryFields();
	}

}
