package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class PassengerDetails extends base {

	public WebDriver driver;

	public PassengerDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Passenger Details
	@FindBy(xpath = "//input[@id='passengers']")
	WebElement passengers;

	public WebElement passengers() {
		return passengers;
	}

	// Selecting number of Adults add/subs
	@FindBy(xpath = "//button[@id='adds']")
	WebElement AdultAdd;

	public WebElement AdultAdd() {
		return AdultAdd;
	}

	@FindBy(xpath = "//button[@id='subs']")
	WebElement AdultSubs;

	public WebElement AdultSubs() {
		return AdultSubs;
	}

	// Selecting number of Children add/subs
	@FindBy(xpath = "//button[@id='adds_child']")
	WebElement ChildAdd;

	public WebElement ChildAdd() {
		return ChildAdd;
	}

	@FindBy(xpath = "//button[@id='subs_child']")
	WebElement ChildSubs;

	public WebElement ChildSubs() {
		return ChildSubs;
	}

	// Selecting number of infants add/subs
	@FindBy(xpath = "//button[@id='adds_infant']")
	WebElement InfantAdd;

	public WebElement InfantAdd() {
		return InfantAdd;
	}

	@FindBy(xpath = "//button[@id='subs_infant']")
	WebElement InfantSubs;

	public WebElement InfantSubs() {
		return InfantSubs;
	}

	@FindBy(xpath = "//button[@class='pre_btn']")
	WebElement EconomyClass;

	public WebElement EconomyClass() {
		return EconomyClass;
	}

	@FindBy(xpath = "//button[contains(text(),'Premium')]")
	WebElement PremiumEconomyClass;

	public WebElement PremiumEconomyClass() {
		return PremiumEconomyClass;
	}

	@FindBy(xpath = "//button[@class='bu_btn clk_travel_cls_btn']")
	WebElement BusinessClass;

	public WebElement BusinessClass() {
		return BusinessClass;
	}

	@FindBy(xpath = "//div[@id='passengerModal']//div//div//div//div//button[contains(text(),'Done')]")
	WebElement pdDone;

	public WebElement pdDone() {
		return pdDone;
	}
}
