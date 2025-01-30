package com.example.junit5.Test;

import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.IsDisplayed;
import com.example.junit5.Pages.SmartphoneplusSvyaz.PupUpChooseYourNumber;
import com.example.junit5.Pages.SmartphoneplusSvyaz.SmartphonePlusSvyaz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartphonePlusSvyazTest {
    @Test
    public void OpenSite(){
        open(SmartphonePlusSvyaz.main);
        getWebDriver().manage().window().maximize();
        sleep(2000);
    }


    @Test
    public void ScrollToAccessoriesByTopButton(){
        open(SmartphonePlusSvyaz.main);
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click();
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible, Duration.ofSeconds(3));
        sleep(3000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
    }

    @Test
    public void openWhichNumberPopUp(){
        open(SmartphonePlusSvyaz.main);
        getWebDriver().manage().window().maximize();
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click();
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible, Duration.ofSeconds(3));
        sleep(5000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
        int i = 0;
        SelenideElement clickingButton;
        while(!SmartphonePlusSvyaz.ButtonAccessories.isEnabled()){
            clickingButton = $$(By.xpath("(*//button[contains(text(), 'Добавить')])")).get(i);
            clickingButton.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
            i++;
            sleep(500);
        }
        SmartphonePlusSvyaz.ButtonAccessories.click(ClickOptions.withTimeout(Duration.ofSeconds(8)));
        //(*//button[contains(text(), 'Добавить')])[2])
        sleep(4000);

    }

    @Test
    public void ClickingPhoneNumber(){
        open(SmartphonePlusSvyaz.main);
        getWebDriver().manage().window().maximize();
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click(ClickOptions.withTimeout(Duration.ofSeconds(3)));
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible, Duration.ofSeconds(3));
        sleep(2000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
        int i = 0;
        SelenideElement clickingButton;
        SelenideElement clickingNumber;
        String PhoneNumber = "";
        // getting accessories
        while(!SmartphonePlusSvyaz.ButtonAccessories.isEnabled()){
            clickingButton = SmartphonePlusSvyaz.Accessories.get(i);
            clickingButton.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
            // Надпись Добавлено изменяется после клика
            sleep(500);
        }
        SmartphonePlusSvyaz.ButtonAccessories.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        sleep(5000);
        // offer
        ElementsCollection numb = PupUpChooseYourNumber.NumbersButtons;
        numb.get(1).shouldBe(Condition.visible, Duration.ofSeconds(30));
        // Проверяем 1-ый, а кликаем 2 по порядку номер
        numb.get(2).click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        clickingNumber = PupUpChooseYourNumber.NumbersStrings.get(2);
        // Записываем в переменную номер
        PhoneNumber = clickingNumber.getText();
        assertTrue(PupUpChooseYourNumber.ButtonContinue.is(Condition.enabled, Duration.ofSeconds(5)));
//        sleep(5000);
        PupUpChooseYourNumber.ButtonContinue.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
//        assertTrue(PupUpChooseYourNumber.ButtonToZayavka.isDisplayed());
        PupUpChooseYourNumber.ButtonToZayavka.shouldBe(Condition.enabled, Duration.ofSeconds(7));
        PupUpChooseYourNumber.ButtonToZayavka.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        sleep(2000);
        System.out.println("MyGeneratedLink:");
        System.out.println(getWebDriver().getCurrentUrl());
        System.out.println("Choosed Phone Number: " + PhoneNumber);
    }




}
