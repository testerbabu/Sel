
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test11 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Selenium Java Jar Files\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    baseUrl = "https://www.bing.com/";
  }

  @Test
  public void test11() throws Exception {
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    driver.get(baseUrl + "/?scope=web&mkt=en-IN&FORM=INCOH1&pc=IC04");
    driver.findElement(By.id("sb_form_q")).click();
    driver.findElement(By.id("sb_form_q")).clear();
    driver.findElement(By.id("sb_form_q")).sendKeys("hi");
    driver.findElement(By.id("sb_form_go")).click();
    driver.findElement(By.xpath("//ol[@id='b_results']/li[2]/h2/a/strong[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
