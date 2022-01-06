package com.example.webshop.service.SomeFunctions;

import com.example.webshop.model.Account;
import com.example.webshop.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ConvertWithComma {
    public static List<Integer> StringToList(String str) {

        //входные данные с бд str

        String[] strParse = str.split(";");
        List<Integer> stringToList = new ArrayList<>();
        for(String s: strParse){
            stringToList.add(Integer.parseInt(s));
        }
        return stringToList;
    }

    public static <T extends Model> String ListToString(List<T> models){
        StringBuilder listToString = new StringBuilder();
        for(T model : models){
            listToString.append(model.getId()+";");
        }
        return listToString.toString();
    }
}
