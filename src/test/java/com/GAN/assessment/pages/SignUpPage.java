package com.GAN.assessment.pages;

import com.GAN.assessment.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends Base {

    By firstNameTextBox = By.id("forename");
    By surnameTextBox = By.xpath("//*[@id=\"signupForm\"]/fieldset[1]/input[2]");
    By termsAndConditionsCheckbox = By.id("checkbox");
    By joinNowFormSubmit = By.id("form");
    By titleSelect = By.id("title");
    By validationErrorDOB = By.xpath("//*[@id=\"signupForm\"]/fieldset[1]/label[5]");


    public SignUpPage(WebDriver driver){
        super(driver);
    }

    public void visitSignUpPage() {
        visit("https://moneygaming.qa.gameaccount.com/sign-up.shtml");
    }

    public void selectTitle(String title){
        selectDropDownElement(titleSelect, title);
    }

    public void fillFirstName(String firstName){
        type(firstNameTextBox, firstName);
    }

    public void fillSurname(String surname){
        type(surnameTextBox, surname);
    }

    public void clickAcceptTerms(){
        click(termsAndConditionsCheckbox);
    }

    public void clickOnSubmit(){
        click(joinNowFormSubmit);
    }

    public boolean DOBErrorIsDisplayed(){
        return isDisplayed(validationErrorDOB);
    }

    public String getDOBValidationErrorText(){
        return getText(validationErrorDOB);
    }
}
