package lambdas;

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
        StringConcate stringConcate = (a, b)->Integer.toString(a)+b;
        System.out.println(stringConcate.concat(10,20));
        //2.если длина строки =3 вернуть true иначе false
        Checkable str= s->s.length()==3?true:false;
        System.out.println(str.check("abc"));
        System.out.println(str.check("abcd"));
        //3. если длина строки четная вернуть true  иначе  false
        //4. вернуть строку в верхнем регистре
        //5. если длина строки =4, вернуть четыре *  иначе вернуть строку без изменений
        //6. распечатать строку  в  виде !строка!
        //7. напечатать Hello world



        int sum=0;
        int a=2;

        sum=sum+(a%2==0?a:0);
    }
}
