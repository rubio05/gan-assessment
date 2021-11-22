package com.GAN.assessment.tests;

import com.GAN.assessment.pages.SignUpPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SignUpTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() throws Exception{
        signUpPage = new SignUpPage(driver);
        driver = signUpPage.setUpDriverConnection();
        signUpPage.visitSignUpPage();
    }

    @Test
    public void validateDOBRequired() {
        signUpPage.selectTitle("Mr");
        signUpPage.fillFirstName("Rene");
        signUpPage.fillSurname("Rubio");
        signUpPage.clickAcceptTerms();
        signUpPage.clickOnSubmit();
        assertEquals(true, signUpPage.DOBErrorIsDisplayed());
        assertEquals("This field is required", signUpPage.getDOBValidationErrorText());
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
