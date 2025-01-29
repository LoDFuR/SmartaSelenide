package com.example.junit5.Test;
//import net.lightbody.bmp.BrowserUpProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.example.junit5.Pages.Retail;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;

public class RetailTest {


/**
 * 29.01 не проходила авторизация с помощью отправки запроса с помощью RESTASSURED
 * /api/v1/user/registration/send-code - метод для получения кода при регистрации
 * */
    @Test
    public void AccessTokenChangingAfterClosingBrowserTest() {
        String orderID = "8b7250e7-ef1b-47df-819a-877231779781";

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
        Retail.ButtonGetSMS.click(ClickOptions.withTimeout(Duration.ofSeconds(3)));
        sleep(2000);
        sleep(2000);
        /*
        REST ASSURE POST method
            /api/v1/user/registration/send-code
         */
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
            sleep(900000);
            Retail.ButtonSubmitCode.click(ClickOptions.withTimeout(Duration.ofSeconds(5)));
            sleep(7000);


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
    }
}
