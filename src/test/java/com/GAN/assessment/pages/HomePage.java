package com.GAN.assessment.pages;

import com.GAN.assessment.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends Base {

    By joinNowButton = By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/a[2]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visitHomePage(){
        visit("https://moneygaming.qa.gameaccount.com/");
    }

    public void goToSignUpPage(){
        click(joinNowButton);
    }

    public boolean joinNowButtonExists(){
        return isDisplayed(joinNowButton);
    }
}
