package com.ada.cotacao.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {
    public static LocalDateTime formatDateTime(String date) {
        date = date.replace(" ", "T");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            return LocalDateTime.parse(date, formatter);
        } catch(DateTimeParseException e) {
            System.err.println("Data inserida possui formato inválido. Formato aceito: DD/MM/AAAA");

        }
        return  null;
    }
}
