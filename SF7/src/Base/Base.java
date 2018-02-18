package Base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import Pages.Page;
import Utils.LocalDriverManager;
import Utils.LogInit;

public class Base {
	public WebDriver driver;
	public Page page;
	public LogInit logs;
	public Logger log;
	
	
	@BeforeSuite
	public void initDriver(){
		logs = new LogInit();
		log = logs.initLogs();
		
		log.info("Get driver instance with System set properties in Base");
		this.driver  =  LocalDriverManager.getDriver();
		log.info("Pass driver to page's construcer");
		page = new Page(this.driver);
	}

	
	
	@AfterSuite
	void quitDriver() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
