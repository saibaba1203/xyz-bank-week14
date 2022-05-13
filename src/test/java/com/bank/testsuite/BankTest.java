package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        openAccountPage = new OpenAccountPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLogin();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.inputFirstName("Sanket");
        addCustomerPage.inputLastName("Desai");
        addCustomerPage.inputPostcode("364001");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.acceptPopUpMessage();

    }

    @Test(priority = 1, groups = {"sanity","smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        bankManagerShouldAddCustomerSuccessfully();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.selectCustomerName("Sanket Desai");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        addCustomerPage.acceptPopUpMessage();
        homePage.clickOnHomeButton();
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        bankManagerShouldOpenAccountSuccessfully();
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerName("Sanket Desai");
        customerLoginPage.clickOnLoginButton();
        accountPage.verifyLogoutTabVisible();
        accountPage.clickOnLogoutButton();
        accountPage.verifyYourNameTextVisible("Your Name");
    }

    @Test(priority = 3, groups = {"smoke","regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        customerShouldLoginAndLogoutSuceessfully();
        customersPage.selectCustomerName("Sanket Desai");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.inputDepositAmount("100");
        accountPage.clickOnSubmitButton();
        accountPage.verifyDepositSuccessfulMessage("Deposit Successful");
    }

    @Test(priority = 4, groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        customerShouldDepositMoneySuccessfully();
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerName("Sanket Desai");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.inputWithdrawAmount("50");
        accountPage.clickOnWithdrawButton();
        accountPage.verifyTransactionSuccessfulMessage("Transaction Successful");

    }
}