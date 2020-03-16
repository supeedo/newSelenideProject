package ru.yandex.test;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PageObjectYandex {
    private String siteLink;
    private String searchWord;
    private String linkText;
    private String searchField;
    private String linkCssSelector;

    public PageObjectYandex(String searchWord, String linkText) {
        this.searchWord = searchWord;
        this.linkText = linkText;
        this.siteLink = "http://yandex.ru";
        this.searchField = "//*[@id=\"text\"]"; // xPatch for yandex //*[@id=\"text\"]
        this.linkCssSelector = ".organic__url-text"; // .organic__url-text
    }

    public void openBrowser( ) {
        open(siteLink);
    }

    public void findAllLinks() {
        $(By.xpath(searchField)).setValue(searchWord).pressEnter();
    }

    public void searchLink() {
        ElementsCollection resultLinks = $$(linkCssSelector);
        resultLinks.findBy(text(linkText));
    }
}
