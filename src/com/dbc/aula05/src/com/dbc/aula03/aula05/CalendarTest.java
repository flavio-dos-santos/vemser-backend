package com.dbc.aula03.aula05;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();
//        System.out.println(calendario);
//
//        Calendar timeZone = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        System.out.println(timeZone.getTime());

        //FORMATAÇÂO

        DateFormat dataformatada = DateFormat.getDateInstance();
        System.out.println(dataformatada.format(calendario.getTime()));

        DateFormat formatar = DateFormat(DateFormat.FULL, brasil);
    }
}
