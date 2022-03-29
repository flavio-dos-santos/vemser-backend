package com.dbc.aula03.homeworkDatas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//                            EXERCICIO 1
//        System.out.println("Exercicio 1: Pedir para o usuario sua data de aniversairo, retornar quantos dias e meses faltam para o proximo aniversario!");
//        System.out.println("informe sua data de aniversário (exemplo = ano-mes-dia 0000-00-00!");
//        String aniversarioScanner = scanner.nextLine();
//        System.out.println("qual a sua idade?");
//        int idade = scanner.nextInt();
//        LocalDate now = LocalDate.now();
//        LocalDate dataInicial = now;
//        LocalDate dataFinal = LocalDate.parse(aniversarioScanner).plusYears(idade+1);
//        Period proximoAniversairo = Period.between(dataInicial,dataFinal);
//        System.out.println(proximoAniversairo);




//                              EXERCICIO 02
//        System.out.println("------------------------------------------------------------------------------------");
//        System.out.println("exerciico 2: Informar duas datas e comparar a diferença entre elas, ano, mês e dias!");
//        LocalDate initialDate = LocalDate.parse("2007-05-10");
//        LocalDate finalDate = initialDate.plus(Period.ofMonths(5));
//        finalDate = finalDate.plus(Period.ofDays(25));
//        finalDate = finalDate.plus(Period.ofYears(10));
//        Period between = Period.between(initialDate, finalDate);
//        System.out.println(between);





//                                EXERCICIO 03
//        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
//        System.out.println("------------------------------------------------------------------------------------");
//        System.out.println("exerciico 3: Contruir um relogio Global, horarios do Brasil, Australia, Japão, Russia,Dubai e EUA!");
//        ZoneId zoneIdBrasil = ZoneId.of("America/Bahia");
//        ZonedDateTime BrasilDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneIdBrasil);
//        ZoneId zoneIdAustralia = ZoneId.of("Australia/ACT");
//        ZonedDateTime AustraliaDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneIdAustralia);
//        ZoneId zoneIdJapan = ZoneId.of("Japan");
//        ZonedDateTime JapanDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneIdJapan);
//        ZoneId zoneIdEurope = ZoneId.of("Europe/Moscow");
//        ZonedDateTime EuropeDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneIdEurope);
//        ZoneId zoneIdDubai = ZoneId.of("Asia/Dubai");
//        ZonedDateTime DubaiDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneIdDubai);
//        ZoneId zoneIdChicago = ZoneId.of("America/Chicago");
//        ZonedDateTime ChicagoDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneIdChicago);
//        System.out.println(BrasilDateTime+"\n"+AustraliaDateTime+"\n"+JapanDateTime+"\n"+EuropeDateTime+"\n"+DubaiDateTime+"\n"+ChicagoDateTime);






//                                      EXERCICIO 4

//              LocalDateTime localDateTime = LocalDateTime.now();
//              LocalDateTime exercicio = localDateTime.plusDays(15).plusHours(10);
//              String diaDaSemana = exercicio.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
//              int diaDoAno = exercicio.getDayOfYear();
//                System.out.println(diaDaSemana+"\n"+diaDoAno);




//      todo  System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
//      todo  System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

//                                    EXERCICIO  O5




//        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.APRIL, 25, 6, 30);
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
//                .withLocale(new Locale("pt","BR"))));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
//                .withLocale(new Locale("in","EUA"))));
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
//                .withLocale(new Locale("fr","FR"))));

//                                        EXERCICIO 06



//        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Brazil/East"));
//        ZonedDateTime zonedDateTime2 = LocalDateTime.of(2024,9,14,18,30,00).atZone(ZoneId.of("Europe/London"));
//
//        int diffHorario = zonedDateTime2.getOffset().getTotalSeconds() - zonedDateTime1.getOffset().getTotalSeconds();
//        Period period = Period.between(zonedDateTime1.toLocalDate(), zonedDateTime2.toLocalDate());
//        Duration duration = Duration.between(zonedDateTime2.minusSeconds(diffHorario).toLocalTime(),zonedDateTime1.toLocalTime());
//        long hours = duration.abs().toHours();
//        long minutes = duration.abs().toMinutes()%60;
//        long seconds = duration.abs().toSeconds()%60;
//        System.out.println(period+"\n"+hours+" HORAS\n"+minutes+" MINUTOS\n"+seconds+" SEGUNDOS\n");


//        LocalDateTime dataInicial = LocalDateTime.now();
//        LocalDateTime dataFinal = LocalDateTime.parse("2024-09-14T22:30:15");
//        long teste1 = ChronoUnit.SECONDS.between(dataInicial, dataFinal);
//        long result1 = teste1/60;
//        long teste2 = ChronoUnit.MINUTES.between(dataInicial, dataFinal);
//        long result2 = teste2/60;
//        long teste3 = ChronoUnit.HOURS.between(dataInicial, dataFinal);
//        System.out.println(teste1+"\n"+teste2+"\n"+teste3);


//        LocalDateTime horaInicial = LocalDateTime.now();
//        LocalDateTime dataFinal = LocalDateTime.parse("2024-09-14T14:30:15");
//        LocalDateTime periodo = LocalDateTime.from(horaInicial);
//
//        long anos = periodo.until(dataFinal, ChronoUnit.YEARS);
//        periodo = periodo.plusYears(anos);
//        long meses = periodo.until(dataFinal, ChronoUnit.MONTHS);
//        periodo = periodo.plusMonths(meses);
//        long dias = periodo.until(dataFinal, ChronoUnit.DAYS);
//        periodo = periodo.plusDays(dias);
//        long horas = periodo.until(dataFinal, ChronoUnit.HOURS);
//        periodo = periodo.plusHours(horas);
//        long minutos = periodo.until(dataFinal, ChronoUnit.MINUTES);
//        periodo = periodo.plusMinutes(minutos);
//        long segundos = periodo.until(dataFinal, ChronoUnit.SECONDS);
//        periodo = periodo.plusSeconds(segundos);
//        System.out.println(periodo);




//        Period period = getPeriod(fromDateTime, toDateTime);
//        long time[] = getTime(fromDateTime, toDateTime);
//
//        System.out.println(period.getYears() + " years " +
//                period.getMonths() + " months " +
//                period.getDays() + " days " +
//                time[0] + " hours " +
//                time[1] + " minutes " +
//                time[2] + " seconds.");

    }
}
