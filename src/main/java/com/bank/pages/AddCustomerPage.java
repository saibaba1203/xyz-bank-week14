package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement getFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement getLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement getPostCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement getAddCustomerBtn;

    public void inputFirstName(String fName) {
        sendTextToElement(getFirstName, fName);
        CustomListeners.test.log(Status.PASS,"Enter first name: " + fName);
    }

    public void inputLastName(String lName) {
        sendTextToElement(getLastName, lName);
        CustomListeners.test.log(Status.PASS,"Enter last name: " + lName);
    }

    public void inputPostcode(String postcode) {
        sendTextToElement(getPostCode, postcode);
        CustomListeners.test.log(Status.PASS,"Enter postcode: " + postcode);
    }

    public void clickOnAddCustomerButton() {
        clickOnElement(getAddCustomerBtn);
        CustomListeners.test.log(Status.PASS,"Click on logout ");
    }

    public void acceptPopUpMessage(){
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Accept alert ");
    }

    public void alertTextVerify(String expectedMessage) throws InterruptedException {
        //Reporter.log("Alert text verify" + expectedMessage + message.toString() + "<br>");
        Thread.sleep(2000);
        String message = getTextFromAlert();
        verifyMessage(expectedMessage, message, "Error, Message not displayed as expected");
        CustomListeners.test.log(Status.PASS,"Verify alert message ");
    }
}
