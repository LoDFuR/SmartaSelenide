package com.example.junit5.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
/*
    Шаблон для селектора XPATH
    public static SelenideElement ElementName = $(By.xpath("XPATH"));
*/
public class SmartphonePlusSvyaz {
    public static String main = "https://dev.smarta.lc/samsung-galaxy-a06-svyas777";
    // Блок с изображением смартфона с подписью "Можно перейти со своим номером"

    public static SelenideElement Title = $(By.xpath("*//h1[contains(text(),'Samsung Galaxy A06 + связь на 3 года')]"));
    public static SelenideElement Subtitle = $(By.xpath("*//div[contains(text(),'Отличный современный смартфон с двумя SIM-картами')]"));
    public static SelenideElement Button = $(By.xpath("(*//button)[1]"));
    public static SelenideElement Img = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[1]"));

    //Блок Легендарная серия
    public static SelenideElement TitleLegendary = $(By.xpath("*//div[contains(text(),'Легендарная серия')]"));
    public static SelenideElement SubtitleLegendary = $(By.xpath("*//div[contains(text(),'Расширьте свои возможности на большом экране Galaxy A06')]"));
    public static SelenideElement ImgLegendary = $(By.xpath("(*//img[@alt = 'bg-image'])[1]"));

    //Блок Основные характеристики
    public static SelenideElement TitleCharacteristic = $(By.xpath("*//div[contains(text(),'Основные характеристики')]"));
    public static SelenideElement ImgCharacteristic1 = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[2]"));
    public static SelenideElement SubtitleCharacteristic1 = $(By.xpath("*//div[contains(text(),'Безграничный 6,7 экран для больших возможностей')]"));
    public static SelenideElement ImgCharacteristic2 = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[3]"));
    public static SelenideElement SubtitleCharacteristic2 = $(By.xpath("(*//div[contains(text(),'Основная камера с высоким разрешением 50 МП')])[1]"));
    public static SelenideElement ImgCharacteristic3 = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[4]"));
    public static SelenideElement SubtitleCharacteristic3 = $(By.xpath("*//div[contains(text(),'Мощный аккумулятор и супербыстрая зарядка')]"));

    // Блок Стильный изящный дизайн
    public static SelenideElement TitleDesign = $(By.xpath("//div[contains(text(),'Стильный изящный дизайн')]"));
    public static SelenideElement SubtitleDesign = $(By.xpath("//div[contains(text(),'Galaxy A06 получил повышенный уровень комфорта')]"));
    public static SelenideElement ImgDesign1 = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[5]"));
    public static SelenideElement ImgDesign2 = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[6]"));


    // Блок Основная камера
    public static SelenideElement TitleCamera = $(By.xpath("(*//div[contains(text(),'Основная камера с высоким разрешением 50 МП')])[2]"));
    public static SelenideElement SubtitleCamera = $(By.xpath("*//div[contains(text(),'Откройте для себя возможности камеры Galaxy A06')]"));
    public static SelenideElement ImgCamera = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[7]"));



    // 2 блока в горизонтальной сетке: Безопасный доступ + Быстрая и плавная работа
    // Безопасный доступ
    public static SelenideElement TitleSafety = $(By.xpath("//div[contains(text(),'Безопасный доступ')]"));
    public static SelenideElement SubtitleSafty = $(By.xpath("//div[contains(text(),'Вы также можете активировать функцию')]"));
    public static SelenideElement ImgSafety = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[8]"));
    // Быстрая и плавная работа
    public static SelenideElement TitleFastSmooth = $(By.xpath("//div[contains(text(),'Быстрая и плавная работа')]"));
    public static SelenideElement SubtitleFastSmooth = $(By.xpath("//div[contains(text(),'Процессор MediaTek G85')]"));
    public static SelenideElement ImgFastSmooth = $(By.xpath("(*//img[@alt = 'samsung-galaxy-a06'])[9]"));


    //Блок получите в комплекте с мобильной связью
    public static SelenideElement TitleConnection = $(By.xpath("//div[contains(text(),'в комплекте с мобильной связью')]"));
    public static SelenideElement SubTitleConnection = $(By.xpath("//div[contains(text(),'SIM-карта Smarta работает на базе оператора')]"));
    public static SelenideElement OperatorZoneLink = $(By.xpath("//a[contains(text(),'Посмотрите зону покрытия')]"));
    // GRID
    public static SelenideElement GbTitleConnection = $(By.xpath("(*//div[contains(text(),'35 Гб')])[2]"));
    public static SelenideElement GbSubtitleConnection = $(By.xpath("//div[contains(text(),'интернета в месяц без ограничения')]"));
    public static SelenideElement MinTitleConnection = $(By.xpath("//div[contains(text(),'350 мин')]"));
    public static SelenideElement MinSubtitleConnection = $(By.xpath("//div[contains(text(),'звонков в месяц по всей России')]"));
    //MobData = mobile data connection
    public static SelenideElement MobDataTitleConnection = $(By.xpath("//div[contains(text(),'4G')]"));
    public static SelenideElement MobDataSubtitleConnection = $(By.xpath("//div[contains(text(),'скоростной интернет на всей территории')]"));
    // Button
    public static SelenideElement ButtonConnection = $(By.xpath("(*//button)[2]"));


