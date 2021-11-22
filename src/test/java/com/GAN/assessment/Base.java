package com.GAN.assessment;

import com.GAN.assessment.core.BrowsersEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setUpDriverConnection() {
        String browser = System.getProperty("browser");

        browser = browser != null ? browser : String.valueOf(BrowsersEnum.CHROME);
        String a = "";
        WebDriver driver;
        switch (browser) {
            case "CHROME":
                driver = chromeDriverConnection();
                break;
            case "FIREFOX":
                driver = firefoxDriverConnection();
                break;
            default:
                driver = chromeDriverConnection();
                break;
        }
        return driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver firefoxDriverConnection() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/firefoxdriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void visit(String url) {
        try {
            driver.get(url);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(WebElement element, String inputText) {
        element.sendKeys(inputText);
    }

    public void type(By locator, String inputText) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void selectDropDownElement(By locator, String visibleText) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }
}


