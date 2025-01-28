package com.example.junit5.Pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.$;

public class Retail {

    public static String url = "https://dev.smarta.lc/retail?orderSnapshotId=";
    public static SelenideElement ButtonStart = $(By.xpath("*//button[contains(text(), 'Начать')]"));
    public static SelenideElement InputNumber = $(By.xpath("*//input[@name='phoneNumber']"));
    public static SelenideElement ButtonGetSMS = $(By.xpath("*//button[contains(text(), 'Получить смс-код')]"));

    //public static SelenideElement ElementName = $(By.xpath("XPATH"));
}
