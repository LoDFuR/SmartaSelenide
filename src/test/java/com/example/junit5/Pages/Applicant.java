package com.example.junit5.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Applicant {
    public static String main = "https://dev.smarta.lc/applicant";

    public static SelenideElement Step = $(By.xpath("*//span[contains(text(),'Шаг')]"));
    public static SelenideElement DeclineOrderButton = $(By.xpath("*//span[contains(text(),'Аннулировать заявку')]"));
    public static SelenideElement ApproveButton = $(By.xpath("*//button[contains(text(),'Да')]"));
    public static SelenideElement StartCyberityButton = $(By.xpath("*//button[contains(text(),'Начать')]"));
    public static SelenideElement RedirectionQrButton = $(By.xpath("*//span[contains(text(),'QR-код')]"));
    public static SelenideElement RedirectionSMSButton = $(By.xpath("*//span[contains(text(),'СМС с короткой ссылкой')]"));
    public static SelenideElement PasportFAQ = $(By.xpath("*//span[contains(text(),'Для чего это нужно')]"));
    public static SelenideElement PersonalityPoliticsLink = $(By.xpath("*//a[contains(text(),'обработкой персональных данных')]"));
    public static SelenideElement DigitalApproveLink = $(By.xpath("*//a[contains(text(),'простой электронной подписи')]"));
    public static SelenideElement PhoneNumberInputForm = $(By.xpath("*//input"));
    public static SelenideElement SubmitPhoneNumberInputForm = $(By.xpath( "*//button[@type=\"submit\"]"));
    public static SelenideElement AuthorizationPin1 = $(By.xpath("(*//input[@type=\"password\"])[1]"));
    public static SelenideElement AuthorizationPin2 = $(By.xpath("(*//input[@type=\"password\"])[2]"));
    public static SelenideElement AuthorizationPin3 = $(By.xpath("(*//input[@type=\"password\"])[3]"));
    public static SelenideElement AuthorizationPin4 = $(By.xpath("(*//input[@type=\"password\"])[4]"));

}