    // Блок сравнения предложений связи доделать селекторы нц
    public static SelenideElement TitleCompare = $(By.xpath("*//div[contains(text(),'Сравните наше предложение')]"));

    // Оффер Смарта
    public static SelenideElement SmartaOfferTitle = $(By.xpath("(*//div[contains(text(),'Smarta')])[2]"));
    public static SelenideElement SmartaOfferInclude = $(By.xpath("*//div[contains(text(),'Смартфон + Связь')]"));
    public static SelenideElement SmartaOfferPrice = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[1]"));
    public static SelenideElement SmartaOfferPricePerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[1]//span[contains(text(), '₽ в мес.')]"));
    public static SelenideElement SmartaOfferGb = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[2]"));
    public static SelenideElement SmartaOfferGbPerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[2]//span[contains(text(), 'гб в мес.')]"));
    // Плохой селектор на минуты: написан по полному имени класса !!!!!! надо бы его переделать
    public static SelenideElement SmartaOfferMin = $(By.xpath("*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6 samsung-galaxy-a06_tableItemFeatureMarginBottomColor__DWIvs']"));
    public static SelenideElement SmartaOfferMinPerMonth = $(By.xpath("*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6 samsung-galaxy-a06_tableItemFeatureMarginBottomColor__DWIvs']//span[contains(text(), 'минут в мес.')]"));
    // Включено в комплект
    public static SelenideElement SmartaOfferIncludeTitle = $(By.xpath("*//div[contains(text(), 'Включено в комплект')]"));
    public static SelenideElement SmartaOfferIncludeSmartphone = $(By.xpath("*//div[contains(text(), 'Смартфон Samsung Galaxy A06')]"));
    public static SelenideElement SmartaOfferCBOXIncludeSmartpone = $(By.xpath("*//div[contains(text(), 'Смартфон Samsung Galaxy A06')]//img"));
    public static SelenideElement SmartaOfferIncludeInsurance = $(By.xpath("*//div[contains(text(), 'Страховка смартфона от повреждений')]"));
    public static SelenideElement SmartaOfferCBOXIncludeInsurance = $(By.xpath("*//div[contains(text(), 'Страховка смартфона от повреждений')]//img"));

// Оператор 1
    public static SelenideElement Offer1Title = $(By.xpath("*//div[contains(text(), 'Оператор 1')]"));
    public static SelenideElement Offer1Price = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[3]"));
    public static SelenideElement Offer1PricePerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[3]//span[contains(text(), '₽ в мес.')]"));
    public static SelenideElement Offer1Gb = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[4]"));
    public static SelenideElement Offer1GbPerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[4]//span[contains(text(), 'гб')]"));
    public static SelenideElement Offer1Min = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[1]"));
    public static SelenideElement Offer1MinPerMonth = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[1]//span[contains(text(), 'минут')]"));
    public static SelenideElement Offer1NotIncludeSmartphone = $(By.xpath("(*//div[contains(text(), 'без смартфона')])[1]"));
    public static SelenideElement Offer1NotIncludeInsurance = $(By.xpath("(*//div[contains(text(), 'без защиты')])[1]"));

// Оператор 2
    public static SelenideElement Offer2Title = $(By.xpath("*//div[contains(text(), 'Оператор 2')]"));
    public static SelenideElement Offer2Price = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[5]"));
    public static SelenideElement Offer2PricePerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[5]//span[contains(text(), '₽ в мес.')]"));
    public static SelenideElement Offer2Gb = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[6]"));
    public static SelenideElement Offer2GbPerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[6]//span[contains(text(), 'гб')]"));
    public static SelenideElement Offer2Min = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[2]"));
    public static SelenideElement Offer2MinPerMonth = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[2]//span[contains(text(), 'минут')]"));
    public static SelenideElement Offer2NotIncludeSmartphone = $(By.xpath("(*//div[contains(text(), 'без смартфона')])[2]"));
    public static SelenideElement Offer2NotIncludeInsurance = $(By.xpath("(*//div[contains(text(), 'без защиты')])[2]"));

    // Оператор 3
    public static SelenideElement Offer3Title = $(By.xpath("*//div[contains(text(), 'Оператор 3')]"));
    public static SelenideElement Offer3Price = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[7]"));
    public static SelenideElement Offer3PricePerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[7]//span[contains(text(), '₽ в мес.')]"));
    public static SelenideElement Offer3Gb = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[8]"));
    public static SelenideElement Offer3GbPerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[8]//span[contains(text(), 'гб')]"));
    public static SelenideElement Offer3Min = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[3]"));
    public static SelenideElement Offer3MinPerMonth = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[3]//span[contains(text(), 'минут')]"));
    public static SelenideElement Offer3NotIncludeSmartphone = $(By.xpath("(*//div[contains(text(), 'без смартфона')])[3]"));
    public static SelenideElement Offer3NotIncludeInsurance = $(By.xpath("(*//div[contains(text(), 'без защиты')])[3]"));

