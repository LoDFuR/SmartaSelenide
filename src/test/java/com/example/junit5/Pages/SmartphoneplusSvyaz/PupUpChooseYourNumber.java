package com.example.junit5.Pages.SmartphoneplusSvyaz;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PupUpChooseYourNumber {
    public static ElementsCollection Numbers = $$(By.xpath("*//span[contains(text(), 'Выбрать')]"));
    public static SelenideElement ButtonContinue = $(By.xpath("*//button[contains(text(), 'Подтвердить и продолжить')]"));
    public static SelenideElement ButtonToZayavka = $(By.xpath("*//button[contains(text(), 'Перейти к заявке')]"));


}
