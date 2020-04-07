package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	private static Logger log = LogManager.getLogger(base.class.getName());

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		// Using the properties from the properties file to open Browser
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties\\");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		log.info(browserName + "browser opened successfully");

		if (browserName.equals("Chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			ChromeOptions Options = new ChromeOptions();
			Options.addArguments("--headless");
			driver = new ChromeDriver(Options);
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "drivers\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

		else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		// Loading properties and opening the URL provided
		prop.load(fis);
		String Url = prop.getProperty("url");
		driver.get(Url);
		log.info(" Successfully navigated to " + Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}