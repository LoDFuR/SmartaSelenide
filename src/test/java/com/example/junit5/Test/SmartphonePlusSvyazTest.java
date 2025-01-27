package com.example.junit5.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverRunner;
import com.example.junit5.Pages.SmartphonePlusSvyaz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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
        Assertions.assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click();
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible, Duration.ofSeconds(3));
        sleep(3000);
        Assertions.assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
    }
}
