package com.example.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class WebShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
//        parseCartItems();
    }

    //проверка парсера строки корзины товаров
    public static List<Integer> parseCartItems() {
        //входные данные с бд корзины клиента
        String str = "12;23;43;45;56;7;;;";

        String[] strParse = str.split(";");
        List<Integer> items = new ArrayList<>();
        for(String s: strParse){
            items.add(Integer.parseInt(s));
        }
        return items;
    }
}
