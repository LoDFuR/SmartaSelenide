package com.example.junit5.Pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.$;

public class Retail {
    //public static SelenideElement ElementName = $(By.xpath("XPATH"));
    public static String url = "https://dev.smarta.lc/retail?orderSnapshotId=";
    public static SelenideElement ButtonStart = $(By.xpath("*//button[contains(text(), 'Начать')]"));

}
