package com.example.junit5.Test;

import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.IsDisplayed;
import com.example.junit5.Pages.SmartphoneplusSvyaz.PupUpChooseYourNumber;
import com.example.junit5.Pages.SmartphoneplusSvyaz.SmartphonePlusSvyaz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartphonePlusSvyazTest {
            public static void MaximizeWindow(){
        open(SmartphonePlusSvyaz.main);
        getWebDriver().manage().window().maximize();
    }
    @Test
    public void OpenSiteTest(){
        MaximizeWindow();
        sleep(2000);
    }


    @Test
    public void ScrollToAccessoriesByTopButtonTest(){
        MaximizeWindow();
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click(ClickOptions.withTimeout(Duration.ofSeconds(4)));
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible, Duration.ofSeconds(3));
        //sleep(3000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed(), "Scrolling to the Accessories Failed");
    }

    @Test
    public void TittleTest(){
        MaximizeWindow();
        String ExpectedTitle = "Samsung Galaxy A06 + связь на 3 года: всё вместе за 920 ₽ в месяц";
//        getWebDriver().manage().window().maximize();
        SmartphonePlusSvyaz.Title.shouldBe(Condition.visible, Duration.ofSeconds(4));
//        sleep(1000);
        Assertions.assertEquals(ExpectedTitle,
                SmartphonePlusSvyaz.Title.getText(),
                "Title is different!");
    }

    @Test
    public void TitleBlockContainsElementsTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.Button.shouldBe(Condition.visible, Duration.ofSeconds(4));
        assertTrue(SmartphonePlusSvyaz.Button.exists(),
                "Button \"Оформить\" Not found");
        SmartphonePlusSvyaz.Img.shouldBe(Condition.visible, Duration.ofSeconds(3));
        assertTrue(SmartphonePlusSvyaz.Img.exists(),
                "Picture Samsung A06 Not found");
        assertTrue(SmartphonePlusSvyaz.MayPortaitedText.is(Condition.visible,
                Duration.ofSeconds(3)),
                "\"Можно перейти\" Element is invisible");
        assertTrue(SmartphonePlusSvyaz.WithYourNumberText.is(Condition.visible,
                Duration.ofSeconds(3)),
                "\"со своим номером\" Element is invisible");
    }
    @Test
    public void SubTitleTest(){
        MaximizeWindow();
        String ExpectedSubTitle = "Отличный современный смартфон с двумя SIM-картами и мобильная связь с 35 Гб интернета в месяц!";
        SmartphonePlusSvyaz.Subtitle.shouldBe(Condition.visible, Duration.ofSeconds(5));
        assertEquals(ExpectedSubTitle,
                SmartphonePlusSvyaz.Subtitle.getText(),
                "Subtitle is different!");
        assertTrue(SmartphonePlusSvyaz.Subtitle.isDisplayed(),
                "Subtitle is not displayed");
    }
    @Test
    public void MayPortaitedTextTest() {
        MaximizeWindow();
        String ExpectedMayPortaitedText = "Можно перейти",
               ExpectedWithYourNumberText = "со своим номером!";
        sleep(500);
        assertEquals(ExpectedMayPortaitedText,
                SmartphonePlusSvyaz.MayPortaitedText.getText(),
                "May be portaited text is different");
        assertEquals(ExpectedWithYourNumberText,
                SmartphonePlusSvyaz.WithYourNumberText.getText(),
                "With your phone Number text is different");
    }
    @Test
    public void LegendarySeriesDisplayingTest(){
        MaximizeWindow();
        sleep(500);
        assertTrue(SmartphonePlusSvyaz.TitleLegendary.exists(),
                "Tittle Legendary doesn't exist");
        assertTrue(SmartphonePlusSvyaz.SubtitleLegendary.exists(),
                "Subtitle Legendary doesn't exist");
        assertTrue(SmartphonePlusSvyaz.ImgLegendary.exists(),
                "Img Legendary doesn't exist");
        SmartphonePlusSvyaz.TitleLegendary.scrollTo();
        sleep(500);
        assertTrue(SmartphonePlusSvyaz.TitleLegendary.isDisplayed(),
                "Title isn't Displayed");
        assertTrue(SmartphonePlusSvyaz.SubtitleLegendary.isDisplayed(),
                "Subtitle Legendary isn't Displayed");
        assertTrue(SmartphonePlusSvyaz.ImgLegendary.isDisplayed(),
                "ImgLegendary isn't Displayed");
            }
    @Test
    public void LegendarySeriesTitleTest(){
        MaximizeWindow();
        String ExpectedTitle = "Легендарная серия Samsung Galaxy A06";

        assertEquals(ExpectedTitle,
                SmartphonePlusSvyaz.TitleLegendary.getText(),
                "Tittle is different!");
    }
    @Test
    public void LegendarySeriesSubTitleTest(){
        MaximizeWindow();
        String ExpectedSubTitle = "Расширьте свои возможности на большом экране Galaxy A06 диагональю 6,7 дюйма. Просматривать контент удобно благодаря плавной прокрутке с частотой 60 Гц и дисплею с U-вырезом и TFT-матрицей.";
        SmartphonePlusSvyaz.TitleLegendary.scrollTo();
        assertTrue(SmartphonePlusSvyaz.SubtitleLegendary.isDisplayed(),
                "Subtitle is not displayed!");
        assertEquals(ExpectedSubTitle,
                SmartphonePlusSvyaz.SubtitleLegendary.getText(),
                "Subtitle is different!");
    }




    @Test
    public void openWhichNumberPopUpTest(){
        MaximizeWindow();
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click();
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible,
                Duration.ofSeconds(3));
        sleep(5000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed(),
                "Accessories aren't displayed");
        int i = 0;
        SelenideElement clickingButton;
        while(!SmartphonePlusSvyaz.ButtonAccessories.isEnabled()){
            clickingButton = $$(By.xpath("(*//button[contains(text(), 'Добавить')])")).get(i);
            clickingButton.click(
                    ClickOptions.withTimeout(Duration.ofSeconds(5)));
            sleep(500);
        }
        SmartphonePlusSvyaz.ButtonAccessories.click(
                ClickOptions.withTimeout(Duration.ofSeconds(8)));
    }


    @Test
    public void ApplicationSmartphonePlusSvyaz(){
        open(SmartphonePlusSvyaz.main);
        getWebDriver().manage().window().maximize();
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click(
                ClickOptions.withTimeout(Duration.ofSeconds(3)));
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible,
                Duration.ofSeconds(3));
        sleep(2000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
        int i = 0;
        SelenideElement clickingButton;
        SelenideElement clickingNumber;
        String PhoneNumber = "";
        // getting accessories
        while(!SmartphonePlusSvyaz.ButtonAccessories.isEnabled()){
            clickingButton = SmartphonePlusSvyaz.AccessoriesButtonsAdd.get(i);
            clickingButton.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
            // Надпись Добавлено изменяется после клика
            sleep(500);
        }
        SmartphonePlusSvyaz.ButtonAccessories.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        sleep(5000);
        // offer
        ElementsCollection numb = PupUpChooseYourNumber.NumbersButtons;
        numb.get(1).shouldBe(Condition.visible, Duration.ofSeconds(30));
        numb.get(2).shouldBe(Condition.visible, Duration.ofSeconds(30));
        // Проверяем 1-ый, 2-ой номера, кликаем 2 номер в списке
        numb.get(2).click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
        clickingNumber = PupUpChooseYourNumber.NumbersStrings.get(2);
        // Записываем в переменную номер
        PhoneNumber = clickingNumber.getText();
        assertTrue(PupUpChooseYourNumber.ButtonContinue.is(Condition.enabled,
                Duration.ofSeconds(5)));
        PupUpChooseYourNumber.ButtonContinue.click(
                ClickOptions.withTimeout(Duration.ofSeconds(5)));
        PupUpChooseYourNumber.ButtonToZayavka.shouldBe(Condition.enabled,
                Duration.ofSeconds(7));
        PupUpChooseYourNumber.ButtonToZayavka.click(
                ClickOptions.withTimeout(Duration.ofSeconds(5)));
        sleep(2000); // Uneccessary sleep
        System.out.println("MyGeneratedLink:");
        System.out.println(getWebDriver().getCurrentUrl()); // Printing generated Link for the application
        System.out.println("Choosed Phone Number: " + PhoneNumber);
    }




}
