package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {

    public AccountPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//label[contains(text(),'Your Name :']")
    WebElement yourNameText;

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositMessage;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawlTab;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawAmount;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessText;

    public void clickOnLogoutButton(){
        clickOnElement(logoutBtn);
        CustomListeners.test.log(Status.PASS,"Click on logout ");
    }

    public void verifyYourNameTextVisible(String text){
       verifyThatTextIsDisplayed(yourNameText, text);
        CustomListeners.test.log(Status.PASS,"Verify 'Your Name' Text "+text);
    }

    public void clickOnDepositTab(){
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS,"Click on deposit tab ");
    }

    public void inputDepositAmount(String amount){
        sendTextToElement(depositAmount, amount);
        CustomListeners.test.log(Status.PASS,"Enter deposit amount "+ amount);
    }

    public void clickOnSubmitButton(){
        clickOnElement(submitBtn);
        CustomListeners.test.log(Status.PASS,"Click on submit button ");
    }

    public void verifyDepositSuccessfulMessage(String message){
        verifyThatTextIsDisplayed(depositMessage, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Deposit Successfull' message "+message);
    }
    public void clickOnWithdrawlTab(){
        clickOnElement(withdrawlTab);
        CustomListeners.test.log(Status.PASS,"Click on withdrawl button ");
    }
    public void inputWithdrawAmount(String amount){
        sendTextToElement(withdrawAmount, amount);
        CustomListeners.test.log(Status.PASS,"Enter withdraw amount: "+ amount);
    }
    public void clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
        CustomListeners.test.log(Status.PASS,"Click on withdraw button ");
    }
    public void verifyTransactionSuccessfulMessage(String message){
        verifyThatTextIsDisplayed(transactionSuccessText, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Transaction Successfull' message "+ message);
    }

    public void verifyLogoutTabVisible(){
        verifyThatElementIsDisplayed(logoutBtn);
        CustomListeners.test.log(Status.PASS,"Verify logout tab visible ");
    }
}
