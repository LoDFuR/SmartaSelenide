package com.example.junit5.Test;

import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.IsDisplayed;
import com.example.junit5.Pages.SmartphoneplusSvyaz.PupUpChooseYourNumber;
import com.example.junit5.Pages.SmartphoneplusSvyaz.SmartphonePlusSvyaz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrlStartingWith;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

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
        sleep(700);
        assertEquals(ExpectedTitle,
                SmartphonePlusSvyaz.TitleLegendary.getText(),
                "Tittle is different!");
    }
    @Test
    public void LegendarySeriesSubTitleTest(){
        MaximizeWindow();
        String ExpectedSubTitle = "Расширьте свои возможности на большом экране Galaxy A06 диагональю 6,7 дюйма. Просматривать контент удобно благодаря плавной прокрутке с частотой 60 Гц и дисплею с U-вырезом и TFT-матрицей.";
        SmartphonePlusSvyaz.TitleLegendary.scrollTo();
        sleep(700);
        assertTrue(SmartphonePlusSvyaz.SubtitleLegendary.isDisplayed(),
                "Subtitle is not displayed!");
        assertEquals(ExpectedSubTitle,
                SmartphonePlusSvyaz.SubtitleLegendary.getText(),
                "Subtitle is different!");
    }


    //Characteristics

    @Test
    public void CharacteristicTitleTextTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCharacteristic.scrollTo();
        sleep(500);
        String expectedText = "Основные характеристики";
        assertEquals(expectedText,
                SmartphonePlusSvyaz.TitleCharacteristic.getText(),
                "Title Characteristics is different!");
    }

    @Test
    public void CharacteristicsImgMountainTextTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCharacteristic.scrollTo();
        sleep(800);
        String expectedSubTitle = "Безграничный 6,7 экран для больших возможностей";
        assertEquals(expectedSubTitle,
                SmartphonePlusSvyaz.SubtitleCharacteristic1.getText(),
                "Img Display text is different");
    }

    @Test
    public void CharacteristicsImgFestivalTest(){
        String  expectedSubTitle2 = "Основная камера с высоким разрешением 50 МП";
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCharacteristic.scrollTo();
        sleep(800);
        assertEquals(expectedSubTitle2,
                SmartphonePlusSvyaz.SubtitleCharacteristic2.getText(),
                "Camera Img text is different");
    }

    @Test
    public void CharacteristicsImgBatteryTextTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCharacteristic.scrollTo();
        sleep(1000);
        String expectedSubTitle = "Мощный аккумулятор и супербыстрая зарядка";
        assertEquals(expectedSubTitle,
                SmartphonePlusSvyaz.SubtitleCharacteristic3.getText(),
                "Battery camera text is different");
    }

    @Test
    public void CharacteristicsBlockImgTest(){
        MaximizeWindow();
        assertTrue(SmartphonePlusSvyaz.TitleCharacteristic.exists(),
                "Characteristics title doesn't exist");
        SmartphonePlusSvyaz.TitleCharacteristic.scrollTo();
        sleep(800);
        assertTrue(SmartphonePlusSvyaz.TitleCharacteristic.isDisplayed(),
                "Title is not displayed");
        assertTrue(SmartphonePlusSvyaz.ImgCharacteristic1.isDisplayed(),
                "Img is not displayed");
        assertTrue(SmartphonePlusSvyaz.ImgCharacteristic2.isDisplayed(),
                "Img is not displayed");
        assertTrue(SmartphonePlusSvyaz.ImgCharacteristic3.isDisplayed(),
                "Img is not displayed");
    }

    @Test
    public void DesignBlockTitleTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleDesign.scrollTo();
        sleep(900);
        String expectedTitle = "Стильный изящный дизайн. Черный цвет. Две SIM-карты";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.TitleDesign.getText(),
                "Design title text is different");
    }


    @Test
    public void DesignBlockSubTitleTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleDesign.scrollTo();
        sleep(900);
        String expectedSubtitle = "Galaxy A06 получил повышенный уровень комфорта благодаря уменьшенному с 8,8 мм до 8,0 мм корпусу. А классический цвет смартфона подчеркнет вашу индивидуальность. Galaxy A06 доступен в черном цвете.";
        assertEquals(expectedSubtitle,
                SmartphonePlusSvyaz.SubtitleDesign.getText());
    }
    @Test
    public void DesignBlockImgTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleDesign.scrollTo();
        sleep(1000);
        assertTrue(SmartphonePlusSvyaz.ImgDesign1.isDisplayed(),
                "Img of the back of smartphone isn't displayed");
        assertTrue(SmartphonePlusSvyaz.ImgDesign2.isDisplayed(),
                "Img microSD isn't displayed");
    }

   //Camera
    @Test
    public void CameraBlockTitleTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCamera.scrollTo();
        sleep(1000);
        String expectedTitle = "Основная камера с высоким разрешением 50 МП";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.TitleCamera.getText(),
                "Title camera is different");
    }


    @Test
    public void CameraBlockSubTitleTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCamera.scrollTo();
        sleep(1000);
        String expectedTitle = "Откройте для себя возможности камеры Galaxy A06 с разрешением 50 МП." +
                " Создавайте фотографии потрясающего качества с помощью камеры с датчиком глубины 2 МП — " +
                "она придаст изображению дополнительный объем. А фронтальная камера 8 МП обеспечит безупречную" +
                " четкость ваших снимков.";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.SubtitleCamera.getText(),
                "Subtitle is different");
    }

    @Test
    public void CameraBlockImgTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleCamera.scrollTo();
        sleep(1000);
        assertTrue(SmartphonePlusSvyaz.ImgCamera.isDisplayed(),
                "Img is not displayed");
    }

    //safety block
    @Test
    public void SafetyBlockTitleTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleSafety.scrollTo();
        sleep(900);
        String expectedTitle = "Безопасный доступ в одно касание благодаря сканеру отпечатков пальцев";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.TitleSafety.getText(),
                "Title with touch scanner is different");
    }
    @Test
    public void SafetyBlockSubTitleTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.SubtitleSafety.scrollTo();
        sleep(900);
        String expectedSubTitle = "Вы также можете активировать функцию двойного нажатия" +
                " для включения камеры или других часто используемых приложений.";
        assertEquals(expectedSubTitle,
                SmartphonePlusSvyaz.SubtitleSafety.getText(),
                "SubTitle with touch scanner is different");
    }
    @Test
    public void SafetyBlockDisplayingImgTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.ImgSafety.scrollTo();
        sleep(900);
        assertTrue(SmartphonePlusSvyaz.ImgSafety.isDisplayed(),
                "Img touch scanner is not displayed");
    }


    //Fast Smooth
    @Test
    public void FastSmoothBlockTitleTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleFastSmooth.scrollTo();
        sleep(900);
        String expectedTitle = "Быстрая и плавная работа нескольких приложений одновременно";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.TitleFastSmooth.getText(),
                "Title with perfomance scanner is different");
    }
    @Test
    public void FastSmoothBlockSubTitleTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.SubtitleFastSmooth.scrollTo();
        sleep(900);
        String expectedSubTitle = "Процессор MediaTek G85 и вместительная внутренняя" +
                " память для комфортной игры, просмотра видео и социальных сетей.";
        assertEquals(expectedSubTitle,
                SmartphonePlusSvyaz.SubtitleFastSmooth.getText(),
                "SubTitle with perfomance scanner is different");
    }
    @Test
    public void FastSmoothBlockDisplayingImgTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.ImgFastSmooth.scrollTo();
        sleep(900);
        assertTrue(SmartphonePlusSvyaz.ImgFastSmooth.isDisplayed(),
                "Img with games is not displayed");
    }


    // Get Smasung Galaxy A06 with complect
    @Test
    public void ConnectionBlockTitleTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.TitleConnection.scrollTo();
        sleep(900);
        String expectedTitle = "Получите Samsung Galaxy A06 в комплекте с мобильной связью" +
                " и защитой экрана за 920 ₽ в месяц!";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.TitleConnection.getText(),
                "Title Complect is different");
    }

    @Test
    public void ConnectionBlockSubTitleTest() {
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(900);
        String expectedTitle = "SIM-карта Smarta работает на базе оператора “t2“" +
                " – это означает покрытие по всей России.\n" +
                "Посмотрите зону покрытия.";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.SubTitleConnection.getText(),
                "SubTitle Complect is different");
    }

    @Test
    public void ConnectionBlockGbElementTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(900);
        String expectedTitle = "35";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.GbTitleConnection.getText().replaceAll("\\D", ""),
                "Gb element has different value");
    }
    @Test
    public void ConnectionBlockGbTextTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(900);
        String expectedTitle = "интернета в месяц без ограничения скорости";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.GbSubtitleConnection.getText(),
                "Gb element has different description");
    }
    @Test
    public void ConnectionBlockMinutesElementTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(900);
        String expectedTitle = "350";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.MinTitleConnection.getText().replaceAll("\\D", ""),
                "Minutes element has different value");
    }
    @Test
    public void ConnectionBlockMinutesTextTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(900);
        String expectedTitle = "звонков в месяц по всей России на номера любых операторов";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.MinSubtitleConnection.getText(),
                "Minutes element has different description");
    }
    @Test
    public void ConnectionBlock4GElementTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(1000);
        String expectedTitle = "4G";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.MobDataTitleConnection.getText(),
                "Mobile connection type element has different value");
    }
    @Test
    public void ConnectionBlock4GTextTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(1000);
        String expectedTitle = "скоростной интернет на всей территории покрытия";
        assertEquals(expectedTitle,
                SmartphonePlusSvyaz.MobDataSubtitleConnection.getText(),
                "Mobile connection type element has different description");
    }

    @Test
    public void ConnectionBlockButtonTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(500);
        SmartphonePlusSvyaz.ButtonConnection.click(
                ClickOptions.withTimeout(Duration.ofSeconds(3)));
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible, Duration.ofSeconds(3));
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed(), "Scrolling to the Accessories Failed");
    }
    @Test
    public void ConnectionBlockOpentLinkTest(){
        MaximizeWindow();
        SmartphonePlusSvyaz.SubTitleConnection.scrollTo();
        sleep(500);
        SmartphonePlusSvyaz.OperatorZoneLink.click(
                ClickOptions.withTimeout(Duration.ofSeconds(3)));
        sleep(1000);
        String expectedURL = "https://msk.t2.ru/coverage?ysclid=m3zybm5x49450605433";
       for (String wind : getWebDriver().getWindowHandles()) {
           getWebDriver().switchTo().window(wind);
           if (getWebDriver().getCurrentUrl().equals(expectedURL)) return;
       }
       assertEquals(expectedURL,
               getWebDriver().getCurrentUrl(),
               "Url t2 map is different!");
    }

    //Compare block
    @Test
    public void CompareBlockDisplayingTest(){
        MaximizeWindow();
        sleep(500);
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(800);
        assertTrue(SmartphonePlusSvyaz.TitleCompare.isDisplayed(),
                "Compare title isn't displayed");
    }
    // SmartaOffer
    @Test
    public void SmartaOfferNamingTest(){
        MaximizeWindow();
        String ExpectedSmarta = "Smarta",
                ExpectedOffer = "Смартфон + Связь";

        //Scrolling to the block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Smarta
        assertTrue(SmartphonePlusSvyaz.SmartaOfferTitle.is(Condition.visible),
                "Smarta is invisible");
        assertEquals(ExpectedSmarta,
                SmartphonePlusSvyaz.SmartaOfferTitle.getText(),
                "Smarta text is Different");
        //Smartphone+svyaz
        assertTrue(SmartphonePlusSvyaz.SmartaOfferInclude.is(Condition.visible),
                "Offer Include  is invisible");
        assertEquals(ExpectedOffer,
                SmartphonePlusSvyaz.SmartaOfferInclude.getText(),
                "Offer Include text is Different");



    }

    @Test
    public void SmartaOfferPriceTest(){
        MaximizeWindow();
        String ExpectedPrice = "920 ₽ в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Price
        assertTrue(SmartphonePlusSvyaz.SmartaOfferPrice.is(Condition.visible),
                "Price  is invisible");
        assertEquals(ExpectedPrice,
                SmartphonePlusSvyaz.SmartaOfferPrice.getText(),
                "Price is Different");
    }

    @Test
    public void SmartaOfferGbTest(){
        MaximizeWindow();
        String ExpectedGb = "35 гб в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Gb
        assertTrue(SmartphonePlusSvyaz.SmartaOfferGb.is(Condition.visible),
                "Gb element is invisible");
        assertEquals(ExpectedGb,
                SmartphonePlusSvyaz.SmartaOfferGb.getText(),
                "Gb is Different");
    }

    @Test
    public void SmartaOfferMinTest(){
        MaximizeWindow();
        String ExpectedMin = "350 минут в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Min
        assertTrue(SmartphonePlusSvyaz.SmartaOfferMin.is(Condition.visible),
                "Minutes element is invisible");
        assertEquals(ExpectedMin,
                SmartphonePlusSvyaz.SmartaOfferMin.getText(),
                "Minutes is Different");
    }
    @Test
    public void SmartaOfferIncludesSmartphoneAndInsuranceTest(){
        MaximizeWindow();
        String ExpectedIncludesText = "Включено в комплект",
                ExpectedSmartphone = "Смартфон Samsung Galaxy A06",
                ExpectedInsurance = "Страховка смартфона от повреждений";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //IncludesText
        assertTrue(SmartphonePlusSvyaz.SmartaOfferIncludeTitle.is(Condition.visible),
                "IncludesText is invisible");
        assertEquals(ExpectedIncludesText,
                SmartphonePlusSvyaz.SmartaOfferIncludeTitle.getText(),
                "IncludesText is Different");
        //Smartphone
        assertTrue(SmartphonePlusSvyaz.SmartaOfferIncludeSmartphone.is(Condition.visible),
                "Smartphone element is invisible");
        assertEquals(ExpectedSmartphone,
                SmartphonePlusSvyaz.SmartaOfferIncludeSmartphone.getText(),
                "Smartphone is Different");
        //Insurance
        assertTrue(SmartphonePlusSvyaz.SmartaOfferIncludeInsurance.is(Condition.visible),
                "InsuranceText is invisible");
        assertEquals(ExpectedInsurance,
                SmartphonePlusSvyaz.SmartaOfferIncludeInsurance.getText(),
                "InsuranceText is Different");
    }
    @Test
    public void SmartaOfferGreenTextTest(){
        MaximizeWindow();
        String ExpectedColor = "rgba(255, 255, 255, 1)";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        assertEquals(ExpectedColor,
                SmartphonePlusSvyaz.SmartaOfferInclude.getCssValue("color"),
                "Color isn't green");
    }
    /*
    // Disabled because of not comparing the source of the img
    @Test
    public void SmartaOfferCBOXTest(){
        MaximizeWindow();
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        assertTrue(SmartphonePlusSvyaz.SmartaOfferCBOXIncludeSmartphone.isDisplayed(),
                "No CBOX for the including Smartphone");
        assertTrue(SmartphonePlusSvyaz.SmartaOfferCBOXIncludeInsurance.isDisplayed(),
                "No CBOX for the including Insurance");
    }
     */

    // FirstOffer
    @Test
    public void Offer1NamingTest(){
    MaximizeWindow();
    String ExpectedSmarta = "Оператор 1";

    //Scrolling to the block
    assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
    SmartphonePlusSvyaz.TitleCompare.scrollTo();
    sleep(700);
    assertTrue(SmartphonePlusSvyaz.Offer1Title.is(Condition.visible),
                "Offer1 is invisible");
    assertEquals(ExpectedSmarta,
            SmartphonePlusSvyaz.Offer1Title.getText(),
                "Offer1 text is Different");
    }

    @Test
    public void Offer1PriceTest(){
        MaximizeWindow();
        String ExpectedPrice = "800 ₽ в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Price
        assertTrue(SmartphonePlusSvyaz.Offer1Price.is(Condition.visible),
                "Price  is invisible");
        assertEquals(ExpectedPrice,
                SmartphonePlusSvyaz.Offer1Price.getText(),
                "Price is Different");
    }

    @Test
    public void Offer1GbTest(){
        MaximizeWindow();
        String ExpectedGb = "20 гб";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Gb
        assertTrue(SmartphonePlusSvyaz.Offer1Gb.is(Condition.visible),
                "Gb element is invisible");
        assertEquals(ExpectedGb,
                SmartphonePlusSvyaz.Offer1Gb.getText(),
                "Gb is Different");
    }

    @Test
    public void Offer1MinTest(){
        MaximizeWindow();
        String ExpectedMin = "400 минут";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Min
        assertTrue(SmartphonePlusSvyaz.Offer1Min.is(Condition.visible),
                "Minutes element is invisible");
        assertEquals(ExpectedMin,
                SmartphonePlusSvyaz.Offer1Min.getText(),
                "Minutes is Different");
    }
    @Test
    public void Offer1IncludesSmartphoneAndInsuranceTest(){
        MaximizeWindow();
        String ExpectedSmartphone = "без смартфона",
                ExpectedInsurance = "без защиты";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Smartphone
        assertTrue(SmartphonePlusSvyaz.Offer1NotIncludeSmartphone.is(Condition.visible),
                "Smartphone element is invisible");
        assertEquals(ExpectedSmartphone,
                SmartphonePlusSvyaz.Offer1NotIncludeSmartphone.getText(),
                "Smartphone is Different");
        //Insurance
        assertTrue(SmartphonePlusSvyaz.Offer1NotIncludeInsurance.is(Condition.visible),
                "InsuranceText is invisible");
        assertEquals(ExpectedInsurance,
                SmartphonePlusSvyaz.Offer1NotIncludeInsurance.getText(),
                "InsuranceText is Different");
    }
    // Second Offer
    @Test
    public void Offer2NamingTest(){
        MaximizeWindow();
        String ExpectedSmarta = "Оператор 2";
        //Scrolling to the block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);

        assertTrue(SmartphonePlusSvyaz.Offer2Title.is(Condition.visible),
                "Offer2 is invisible");
        assertEquals(ExpectedSmarta,
                SmartphonePlusSvyaz.Offer2Title.getText(),
                "Offer2 text is Different");
    }

    @Test
    public void Offer2PriceTest(){
        MaximizeWindow();
        String ExpectedPrice = "780 ₽ в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Price
        assertTrue(SmartphonePlusSvyaz.Offer2Price.is(Condition.visible),
                "Price  is invisible");
        assertEquals(ExpectedPrice,
                SmartphonePlusSvyaz.Offer2Price.getText(),
                "Price is Different");
    }

    @Test
    public void Offer2GbTest(){
        MaximizeWindow();
        String ExpectedGb = "25 гб";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Gb
        assertTrue(SmartphonePlusSvyaz.Offer2Gb.is(Condition.visible),
                "Gb element is invisible");
        assertEquals(ExpectedGb,
                SmartphonePlusSvyaz.Offer2Gb.getText(),
                "Gb is Different");
    }

    @Test
    public void Offer2MinTest(){
        MaximizeWindow();
        String ExpectedMin = "250 минут";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Min
        assertTrue(SmartphonePlusSvyaz.Offer2Min.is(Condition.visible),
                "Minutes element is invisible");
        assertEquals(ExpectedMin,
                SmartphonePlusSvyaz.Offer2Min.getText(),
                "Minutes is Different");
    }
    @Test
    public void Offer2IncludesSmartphoneAndInsuranceTest(){
        MaximizeWindow();
        String ExpectedSmartphone = "без смартфона",
                ExpectedInsurance = "без защиты";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Smartphone
        assertTrue(SmartphonePlusSvyaz.Offer2NotIncludeSmartphone.is(Condition.visible),
                "Smartphone element is invisible");
        assertEquals(ExpectedSmartphone,
                SmartphonePlusSvyaz.Offer2NotIncludeSmartphone.getText(),
                "Smartphone is Different");
        //Insurance
        assertTrue(SmartphonePlusSvyaz.Offer2NotIncludeInsurance.is(Condition.visible),
                "InsuranceText is invisible");
        assertEquals(ExpectedInsurance,
                SmartphonePlusSvyaz.Offer2NotIncludeInsurance.getText(),
                "InsuranceText is Different");
    }

    // Third Offer
    @Test
    public void Offer3NamingTest(){
        MaximizeWindow();
        String ExpectedSmarta = "Оператор 3";
        //Scrolling to the block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);

        assertTrue(SmartphonePlusSvyaz.Offer3Title.is(Condition.visible),
                "Offer3 is invisible");
        assertEquals(ExpectedSmarta,
                SmartphonePlusSvyaz.Offer3Title.getText(),
                "Offer3 text is Different");
    }

    @Test
    public void Offer3PriceTest(){
        MaximizeWindow();
        String ExpectedPrice = "750 ₽ в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Price
        assertTrue(SmartphonePlusSvyaz.Offer3Price.is(Condition.visible),
                "Price  is invisible");
        assertEquals(ExpectedPrice,
                SmartphonePlusSvyaz.Offer3Price.getText(),
                "Price is Different");
    }

    @Test
    public void Offer3GbTest(){
        MaximizeWindow();
        String ExpectedGb = "20 гб";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Gb
        assertTrue(SmartphonePlusSvyaz.Offer3Gb.is(Condition.visible),
                "Gb element is invisible");
        assertEquals(ExpectedGb,
                SmartphonePlusSvyaz.Offer3Gb.getText(),
                "Gb is Different");
    }

    @Test
    public void Offer3MinTest(){
        MaximizeWindow();
        String ExpectedMin = "400 минут";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Min
        assertTrue(SmartphonePlusSvyaz.Offer3Min.is(Condition.visible),
                "Minutes element is invisible");
        assertEquals(ExpectedMin,
                SmartphonePlusSvyaz.Offer3Min.getText(),
                "Minutes is Different");
    }
    @Test
    public void Offer3IncludesSmartphoneAndInsuranceTest(){
        MaximizeWindow();
        String ExpectedSmartphone = "без смартфона",
                ExpectedInsurance = "без защиты";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Smartphone
        assertTrue(SmartphonePlusSvyaz.Offer3NotIncludeSmartphone.is(Condition.visible),
                "Smartphone element is invisible");
        assertEquals(ExpectedSmartphone,
                SmartphonePlusSvyaz.Offer3NotIncludeSmartphone.getText(),
                "Smartphone is Different");
        //Insurance
        assertTrue(SmartphonePlusSvyaz.Offer3NotIncludeInsurance.is(Condition.visible),
                "InsuranceText is invisible");
        assertEquals(ExpectedInsurance,
                SmartphonePlusSvyaz.Offer3NotIncludeInsurance.getText(),
                "InsuranceText is Different");
    }
    // Fourth Offer
    @Test
    public void Offer4NamingTest(){
        MaximizeWindow();
        String ExpectedSmarta = "Оператор 4";
        //Scrolling to the block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);

        assertTrue(SmartphonePlusSvyaz.Offer4Title.is(Condition.visible),
                "Offer4 is invisible");
        assertEquals(ExpectedSmarta,
                SmartphonePlusSvyaz.Offer4Title.getText(),
                "Offer4 text is Different");
    }

    @Test
    public void Offer4PriceTest(){
        MaximizeWindow();
        String ExpectedPrice = "1050 ₽ в мес.";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);

        assertTrue(SmartphonePlusSvyaz.Offer4Price.is(Condition.visible),
                "Price  is invisible");
        assertEquals(ExpectedPrice,
                SmartphonePlusSvyaz.Offer4Price.getText(),
                "Price is Different");
    }

    @Test
    public void Offer4GbTest(){
        MaximizeWindow();
        String ExpectedGb = "35 гб";
        //Scrolling to the Comparing Block
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Gb
        assertTrue(SmartphonePlusSvyaz.Offer4Gb.is(Condition.visible),
                "Gb element is invisible");
        assertEquals(ExpectedGb,
                SmartphonePlusSvyaz.Offer4Gb.getText(),
                "Gb is Different");
    }

    @Test
    public void Offer4MinTest(){
        MaximizeWindow();
        String ExpectedMin = "800 минут";
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Min
        assertTrue(SmartphonePlusSvyaz.Offer4Min.is(Condition.visible),
                "Minutes element is invisible");
        assertEquals(ExpectedMin,
                SmartphonePlusSvyaz.Offer4Min.getText(),
                "Minutes is Different");
    }
    @Test
    public void Offer4IncludesSmartphoneAndInsuranceTest(){
        MaximizeWindow();
        String ExpectedSmartphone = "без смартфона",
                ExpectedInsurance = "без защиты";
        assertTrue(SmartphonePlusSvyaz.TitleCompare.is(Condition.enabled),
                "Compare title is disabled");
        SmartphonePlusSvyaz.TitleCompare.scrollTo();
        sleep(700);
        //Smartphone
        assertTrue(SmartphonePlusSvyaz.Offer4NotIncludeSmartphone.is(Condition.visible),
                "Smartphone element is invisible");
        assertEquals(ExpectedSmartphone,
                SmartphonePlusSvyaz.Offer4NotIncludeSmartphone.getText(),
                "Smartphone is Different");
        //Insurance
        assertTrue(SmartphonePlusSvyaz.Offer4NotIncludeInsurance.is(Condition.visible),
                "InsuranceText is invisible");
        assertEquals(ExpectedInsurance,
                SmartphonePlusSvyaz.Offer4NotIncludeInsurance.getText(),
                "InsuranceText is Different");
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
    public void ChangingMinSumTest(){
        MaximizeWindow();
       // final int
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click(
                ClickOptions.withTimeout(Duration.ofSeconds(3)));
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible,
                Duration.ofSeconds(3));
        sleep(2000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
        int minSUM = Integer.parseInt(SmartphonePlusSvyaz.AccessoriesPrice.getText().replaceAll("\\D+",""));
        assertEquals(5500, minSUM);

        while(!SmartphonePlusSvyaz.ButtonAccessories.isEnabled()){
            minSUM-=Integer.parseInt(SmartphonePlusSvyaz.AccessoriesPrices.get(0)
                    .getText()
                    .replaceAll("\\D+",""));
            SmartphonePlusSvyaz.AccessoriesButtonsAdd.get(0).click(
                    ClickOptions.withTimeout(Duration.ofSeconds(4)));
            if (minSUM > 0){
                assertEquals(minSUM,
                        Integer.parseInt(
                                SmartphonePlusSvyaz.AccessoriesPrice.getText()
                                .replaceAll("\\D+","")),
                        "Incorrect Calculations of Accessory SUM");
            }
        }
        assertFalse(SmartphonePlusSvyaz.TextAccessories.isDisplayed(),
                "MIN SUM text is displayed");
        assertFalse(SmartphonePlusSvyaz.AccessoriesPrice.isDisplayed(),
                "MIN SUM Displayed!");
    }

    @Test
    public void DeletingAccessoryTest(){
        MaximizeWindow();
        // final int
        assertTrue(SmartphonePlusSvyaz.Button.exists());
        SmartphonePlusSvyaz.Button.click(
                ClickOptions.withTimeout(Duration.ofSeconds(3)));
        SmartphonePlusSvyaz.TitleAccessories.shouldBe(Condition.visible,
                Duration.ofSeconds(3));
        sleep(2000);
        assertTrue(SmartphonePlusSvyaz.TitleAccessories.isDisplayed());
        int minSUM = Integer.parseInt(SmartphonePlusSvyaz.AccessoriesPrice.getText()
                .replaceAll("\\D+",""));
        assertEquals(5500, minSUM);

            minSUM-=Integer.parseInt(SmartphonePlusSvyaz.AccessoriesPrices.get(0)
                    .getText()
                    .replaceAll("\\D+",""));
            SmartphonePlusSvyaz.AccessoriesButtonsAdd.get(0).click(
                    ClickOptions.withTimeout(Duration.ofSeconds(4)));
        assertTrue(SmartphonePlusSvyaz.TextAccessories.isDisplayed(),
                "MIN SUM text is displayed");
        assertTrue(SmartphonePlusSvyaz.AccessoriesPrice.isDisplayed(),
                "MIN SUM Displayed!");
        SmartphonePlusSvyaz.AddedAccessories.get(0)
                .click(
                        ClickOptions.withTimeout(Duration.ofSeconds(5)));
        assertEquals(5500,
                Integer.parseInt(SmartphonePlusSvyaz.AccessoriesPrice.getText()
                .replaceAll("\\D+","")),
                "MIN SUM Didn't change");
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
