import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> stringDates = new LinkedList<>();
        Collections.addAll(stringDates,"03 Jun 2015","08 Jul 2016","12 Dec 2013");
        System.out.println(getFormattedStrings(stringDates));

        List<LocalDate>dates=new LinkedList<>();
        Collections.addAll(dates,
                LocalDate.now(),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(18));
        System.out.println(daysInBetween(dates));
        // write your code here
        //    "20220422"

        String date ="20220422";
        LocalDate formatted= LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(formatted);
    }

    //1.используя  стримы и соответствующие методы для date and time  написать метод, принимающий лист
    // из нескольких дат типа LocalDate
    //и возвращающий количество дней между самой ранней и самой поздней датами
    // long daysInBetween(List<LocalDate> dates)
    public static long daysInBetween(List<LocalDate> dates){
        List<LocalDate>collect=dates.stream()
                .sorted()
                .collect(Collectors.toList());
        return ChronoUnit.DAYS.between(collect.get(0),collect.get(collect.size()-1));
    }



    //2. используя  стримы и соответствующие методы для date and time написать метод, принимающий лист стрингов
    // в формате "03 Jun 2015" и
    // возвращающий упорядоченный по возрастанию дат лист стрингов в формате "Wed, 03 Jun 2015".
    //метод должен сначала превратить эти строки в обьекты типа LocalDate, затем превратить эти обьекты
    // вновь в строки вида  "Wed, 03 Jun 2015"
// new Locale("en")

    public static List<String> getFormattedStrings(List<String>dates){
        return dates
                .stream()
                .map(Main::createLocalDateFromString)
                .sorted()
                .map(Main::createStringFromLocalDate)
                .collect(Collectors.toList());

    }
    private static LocalDate createLocalDateFromString(String s){
        return LocalDate.parse(s,DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }

    private static String createStringFromLocalDate(LocalDate d){
        return d.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy",new Locale("en")));
    }




    // есть класс Person с переменными String name and int salary. Написать коллектор, считающий суммарную зарплату
    // всех персон. Подсказка: создать также класс Box c переменной value куда эта зарплата будет "собираться"
    //Collector<>collector= Collector.of(
    //supp, accum,comb);
}
