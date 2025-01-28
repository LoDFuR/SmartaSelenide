package com.example.junit5.Test;
//import net.lightbody.bmp.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.HarEntry;
import org.openqa.selenium.Proxy;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.junit5.Pages.Retail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import com.browserup.bup.assertion.model.AssertionResult;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class RetailTest {
    /*
     * Печатает куки ритейла до и после переоткрытия браузера
     *  */
    @Test
    public void PrintCookiesForReOpeningPage() {
        String orderID = "4a5e155d-b446-4daa-8c98-a82eebceb07d";
        open(Retail.url + orderID);
        sleep(2000);
        Set<Cookie> cookies = getWebDriver().manage().getCookies();
        //String localStorageContent = executeJavaScript("return JSON.stringify(localStorage);");
        Cookie retail_acc_token = null;
        // поиск retail_access_token
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("retail_access_token"))
                retail_acc_token = cookie;

            /*
            // Cookie print
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Secure: " + cookie.isSecure());
            System.out.println("HttpOnly: " + cookie.isHttpOnly());
            System.out.println("-----------");
            */
        }

        //Assertions.assertTrue(cookies.contains(), "retail_access_token cookie is missing");
        //    System.out.println("Содержимое Local Storage: " + localStorageContent);


        sleep(5000);
        closeWebDriver();
        // Reopen
        open("https://dev.smarta.lc/retail?orderSnapshotId=" + orderID);
        sleep(2000);
        Set<Cookie> newCookies;
        newCookies = getWebDriver().manage().getCookies();
        // retail_access_token после закрытия WebDriver'а
        for (Cookie cookie : newCookies) {
            if (cookie.getName().equals("retail_access_token"))
                Assertions.assertEquals(retail_acc_token, cookie);

//            System.out.println("Name: " + cookie.getName());
//            System.out.println("Value: " + cookie.getValue());
//            System.out.println("Domain: " + cookie.getDomain());
//            System.out.println("Path: " + cookie.getPath());
//            System.out.println("Expiry: " + cookie.getExpiry());
//            System.out.println("Secure: " + cookie.isSecure());
//            System.out.println("HttpOnly: " + cookie.isHttpOnly());
//            System.out.println("-----------");
        }
        // localStorageContent = executeJavaScript("return JSON.stringify(localStorage);");
        //  System.out.println("Содержимое Local Storage: " + localStorageContent);
        sleep(10000);
    }

    @Test
    public void AccessTokenChangingAfterClosingBrowserTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("goog:loggingPrefs", Map.of("performance", "ALL"));
//        ChromeDriverFactory()
        String orderID = "4a5e155d-b446-4daa-8c98-a82eebceb07d";

       // System.setProperty("chrome.exe", "C:\\Program Files\\Google\\Chrome\\Application");
//        Configuration.proxyEnabled = true;
//        // Настройка ChromeOptions для включения логирования производительности
////        ChromeOptions options = new ChromeOptions();
////        options.setCapability("goog:loggingPrefs", Map.of("CLIENT", "ALL"));
////        options.setExperimentalOption("w3c", false);
//        BrowserUpProxy bmp = WebDriverRunner.getSelenideProxy().getProxy();
//       // bmp.start(0);
//        // запоминать тело запросов (по умолчанию тело не запоминается, ибо может быть большим)
//        bmp.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
//
//        // запоминать как запросы, так и ответы
//        bmp.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//
//
//        bmp.newHar("Q_Q");

        open(Retail.url + orderID);
        getWebDriver().manage().window().maximize();
        //getWebDriver().manage().
        // Authorization
        Retail.ButtonStart.click(ClickOptions.withTimeout(Duration.ofSeconds(4)));
        sleep(1000);
        /*
         * Надо добавить автогенерацию номера
         * */
        String number = "980-750-68-23";
        Retail.InputNumber.setValue(number);
        Retail.ButtonGetSMS.click(ClickOptions.withTimeout(Duration.ofSeconds(3)));
        sleep(4000);
        // List<String> Logs = getWebDriverLogs(LogType.CLIENT);
        //System.out.println(bmp.getHar());

//        List<HarEntry> requests = bmp.getHar().getLog().getEntries();
//        for (HarEntry HR : requests)
//            System.out.println(HR.toString());
        /*
        LogEntries performanceLog = getWebDriver().manage().logs().get(LogType.CLIENT);

        // Анализируем логи на наличие POST запросов
        for (LogEntry entry : performanceLog) {
            String message = entry.getMessage();
            if (message.contains("POST")) {
                // Здесь вы можете обработать ответ
                System.out.println("Ответ на POST запрос: " + message);
            }
        }
*/
//        for (String s : Logs)
//            System.out.println("LOG" + s);
            sleep(10000);
            //Checking cookies

        /*
        Set<Cookie> newCookies = null;
        Set<Cookie> cookies = null;
        Cookie retail_acc_token = null;
        // поиск retail_access_token
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("retail_access_token"))
                retail_acc_token = cookie;
        }
        cookies = getWebDriver().manage().getCookies();


        newCookies = getWebDriver().manage().getCookies();
        // retail_access_token после закрытия WebDriver'а
        for (Cookie cookie : newCookies) {
            if (cookie.getName().equals("retail_access_token"))
                Assertions.assertEquals(retail_acc_token, cookie);
        }

         */

        }
    }
