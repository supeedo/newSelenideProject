package ru.market.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PageFactoryMarket {
    private String siteLink;

    private SelenideElement electronic = $(By.cssSelector("._3Lwc_UVFq4")); // ._3Lwc_UVFq4
    private SelenideElement mobilePhone = $(By.cssSelector("._2x2zBaVN-3")); // ._2x2zBaVN-3
    private SelenideElement appleManufactured = $(By.cssSelector(".LhMupC0dLR")); // .LhMupC0dLR
    private SelenideElement showMore = $(By.linkText("Показать еще"));
    private ElementsCollection elementManufactured = $$(By.cssSelector(".n-snippet-cell2__brand-name"));

    public PageFactoryMarket( String siteLink ) {
        this.siteLink = siteLink;
    }

    public void openBrowser() {
        open(siteLink);
    }

    public void applyFilter() {
        electronic.shouldBe(enabled).click();
        mobilePhone.shouldBe(enabled).click();
        appleManufactured.shouldBe(enabled).click();
    }

    public void showAllClicker() {
        while (showMore.isDisplayed()) {
            showMore.shouldBe(enabled).click();
        }
        // i know what's is it bad practics...but it work...
        Selenide.sleep(5000);
    }

    public void checkManufacture() {
        boolean flag = false;
        if (elementManufactured.size() != 0) {
            flag = true;
            for (SelenideElement se : elementManufactured) {
                if (!(se.text().equals("APPLE"))) {
                    flag = false;
                }
            }
        }
        Assert.assertTrue(flag);
    }
}