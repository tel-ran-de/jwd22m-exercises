package lambdas;

import java.awt.image.ImageProducer;
import java.util.function.*;

public class Solution {
    //1.конкатинировать int a b  ->ab

    //2.если длина строки =3 вернуть true иначе false
    //3. если длина строки четная вернуть true  иначе  false
    //4. вернуть строку в верхнем регистре
    //5. если длина строки =4, вернуть четыре *  иначе вернуть строку без изменений
    //6. распечатать строку  в  виде !строка!
    //7. напечатать Hello world

    public static void main(String[] args) {
        //1.конкатинировать int a b  ->ab
        StringConcate stringConcate = (a,b)->Integer.toString(a)+b;
        System.out.println(stringConcate.concat(10,20));

        BiFunction<Integer,Integer,String>stringConcate1=(a,b)->Integer.toString(a)+b;
        System.out.println(stringConcate1.apply(10,24));

        //2.если длина строки =3 вернуть true иначе false
        Checkable str= s->s.length()==3;
        System.out.println(str.check("abc"));
        System.out.println(str.check("abcd"));
        Predicate<String>stringPredicate=s->s.length()==3;
        System.out.println(stringPredicate.test("abc"));
        System.out.println(stringPredicate.test("abcd"));

        //3. если длина строки четная вернуть true  иначе  false
        System.out.println("+++++++++++++++++");
        Checkable str1=s->s.length()%2==0;
        System.out.println(str1.check("abc"));
        System.out.println(str1.check("abcd"));
        Predicate<String>stringPredicate1=s->s.length()%2==0;
        System.out.println(stringPredicate1.test("abc"));
        System.out.println(stringPredicate1.test("abcd"));

        //4. вернуть строку в верхнем регистре
        Transformable str2=s->s.toUpperCase();
        System.out.println(str2.modify("abCdE"));
        Function<String,String>stringFunction=s->s.toUpperCase();
        System.out.println(stringFunction.apply("abCdE"));

        //5. если длина строки =4, вернуть четыре *  иначе вернуть строку без изменений
        Transformable str3= s->s.length()==4?s="****":s;
        System.out.println(str3.modify("ab"));
        System.out.println(str3.modify("abcd"));
        Function<String,String>stringFunction1=s->s.length()==4?s="****":s;
        System.out.println(stringFunction1.apply("ab"));
        System.out.println(stringFunction1.apply("abcd"));

        //6. распечатать строку  в  виде !строка!
        Printable str4=s-> System.out.println("!"+s+"!");
        str4.print("abc");
        Consumer<String>stringConsumer=s-> System.out.println("!"+s+"!");
        stringConsumer.accept("abc");

        //7. напечатать Hello world
        Producable str5=()->"Hello World";
        System.out.println(str5.produce());
        Supplier<String> strSupplier=()->"Hello World";
        System.out.println(strSupplier.get());


//public String transforming(String input, Predicate<String>predicate,Function<String,String>function){}

// Написать метод, принимающий строку, содержащую слова разделенные пробелом и два
// функциональных интерфейса - function and predicate. Метод должен предоставлять
// возможность реализации следующих лямбда выражений
// 1. При длине слова=3 изменить все буквы этого слова на строчные и вернуть изме
//    ненную строку
// 2. При длине слова=3 изменить все буквы этого слова на заглавные и вернуть изме
//    ненную строку
// 3. При длине слова=4 изменить все буквы этого слова на строчные и вернуть изме
////    ненную строку
//4. При длине слова=4 изменить все буквы этого слова на заглавные и вернуть изме
////    ненную строку
        //5. При длине слова=5 изменить все буквы этого слова на звездочки(*****) и вернуть изме
        //////    ненную строку








        /**
         * Есть класс Address c полями улица и номер дома и класс Person  с полями имя, возраст
         * и address. Написать метод, возвращающий адреса людей старше 17 лет
         public List<Address>addressOlder17(List<PersonOlder17> input)*/



    }

    public String transforming(String input, Predicate<String>predicate,Function<String,String>function){
        String[] words = input.split(" ");
        for(int i=0;i<words.length;i++){
            if(predicate.test(words[i])){
                words[i]=function.apply(words[i]);
            }
        }
        return String.join(" ",words);
    }
  /*  public List<Address>addressOlder17(List<PersonOlder17> input)
        return input
            .stream()
            .filter(p->p.getAge()>17
            .map()
            .collect(Collectors.toList())
            )*/

}
