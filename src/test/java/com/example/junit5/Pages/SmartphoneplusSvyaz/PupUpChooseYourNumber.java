package com.example.junit5.Pages.SmartphoneplusSvyaz;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PupUpChooseYourNumber {
    public static ElementsCollection NumbersButtons = $$(By.xpath("*//span[contains(text(), 'Выбрать')]"));
    public static SelenideElement ButtonContinue = $(By.xpath("*//button[contains(text(), 'Подтвердить и продолжить')]"));
    public static SelenideElement ButtonToZayavka = $(By.xpath("*//button[contains(text(), 'Перейти к заявке')]"));
    public static ElementsCollection NumbersContainerDiv = $$(By.xpath("(*//div[@class=\"phones-list_phoneBlock__pZuFa\"])"));
    public static ElementsCollection NumbersStrings = $$(By.xpath("*//div/span[contains(text(), '+7')]"));
    public static SelenideElement ButtonGetSMSCode = $(By.xpath("*//button[contains(text(), 'Получить смс-код')]"));
    public static SelenideElement InputNumber = $(By.xpath("*//input[@id = 'codeInputPhone']"));
    public static SelenideElement PortationTitle = $(By.xpath("//h3[contains(text(), 'выбранный тариф')]"));
    public static SelenideElement PortationSubTitle = $(By.xpath("//span[contains(text(), 'Введите номер')]"));


}
