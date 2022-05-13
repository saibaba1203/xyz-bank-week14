package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginBtn;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginBtn;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;


    public void clickOnBankManagerLogin() {
        clickOnElement(bankManagerLoginBtn);
        CustomListeners.test.log(Status.PASS,"Click on bank manager login tab ");
    }

    public void clickOnCustomerLoginButton(){
        clickOnElement(customerLoginBtn);
        CustomListeners.test.log(Status.PASS,"Click on customer login button ");
    }

    public void clickOnHomeButton(){
        clickOnElement(homeButton);
        CustomListeners.test.log(Status.PASS,"Click on home button ");
    }



}
