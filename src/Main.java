import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Address address1=new Address("Street1",1);
        Address address2=new Address("Street2",2);

        Person p1= new Person("Person1",16,address1);
        Person p2= new Person("Person2",45,address2);
        Person p3= new Person("Person3",45,address2);

        List<Person> persons = Arrays.asList(p1,p2,p3);
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
                .collect(Collectors.toList());
    }

    //2. Return list of names without duplicates ( write two variants)
    public static Set<String> withoutDuplicates(){
        Stream<String> streamOfNames = Stream.of("Ivan","Petr","Ivan","Semen","Petr");
        return streamOfNames.collect(Collectors.toSet());
    }

    public static List<String>withoutDuplicates1(){
        Stream<String> streamOfNames = Stream.of("Ivan","Petr","Ivan","Semen","Petr");
        return streamOfNames.distinct().collect(Collectors.toList());
    }


    //
    //3. There is class person with fields name and age.  Return map where age is a key and list of persons
    //a value public static Map<Integer>,List<Person>>mapByAge(List<Person> input)
    public static Map<Integer,List<Person>> mapByAge(List<Person> input){
        return input
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }



    //4 class Person has the field name and class BankAccount has fields IBAN and person. Return map
    // with Person as a key and list of his/her accounts as value

    //5. return list of IBANS from BankAccount class  with * after third symbol

    //6. method accepts a sentence ( the words in the sentence are separated with " " ) and returns number of
    // words starting with a certain letter public static long numberOfWords(String input, String w)

    //7.method accepts string and checks if the string is number

    //8.Class BankAccount has field String IBAN and class Person has fields name and List<BankAccount>. write
    // method which returns ibans with with numbers replaced with * after third symbol
    // public static  List<String> ibanWithStars(List<Person2>persons)

    //10. Class Person has fields name and age. Return total age of those older than 17
    //11. Class Person has fields name and age. Return names of those who are of legal age in Germane
    // (older than 17). Should be returned something like that: in Germany Ivan and Petr are of legal age



}
