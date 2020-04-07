package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarOptions {

	public WebDriver driver;

	public CalendarOptions(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

		WebDriverWait Wait = new WebDriverWait(driver, 5);
		Wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("//div[@class='modal-dialog depart_modal']//div[@class='modal-content']"))));

	}

	// Clicking on Departure date in calendar
	@FindBy(xpath = "//input[@id='departCalendar']")
	WebElement DepartCldr;

	public WebElement DepartCldr() {
		return DepartCldr;
	}

	// Select Month (Year is defaulted to current year)
	@FindBy(xpath = "//span[contains(text(),'May')]")
	WebElement Month;

	public WebElement Month() {
		return Month;
	}

	// Selecting current date
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")
	WebElement Day;

	public WebElement Day() {
		return Day;
	}

	// Selecting year for return
	@FindBy(xpath = "//div[@id='nextYr']")
	WebElement NxtYear;

	public WebElement NxtYear() {
		return NxtYear;
	}

	// Selecting month in the following year
	@FindBy(xpath = "//span[contains(text(),'Feb')]")
	WebElement NxtYrMonth;

	public WebElement NxtYrMonth() {
		return NxtYrMonth;
	}

	// Selecting date in the following year
	@FindBy(xpath = "//tr[3]//td[3]")
	WebElement NxtYrDay;

	public WebElement NxtYrDay() {
		return NxtYrDay;
	}

}
