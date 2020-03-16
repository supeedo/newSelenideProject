/*
Задание 1.3
1.	Запустить Chrome
2.	Открыть яндекс маркет
3.	Перейти в раздел мобильные телефоны
4.	Установить фильтр по производителю Apple
5.	Убедиться, что в полученной выборке телефоны только производителя Apple. Проверить все страницы. Скрипт должен просматривать все доступные страницы. Считаем что страниц может быть от одной до 10.
 */

package ru.market.test;

import org.junit.Test;

public class MarketTest {

    @Test
    public void marketTest() {
        PageFactoryMarket pageFactoryMarket = new PageFactoryMarket("https://market.yandex.ru/");
        pageFactoryMarket.openBrowser();
        pageFactoryMarket.applyFilter();
        pageFactoryMarket.showAllClicker();
        pageFactoryMarket.checkManufacture();
    }
}
