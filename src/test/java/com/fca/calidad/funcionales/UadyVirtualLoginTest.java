package com.fca.calidad.funcionales;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UadyVirtualLoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\adriz\\Desktop\\Chromedriver\\chromedriver.exe"); 
	    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUadyVirtual() throws Exception {
    driver.get("https://www.google.com/search?q=uady+virtual&oq=uady+virtual&aqs=chrome.0.69i59j46j0l4j46l2.3570j0j8&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/a/h3")).click();
    driver.findElement(By.xpath("//nav[@id='essentialnavbar']/div/div/div/div/div/div/ul/li/a/em")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("A11004405");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Diciembre09");
    driver.findElement(By.id("loginbtn")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*ADRIANA IVETTE VIANA VIVANCO[\\s\\S]*$"));
  }
  @Test
  public void testUadyVirtualFail() throws Exception {
    driver.get("https://www.google.com/search?q=uady+virtual&oq=uady+virtual&aqs=chrome.0.69i59j0l6j69i60.2574j0j8&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/a/h3")).click();
    driver.findElement(By.xpath("//nav[@id='essentialnavbar']/div/div/div/div/div/div/ul/li/a/em")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("a11004405");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("hola123");
    driver.findElement(By.id("loginbtn")).click();
    WebElement texto = driver.findElement(By.id("loginerrormessage"));
    String resultadoEsperado = "Datos erróneos. Por favor, inténtelo otra vez.";
    String resultadoEjecucion = texto.getText();
    assertEquals(resultadoEsperado,resultadoEjecucion);
  }


  @After
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

