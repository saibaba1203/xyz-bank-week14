package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement selectCurrency;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;


    public void selectCustomerName(String name) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(customerName, name);
        CustomListeners.test.log(Status.PASS,"Click on logout ");
    }

    public void selectCurrency(String currency){
        selectByVisibleTextFromDropDown(selectCurrency, currency);
        CustomListeners.test.log(Status.PASS,"Select currency: " + currency);
    }

    public void clickOnProcessButton(){
        clickOnElement(processBtn);
        CustomListeners.test.log(Status.PASS,"Click on process button ");
    }


    public void alertTextVerify(String expectedMessage) throws InterruptedException {
        //Reporter.log("Verify Alert Message" + expectedMessage + Message.toString() + "<br>");
        Thread.sleep(2000);
        String Message = getTextFromAlert();
        verifyMessage(expectedMessage, Message, "Error, Message not displayed as expected");
    }
}
