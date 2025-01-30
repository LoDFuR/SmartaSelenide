package com.example.junit5.Test;

import com.codeborne.selenide.Condition;
import com.example.junit5.Pages.Catalog;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CatalogTest {
    /**
     * Плохой тест на скролл страницы: привязан к кол-ву элементов из БД,
     * скроллится определенное количество раз
     * */
    @Test
    public void ScrollingToUndisplayedElement(){
        open(Catalog.main);
        getWebDriver().manage().window().maximize();
        //Catalog.LastLinkOnCatalogPhoneLink.scroll();
        for (int i = 0; i < 7; i++) { // Прокручиваем несколько раз
            executeJavaScript("window.scrollBy(0, window.innerHeight)");
            sleep(2000); // Ждать, пока подгрузятся новые элементы
        }
        Assertions.assertTrue(Catalog.LastLinkOnCatalogPhoneLink.exists());
        Catalog.LastLinkOnCatalogPhoneLink.scrollIntoCenter();
        Assertions.assertTrue(Catalog.LastLinkOnCatalogPhoneLink.is(Condition.visible));
        sleep(1000);
        //AuthChallengeResponse.Response.valueOf("");
    }
}
