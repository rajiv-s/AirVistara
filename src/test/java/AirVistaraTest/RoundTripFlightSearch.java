package AirVistaraTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CalendarOptions;
import pageObjects.HomePage;
import pageObjects.PassengerDetails;
import resources.base;

public class RoundTripFlightSearch extends base {
	public static final Logger log = LogManager.getLogger(RoundTripFlightSearch.class.getName());

	// Initializing the browser mentioned in properties file.
	// Change browser=IE for Microsoft Internet Explorer Browser
	// Change browser=FireFox for Firefox browser
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test
	public void RoundTrip() throws IOException, InterruptedException {

		// Closing the Country and Language Pop up
		HomePage hp = new HomePage(driver);
		hp.popupsubmit().click();

		// Selecting Round Trip or One Way Trip
		Boolean TripSelected = hp.RoundTrip().isSelected();
		if (TripSelected == true) {
			hp.OneWayTrip().click();
			log.info("One Way Trip selected successfully");
		} else {
			log.info("Round Trip is selected by default.");
		}

		// Selecting the flight origin
		hp.Origin().sendKeys("DEL");
		Thread.sleep(1000);
		Actions KeyDown = new Actions(driver);
		KeyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(1000);
		log.info("Successfully selected Flight Origin as DELHI");

		// Selecting the destination place
		hp.Departure().sendKeys("HYD");
		Thread.sleep(2000);
		KeyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
		Thread.sleep(1000);
		log.info("Successfully selected Destination place as HYDERABAD.");

		// Travel Dates -
		// Date of departure is set to current date and return date is set to next year.
		CalendarOptions co = new CalendarOptions(driver);
		co.Day().click();
		co.NxtYear().click();
		co.NxtYrMonth().click();
		co.NxtYrDay().click();
		Thread.sleep(1000);
		log.info("Departure is Today and Return date selected is February 3, 2021.");

		// Giving Passenger Details as 4 Adults and 1 Child
		PassengerDetails pd = new PassengerDetails(driver);
		pd.passengers().click();
		WebDriverWait Wait = new WebDriverWait(driver, 5);
		Wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("//div[@class='modal-dialog passenger_modal']//div[@class='modal-content']"))));

		for (int i = 0; i < 3; i++)
			pd.AdultAdd().click();
		pd.ChildAdd().click();
		pd.InfantAdd().click();
		pd.InfantSubs().click();
		log.info("Passengers selected - 4 Adults and 1 Child.");

		// Selecting Flight Class as Premium Economy from Properties file.
		// Change classOptions in properties file to select Economy/Business class
		Properties prop;
		{
			prop = new Properties();
			FileInputStream fil = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties\\");
			prop.load(fil);
			String selectClass = prop.getProperty("classOptions");
			log.info(selectClass + " class is selected. ");

			if (selectClass.equals("Economy")) {
				pd.EconomyClass().click();
			} else if (selectClass.equals("Premium Economy")) {
				pd.PremiumEconomyClass().click();
			} else if (selectClass.equals("Business")) {
				pd.BusinessClass().click();
			}

		}

		// Confirming the passenger details
		pd.pdDone().click();

		// Searching for available flights
		hp.SearchFlights().click();

	}

	// Closing the browser
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
		log.info("Browser closed Successfully");

	}
}
