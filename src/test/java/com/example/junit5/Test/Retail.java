package com.example.junit5.Test;

import com.example.junit5.Pages.Applicant;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Retail {

    @Test
    public void OpenRetailPage(){
        String orderID = "4a5e155d-b446-4daa-8c98-a82eebceb07d";
        open("https://dev.smarta.lc/retail?orderSnapshotId=" + orderID);
        sleep(2000);
        Set<Cookie> cookies = getWebDriver().manage().getCookies();
        String localStorageContent = executeJavaScript("return JSON.stringify(localStorage);");
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Secure: " + cookie.isSecure());
            System.out.println("HttpOnly: " + cookie.isHttpOnly());
            System.out.println("-----------");
        }
    //    System.out.println("Содержимое Local Storage: " + localStorageContent);
        sleep(5000);
        closeWebDriver();
        // Reopen
        open("https://dev.smarta.lc/retail?orderSnapshotId=" + orderID);
        sleep(2000);
        cookies = getWebDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Secure: " + cookie.isSecure());
            System.out.println("HttpOnly: " + cookie.isHttpOnly());
            System.out.println("-----------");
        }
        localStorageContent = executeJavaScript("return JSON.stringify(localStorage);");
      //  System.out.println("Содержимое Local Storage: " + localStorageContent);
        sleep(10000);
    }
}
