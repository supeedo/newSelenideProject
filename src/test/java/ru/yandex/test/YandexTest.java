/*
Задание 1.1
Задача:
1.	запустить Chrome
2.	Открыть яндекс
3.	Ввести «Гладиолус». Нажать поиск
4.	Убедится что в полученной выборке на первой странице есть ссылка на википедию

 */
package ru.yandex.test;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YandexTest {


    // Данный тест не использует PageObject
    @Test
    public void flowerTest() {
        open("http://yandex.ru");
        $(By.xpath("//*[@id=\"text\"]")).setValue("Гладиолус").pressEnter();
        ElementsCollection resultLinks = $$(".organic__url-text");
        System.out.println(resultLinks.size());
        resultLinks.findBy(text("Шпажник — Википедия"));
    }

    // Данный тест реализован через PageObject
     @Test
    public void flowerYandexTest() {
         PageObjectYandex po = new PageObjectYandex("Гладиолус", "Шпажник — Википедия");
         po.openBrowser();
         po.findAllLinks();
         po.searchLink();
     }
}
