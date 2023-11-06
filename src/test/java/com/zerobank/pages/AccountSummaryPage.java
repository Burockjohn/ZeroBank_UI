package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickLink(String option) {
//        for (WebElement link : links) {
//            if (link.getText().contains(option)) {
//                link.click();
//            }
//        }
        Driver.getDriver().findElement(By.xpath("//td/a[.='" + option + "']")).click();
    }


}
