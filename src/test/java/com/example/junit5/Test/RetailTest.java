package com.example.junit5.Test;

import com.example.junit5.Pages.Retail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RetailTest {
/*
 * Печатает куки ритейла до и после переоткрытия браузера
 *  */
    @Test
    public void PrintCookiesForReOpeningPage(){
        String orderID = "4a5e155d-b446-4daa-8c98-a82eebceb07d";
        open(Retail.url + orderID);
        sleep(2000);
        Set<Cookie> cookies = getWebDriver().manage().getCookies();
        //String localStorageContent = executeJavaScript("return JSON.stringify(localStorage);");
        Cookie retail_acc_token = null;
        // поиск retail_access_token
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("retail_access_token"))
                retail_acc_token = cookie;

            /*
            // Cookie print
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Secure: " + cookie.isSecure());
            System.out.println("HttpOnly: " + cookie.isHttpOnly());
            System.out.println("-----------");
            */
        }

        //Assertions.assertTrue(cookies.contains(), "retail_access_token cookie is missing");
    //    System.out.println("Содержимое Local Storage: " + localStorageContent);


        sleep(5000);
        closeWebDriver();
        // Reopen
        open("https://dev.smarta.lc/retail?orderSnapshotId=" + orderID);
        sleep(2000);
        Set<Cookie> newCookies;
        newCookies = getWebDriver().manage().getCookies();
        // retail_access_token после закрытия WebDriver'а
        for (Cookie cookie : newCookies) {
            if (cookie.getName().equals("retail_access_token"))
                Assertions.assertEquals(retail_acc_token, cookie);

//            System.out.println("Name: " + cookie.getName());
//            System.out.println("Value: " + cookie.getValue());
//            System.out.println("Domain: " + cookie.getDomain());
//            System.out.println("Path: " + cookie.getPath());
//            System.out.println("Expiry: " + cookie.getExpiry());
//            System.out.println("Secure: " + cookie.isSecure());
//            System.out.println("HttpOnly: " + cookie.isHttpOnly());
//            System.out.println("-----------");
        }
       // localStorageContent = executeJavaScript("return JSON.stringify(localStorage);");
      //  System.out.println("Содержимое Local Storage: " + localStorageContent);
        sleep(10000);
    }

}
