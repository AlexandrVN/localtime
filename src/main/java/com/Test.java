/*
Написать консольное приложение на java, с использованием maven.
Приложение должно выводить на экран приветственное сообщение, в зависимости от текущего
времени суток.
Good morning, World! в 06:00 - 09:00
Good day, World! в 09:00 - 19:00
Good evening, World! в 19:00 - 23:00
Good night, World! в 23:00 - 06:00
Код должен содержать все возможные юнит-тесты и создавать читабельный лог файл.
Выводящиеся на консоль сообщения должны быть получены из message resource и зависеть от
системной локали пользователя. Сделать перевод на русский язык.
 */
package com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    //private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH");


    public static void main(String[] args) {

        System.out.println(Locale.getDefault());

        Locale current = Locale.getDefault();
        Locale myLocale = new Locale("ru", "UA");

        Locale currentLocale = new Locale("by");
        ResourceBundle rb = ResourceBundle.getBundle("LabelsBundle", currentLocale);

        String st = rb.getString("h1");

        System.out.println(st);

        //LocalDateTime now = LocalDateTime.now();

        //String hour = DATE_TIME_FORMATTER.format(now);
        //System.out.println(now);
        //System.out.println(DATE_TIME_FORMATTER.format(now));

        /*
        1 - morning
        2 - day
        3 - evening
        4 - night
         */

        Date date = new Date();
        int hour = date.getHours();
        String message;

        switch (hour){
            case 6:
            case 7:
            case 8:
                message = "Good morning, World!";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                message = "Good day, World!";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                message = "Good evening, World!";
                break;
            default:
                message = "Good night, World!";
                break;
        }

        System.out.println(message);


    }
}
