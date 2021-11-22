package com.GAN.assessment.tests;

import com.GAN.assessment.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

public class HomeTest {

    private WebDriver driver;
    private HomePage homePage;


    @Before
    public void setUp() throws Exception {
        String a = System.getProperty("browser");
        homePage = new HomePage(driver);
        driver = homePage.setUpDriverConnection();
        homePage.visitHomePage();
        homePage.goToSignUpPage();
    }

    @Test
    public void validateLoginButtonIsPresent() {
        assertEquals(true, homePage.joinNowButtonExists());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
