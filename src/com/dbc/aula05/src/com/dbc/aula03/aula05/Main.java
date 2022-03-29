package com.dbc.aula03.aula05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Date minhaData = new Date(1995-1900, 11, 30,10,15);
        System.out.println(minhaData);

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner= new Scanner(System.in);
        System.out.println("coloque uma data no formato (Dia/Mês/ano, exemplo = 00/00/0000");
        String dataInformada = scanner.nextLine();
        Date teste = dt.parse(dataInformada);
        System.out.println(teste);
        System.out.println(dt.format(teste));

    }

}
