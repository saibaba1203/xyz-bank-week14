package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;


    public void selectCustomerName(String name){
        selectByVisibleTextFromDropDown(customerName, name);
        CustomListeners.test.log(Status.PASS,"Select customer name from dropdown: " + name);
    }
}
