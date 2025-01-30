package com.example.junit5.Test;
//import net.lightbody.bmp.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.HarEntry;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import com.example.junit5.Pages.Catalog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.example.junit5.Pages.Retail;
import net.lightbody.bmp.BrowserMobProxy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Request;
import org.openqa.selenium.devtools.v132.indexeddb.IndexedDB;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class RetailTest {

    private static SelenideProxyServer proxyServer;
    public static BrowserUpProxy bmp;
    @BeforeAll
    public static void setup() {
        // Настройка Selenide
        //Configuration.startMaximized = true;
        Configuration.browser = "chrome";

        // Настройка прокси-сервера
        Configuration.proxyEnabled = true;
//        proxyServer = new BrowserUpProxyServer();
//        proxyServer.start();
//        Configuration.proxyHost = "localhost:";
//        bmp.start();
        WebDriverRunner.getSelenideProxy().start();
        bmp = WebDriverRunner.getSelenideProxy().getProxy();

        // запоминать тело запросов (по умолчанию тело не запоминается, ибо может быть большим)
        bmp.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());

        // запоминать как запросы, так и ответы
        bmp.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // начинай запись!
        bmp.newHar("Q_Q");
    }
    @Test
    public void testAnalyzeRequests() {
        // Открытие веб-страницы
//        open("https://jsonplaceholder.typicode.com/"); // пример URL

        // Выполнение действий на странице
        // Например, инициирование запроса, если это необходимо
      //  $("#someButton").click(); // замените селектор на фактический элемент
        open(Catalog.main);
        getWebDriver().manage().window().maximize();
        sleep(2000);
        // Выбираем товар
        Catalog.PhoneLink.scrollIntoView(false);
        sleep(1500);




        List<HarEntry> requests = bmp.getHar().getLog().getEntries();
        //Selenide.closeWebDriver();
        // Анализ запросов
        //List <HarEntry> requests = bmp.getHar().getLog().getEntries();;
        for (var request : requests) {
            System.out.println("Request URL: " + request.getRequest().getUrl());
            System.out.println("Request Method: " + request.getResponse().getContent());
//            System.out.println("Request Headers: " + request.getHeaders());
            // Вы можете добавить более сложную логику анализа
        }

        // Пример проверки, анализируя последний запрос
//        var lastRequest = requests.get(requests.size() - 1);
//        assertThat(lastRequest.getUrl(), containsString("expectedPath")); // используйте ваше ожидаемое значение
    }




/**
 * 29.01 не проходила авторизация с помощью отправки запроса с помощью RESTASSURED
 * /api/v1/user/registration/send-code - метод для получения кода при регистрации
 * */
    @Test
    public void AccessTokenChangingAfterClosingBrowserTest() {
        String orderID = "f6a97991-59e2-4c94-9bb2-24af7ad8447e";

        // Добавляем режим инкогнито
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.browserCapabilities = options;

        open(Retail.url + orderID);
        getWebDriver().manage().window().maximize();

        // Authorization
        sleep(2000);
        Retail.ButtonStart.click(ClickOptions.withTimeout(Duration.ofSeconds(4)));
        sleep(1000);
        /*
         * Надо добавить автогенерацию номера
         * */

        String number = "980-750-68-24";
        Retail.InputNumber.setValue(number);
        //driver = new ChromeDriver(options);
//        driver()
//        ChromeDriverFactory
//        DevTools devTools = driver();
//        devTools.createSession(getWebDriver().getWindowHandle());
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        Retail.ButtonGetSMS.click(ClickOptions.withTimeout(Duration.ofSeconds(3)));
        sleep(2000);
       // DevTools devTools = ;
        sleep(2000);


        /*
        REST ASSURE POST method
            /api/v1/user/registration/send-code
         */
        /*
        RestAssured.baseURI = "https://dev.smarta.lc";
        // Данные для отправки
        // PhoneNumber = "+79807506824"
        Set<Cookie> Coc;
        Cookie retail_acc_token = null, acc_token = null;
        Coc = getWebDriver().manage().getCookies();
        // поиск retail_access_token
        for (Cookie cookie : Coc) {
            if (cookie.getName().equals("retail_access_token"))
                retail_acc_token = cookie;
            if (cookie.getName().equals("access_token")) ;
            acc_token = cookie;
        }
        String jsonBody = "{\"phone\":\"" + "+79807506824\"" + ", \"again\": false" +"}"; // + ", \"again\": false"
        sleep(2000);
        Response response = given().header("Content-Type", "application/json") // Установка заголовка Content-Type
                .body(jsonBody) // Установка тела запроса
                .sessionId(((RemoteWebDriver) getWebDriver()).getSessionId().toString()) // Попытка перенести данные сессии
                .cookie(String.valueOf(retail_acc_token))
                .when()
                .post("/api/v1/user/registration/send-code") // Укажите путь для POST-запроса
                .then()
                .statusCode(200) // Ожидаем статус ответа 200
                .extract()
                .response(); // Извлечение ответа для дальнейшей обработки

        // Печатаем ответ
        response.getBody().prettyPrint();
        // Анализ ответа
        String responseBody = response.getBody().asString();
       // System.out.println("Response Body: " + responseBody); // Выводим тело ответа


        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Преобразование строки JSON в JsonNode
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            // Переводим json обратно в строку, чтобы получить "Внутренний" json
            String data = jsonNode.get("data").toString();
            System.out.println("Data: " + data); // Печатаем json ответа
            JsonNode jNode = objectMapper.readTree(data);
            // метод для получения значения не сработал -> получаю значение из строки ""%d""
            String cc = jNode.get("code").toString();
            System.out.println("Code as string: " + cc); // Печатаем код из смс
            // Форматируем строку, удаляя "
            cc = cc.replace("\"", "");


            Retail.InputCode.setValue(cc);
            sleep(900);
            Retail.ButtonSubmitCode.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
            sleep(700);


            //Checking cookies

            Set<Cookie> cookies = null;
           // Cookie retail_acc_token = null, acc_token = null;
            cookies = getWebDriver().manage().getCookies();
            // поиск retail_access_token
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("retail_access_token"))
                    retail_acc_token = cookie;
                if (cookie.getName().equals("access_token")) ;
                acc_token = cookie;
            }
            // печатаем куки access_token, retail_access_token
            System.out.println(acc_token);
            System.out.println("Name: " + acc_token.getName());
            System.out.println("Value: " + acc_token.getValue());

            System.out.println(retail_acc_token);
            System.out.println("Name: " + retail_acc_token.getName());
            System.out.println("Value: " + retail_acc_token.getValue());

            sleep(10000);

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

         */
    }
}
