package ru.open.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PageObjectGoogle {
    private String siteLink;
    private String searchWord;
    private String linkText;
    private String searchField;
    private String searchBar;
    private String linkXpatch;

    // инициализируем поля в конструкторе
    public PageObjectGoogle( String searchWord, String linkText ) {
        this.searchWord = searchWord;
        this.linkText = linkText;
        this.siteLink = "http://google.com";
        this.searchField = "//input[@class='gLFyf gsfi']"; //  //*[@id=\"text\"]
        this.searchBar = ".gNO89b";
                //"(//input[@name='btnK'])[2]"; // (//input[@name='btnK'])[2]
        this.linkXpatch = "//cite[contains(@class,'iUh30')]"; // //cite[contains(@class,'iUh30')]
    }

    //  открывает браезер с переходом по ссылке
    public void openBrowser() {
        open(siteLink);
    }

    // вставляем в поисковое поле, слово  с кликом по кнопке поиска
    public void findAllLinks() {
        $(By.xpath(searchField)).setValue(searchWord);
        $(By.cssSelector(searchBar)).click();
    }

    // собираем всю выдачу с проверкой наличия нужной ссылки, далее переходим по ссылке
    public void collectAllLinks () {
        ElementsCollection elementsCollection = $$(By.xpath(linkXpatch));
        elementsCollection.findBy(Condition.text(linkText)).click();
    }
}