    // Оператор 4
    public static SelenideElement Offer4Title = $(By.xpath("*//div[contains(text(), 'Оператор 4')]"));
    public static SelenideElement Offer4Price = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[9]"));
    public static SelenideElement Offer4PricePerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[9]//span[contains(text(), '₽ в мес.')]"));
    public static SelenideElement Offer4Gb = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[10]"));
    public static SelenideElement Offer4GbPerMonth = $(By.xpath("(*//div[@class='samsung-galaxy-a06_tableItemFeature__vbA_C'])[10]//span[contains(text(), 'гб')]"));
    public static SelenideElement Offer4Min = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[4]"));
    public static SelenideElement Offer4MinPerMonth = $(By.xpath("(*//div[@class = 'samsung-galaxy-a06_tableItemFeature__vbA_C samsung-galaxy-a06_tableItemFeatureMarginBottom__hhdb6'])[4]//span[contains(text(), 'минут')]"));
    public static SelenideElement Offer4NotIncludeSmartphone = $(By.xpath("(*//div[contains(text(), 'без смартфона')])[4]"));
    public static SelenideElement Offer4NotIncludeInsurance = $(By.xpath("(*//div[contains(text(), 'без защиты')])[4]"));
    // доделать селекторы кц


    // Блок ваш смартфон защищен
    public static SelenideElement TitleProtected = $(By.xpath("*//div[contains(text(),'Ваш смартфон защищен')]"));
    public static SelenideElement SubTitleProtected = $(By.xpath("*//div[contains(text(),'Если вы вдруг разобьете экран')]"));
    public static SelenideElement TextProtected = $(By.xpath("*//div[contains(text(),'Эта возможность уже включена в платеж и действует')]"));
    public static SelenideElement ImgProtected = $(By.xpath("(*//img[@alt = 'bg-image'])[2]"));


    // Блок в конце договора
    public static SelenideElement TitleOptions = $(By.xpath("*//div[contains(text(), 'В конце срока договора')]"));

    public static SelenideElement TitleToday = $(By.xpath("*//div[@class='samsung-galaxy-a06_title__hYX1R'][contains(text(), 'Сегодня')]"));
    public static SelenideElement SubTitleToday = $(By.xpath("*//div[@class='samsung-galaxy-a06_text___5KU4'][contains(text(), 'Оформляйте договор')]"));
    // !!!!!!Указано конкретное кол-во месяцев: 36!!!!!!!
    public static SelenideElement TitleLater = $(By.xpath("*//div[@class='samsung-galaxy-a06_title__hYX1R'][contains(text(), '36 месяцев')]"));
    public static SelenideElement SubTitleLater = $(By.xpath("*//div[@class='samsung-galaxy-a06_text___5KU4'][contains(text(), 'Пользуйтесь смартфоном и мобильной связью')]"));
    public static SelenideElement TitleAtTheEnd = $(By.xpath("*//div[@class='samsung-galaxy-a06_title__hYX1R'][contains(text(), 'В конце срока')]"));
    public static SelenideElement SubTitleAtTheEnd = $(By.xpath("*//div[@class='samsung-galaxy-a06_text___5KU4'][contains(text(), 'Обменяйте смартфон на новый или оставьте себе')]"));
    public static SelenideElement TextOptions = $(By.xpath("*//div[contains(text(), 'Можно ли закрыть договор досрочно')]"));



    // Блок Подберите аксессуары
    // Нужно будет обращаться к карусели аксессуаров как к коллекции элементов, выдергивать по одному элементу для теста
    public static SelenideElement TitleAccessories = $(By.xpath("*//span[contains(text(),'Подберите аксессуары')]"));
    public static SelenideElement AccessoriesSwiper = $(By.xpath("*//div[@class='swiper swiper-initialized swiper-horizontal offerSwiper swiper-backface-hidden']"));
    public static SelenideElement Accessory = $(By.xpath("//div[@class = 'swiper-slide swiper-slide-active swiperSlide']"));
    public static SelenideElement ButtonAccessories = $(By.xpath("*//button[@type='submit']"));
    public static SelenideElement TextAccessories = $(By.xpath("*//span[contains(text(),'Добавьте аксессуаров на сумму')]"));
    public static SelenideElement AccessoriesPrice = $(By.xpath("*//span[@class='priceTitle']/b"));
    ////div[contains(text(),'в комплекте с мобильной связью')]
    //public static SelenideElement ElementName = $(By.xpath("XPATH"));
    //(*//img[@alt = 'samsung-galaxy-a06'])[1]



}