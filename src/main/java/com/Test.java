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

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public class Test {

    // Initialization of logger
    private static final Logger log = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {

        log.info("Test message!");

        Date date = new Date();
        int hour = date.getHours();
        log.info("Received current time: " + hour + " hours");

        String ave = getAve(hour);
        log.info("Received a greeting of the day: " + ave);

        //Locale currentLocale = new Locale("de");
        Locale currentLocale = Locale.getDefault();
        log.info("Received current location: " + currentLocale);

        ResourceBundle rb = ResourceBundle.getBundle("LabelsBundle", currentLocale);
        try {
            String st = rb.getString(ave);
            String s1 = new String(st.getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(s1);
            log.info("Successful withdrawal of greetings: " + s1);
        } catch (UnsupportedEncodingException e) {
            log.error("Show greeting failed!");
            e.printStackTrace();
        }
    }

    public static String getAve(int hour){
        String ave;
        if (hour>=6 && hour<9){
            ave = "ave.morning";
        } else if (hour>=9 && hour<19){
            ave = "ave.day";
        } else if (hour>=19 && hour<23){
            ave = "ave.evening";
        } else {
            ave = "ave.night";
        }
        return ave;
    }
}
