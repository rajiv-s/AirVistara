package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.base;

public class HomePage extends base {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Country and Language pop up
	@FindBy(xpath = "//button[@id='domain-done']")
	WebElement popupsubmit;

	public WebElement popupsubmit() {
		return popupsubmit;
	}

	// Round Trip button
	@FindBy(id = "roundtrip")
	WebElement RoundTrip;

	public WebElement RoundTrip() {
		return RoundTrip;
	}

	// One Way Trip button
	@FindBy(id = "onewaytrip")
	WebElement OneWayTrip;

	public WebElement OneWayTrip() {
		return OneWayTrip;
	}

	// Origin place
	@FindBy(xpath = "//div[@id='departsfrom-div']//input[@placeholder='Origin']")
	WebElement Origin;

	public WebElement Origin() {
		return Origin;
	}

	// Departure place
	@FindBy(name = "flightSearchTo")
	WebElement Departure;

	public WebElement Departure() {
		return Departure;
	}

	// Search button button
	@FindBy(xpath = "//button[@id='search_book_flights_1']")
	WebElement SearchFlights;

	public WebElement SearchFlights() {
		return SearchFlights;
	}

}
