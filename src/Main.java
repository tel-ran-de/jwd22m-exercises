import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        String str= "1459032";//true

        String str1="adf45";//false

        System.out.println(isDig(str));
        System.out.println(isDig(str1));


        Address address1=new Address("Street1",1);
        Address address2=new Address("Street2",2);

        Person p1= new Person("Person1",16,address1);
        Person p2= new Person("Person2",45,address2);
        Person p3= new Person("Person3",45,address2);

        List<Person>persons = Arrays.asList(p1,p2,p3);
        System.out.println(addressesOlder17(persons));

        System.out.println(withoutDuplicates());
        System.out.println(withoutDuplicates1());

        System.out.println(mapByAge(persons));


        // write your code here
    }

    // есть класс Адрес с полями улица и номер дома и есть класс Персон с полями
    // имя, возраст, адрес. написать метод, возвращающий адреса тех кто старще 17 лет

    public static List<Address>addressesOlder17(List<Person>input){
        return input
                .stream()
                .filter(p->p.getAge()>17)
                .map(Person::getAddress)
                .collect(toList());
    }

    //2. Return list of names without duplicates ( write two variants)
    public static Set<String>withoutDuplicates(){
        Stream<String> streamOfNames = Stream.of("Ivan","Petr","Ivan","Semen","Petr");
        return streamOfNames.collect(Collectors.toSet());
    }

    public static List<String>withoutDuplicates1(){
        Stream<String> streamOfNames = Stream.of("Ivan","Petr","Ivan","Semen","Petr");
        return streamOfNames.distinct().collect(toList());
    }


    //
    //3. There is class person with fields name and age.  Return map where age is a key and list of persons
    //a value public static Map<Integer>,List<Person>>mapByAge(List<Person> input)
    public static Map<Integer,List<Person>>mapByAge(List<Person> input){
        return input
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }



    //4 class Person has the field name and class BankAccount has fields IBAN and person. Return map
    // with Person as a key and list of his/her accounts as value
    public static  Map<Person1,List<BankAccount>>mapPersonbyAccounts(List<BankAccount>input){
        return input
                .stream()
                .collect(Collectors.groupingBy(BankAccount::getOwner));
    }

    //5. return list of IBANS from BankAccount class  with * after third symbol
    public static List<String>getListIbannsWithStars(List<BankAccount>input){
        return input
                .stream()
                .map(a->replaceWithStars(a.getIBAN()))
                .collect(toList());
    }
    private static String replaceWithStars(String input){
        char[]chars=input.toCharArray();
        for(int i=3;i<input.length();i++)
            chars[i]='*';
        return new String(chars);
    }

    //6. method accepts a sentence ( the words in the sentence are separated with " " ) and returns number of
    // words starting with a certain letter public static long numberOfWords(String input, String w)
    public static long numberOfWords(String input,String w){
        return  Stream.of(input.split(" "))
                .filter(s->s.startsWith(w))
                .count();

    }

    //7.method accepts string and checks if the string is number
    public static boolean isDig(String input){
        return input
                .chars()
                .allMatch(Character::isDigit);

    }

    //8.Class BankAccount has field String IBAN and class Person has fields name and List<BankAccount>. write
    // method which returns ibans with with numbers replaced with * after third symbol
    public static  List<String> ibanWithStars(List<Person2>persons){
        return persons
                .stream()
                .flatMap(ba->ba.getBankAccounts().stream())
                .map(ib->ib.getIBAN())
                .map(iba->replaceWithStars(iba))
                .collect(toList());
    }


    //10. Class Person has fields name and age. Return total age of those older than 17
    public static int ageAll(List<Person>input){
        return input
                .stream()
                .filter(s->s.getAge()>17)
                .map(Person::getAge)
                .reduce(0,Integer::sum);
    }
    public static int ageAll2(List<Person>input){
        return input
                .stream()
                .filter(s->s.getAge()>17)
                .mapToInt(Person::getAge)
                .sum();
    }




    //11. Class Person has fields name and age. Return names of those who are of legal age in Germane
    // (older than 17). Should be returned something like that: in Germany Ivan and Petr are of legal age

    public static String legalAge(List<Person>input){
        return input
                .stream()
                .filter(s->s.getAge()>17)
                .map(Person::getName)
                .collect(Collectors.joining(" and ","in Germany"," are of legal age."));
    }

    // 1. collect Stream elemants (strings) to List and then convert the result into  Set
    public static Set<String> convertToSet(List<String> list){
        return list.stream()
                .collect(Collectors.collectingAndThen(toList(), Set::copyOf));
    }
//    2. Given list of names (strings), join the names into the following string:
//    Students:name1,name2,name3 study java
    //3. using collector only, count number of elements in the list
    //4. write a method returning max elt in integer list
    //5. write a method returning min elt in integer list
    //6.write a method which groups elements of a given string list by string length and stores the grouping
    // results in a Set. Method returns Map
    //7.write a method which groups elemants of a given string list by string length>4 and returns map
    // where keys are true false and lists of respective elements are values

}
