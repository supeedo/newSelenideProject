package ru.open.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;

public class PageObjectOpen {
   private ElementsCollection money;
    private SelenideElement dollarPurchanse;
    private SelenideElement dollarSale;
    private SelenideElement euroPurchanse;
    private SelenideElement euroSale;


    //инициализация полей класса
    public PageObjectOpen(  ) {
        this.dollarPurchanse = $(By.xpath("(//span[@class='main-page-exchange__rate'])[1]"));
        // (//span[@class='main-page-exchange__rate'])[1]

        this.dollarSale = $(By.xpath("(//span[@class='main-page-exchange__rate'])[2]"));
        // (//span[@class='main-page-exchange__rate'])[2]

        this.euroPurchanse = $(By.xpath("(//span[@class='main-page-exchange__rate'])[3]"));
        // (//span[@class='main-page-exchange__rate'])[3]

        this.euroSale = $(By.xpath("(//span[@class='main-page-exchange__rate'])[4]"));
        // (//span[@class='main-page-exchange__rate'])[4]
    }

    // сравнение цены покупки с ценой продажи
    public boolean comparisonValue() {
        if (getDollarPurchanse() < getDollarSale()
                && getEuroPurchanse() < getEuroSale()) {
            return true;
        }
        return false;
    }

    // ниже геттеры для валюты с переводом в Double
    public double getDollarPurchanse() {
        return Double.parseDouble(dollarPurchanse.getText().replace(',','.'));
    }

    public double getDollarSale() {
        return Double.parseDouble(dollarSale.getText().replace(',','.'));
    }

    public double getEuroPurchanse() {
        return Double.parseDouble(dollarPurchanse.getText().replace(',','.'));
    }

    public double getEuroSale() {
        return Double.parseDouble(dollarSale.getText().replace(',','.'));
    }
}
