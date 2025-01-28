package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class RetailRequest {

        public static void main(String[] args) throws Exception {


            // Создаем экземпляр HttpClient
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper objectMapper = new ObjectMapper();
            // Создаем JSON-данные для отправки
            String json = "{\"bom_code\":\"SM-S721BZKCCAU\", " +
                    "\"imei\":\"351231331232229\", " +
                    "\"external_order_id\":\"31965ca1-bec6-11ef-acc7-d9bb15126qqa\"," +
                    " \"price\":\"8000000\", " +
                    "\"recommended_retail_price\":\"10000000\", " +
                    "\"insurance_price\":\"2000000\"}";

            // Создаем POST-запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dev.smarta.lc/private-api/v1/order/retail/make-preorder"))
                    .header("X-Auth-Private-Id", "e8b225c9-6141-42d2-9a84-f0bdedd6cf15") // Указываем заголовок
                    .header("X-Auth-Private-Token", "7ff01fce-b98f-411c-9654-1749eab7d51b") // Указываем заголовок
                    .POST(HttpRequest.BodyPublishers.ofString(json)) // Указываем тело запроса
                    .build();
           // HttpRequest req = HttpRequest.newBuilder()
//                    .uri(URI.create("https://dev.smarta.lc/private-api/v1/order/retail/make-preorder")) // Замените на ваш URL
//                    .header()
            // Отправляем запрос и получаем ответ
            /* client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body) // Получаем тело ответа
                    .thenAccept(System.out::println) // Печатаем ответ
                    .join(); // Ждем завершения

             */
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body) // Получаем тело ответа
                    .thenAccept(responseBody -> {
                        /*
                        * Пока не работает обработка ответа. тк приходит в unicode, не получается конвертировать для печати ошибки содержимое
                        * */
                       // JSONObject jsonResponse = new JSONObject(responseBody);
                     /*  byte[] ResBYTES = null, rb = null, r = null;
                        try {
                            ResBYTES = responseBody.getBytes("UTF-16");
                            rb = responseBody.getBytes("UTF-8");
                            r = responseBody.getBytes("US-ASCII");
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }

                        // String ascii = new String(responseBody, StandardCharsets.);
                        for(byte a:ResBYTES)
                            System.out.print(a);
                        System.out.println();
                        for(byte a:ResBYTES)
                            System.out.print(a);
                        System.out.println();
                        for(byte a:ResBYTES)
                            System.out.print(a);
                        System.out.println();
                        //System.out.println(ascii);

                       // gSon
 */
                    })
                    .join();

            /*    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body) // Получаем тело ответа
                    .thenAccept(responseBody -> {
                        // Записываем ответ в файл
                        try {
                            Files.write(Paths.get("response.txt"), responseBody.getBytes(StandardCharsets.UTF_8));
                            System.out.println("Ответ записан в файл response.txt");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }) // Печатаем ответ
                    .join(); // Ждем завершения

             */
        }
}
