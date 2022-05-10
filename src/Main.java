public class Main {


    public static void main(String[] args) {
        // 1.Дана строка состоящая из разного количества повторяющихся символов типа
        // "abbbcc"->bbb . Используя только методы класса String
        // найти длину максимальной подстроки повторяющихся символов

        //2. Написать метод, разворачивающий строку с использованием
        // рекурсии и выводящий ее на экран I always do my homework -> krowemah ym od syawla I
        //void reverseString (String str)
        String string="I always do my homework";
        reverseString(string);



        //3.Написать метод, перемножающий два целых числа без использования умножения,
        // деления, побитовых операций и циклов Подсказка с использованием рекурсии

        // 4. Написать метод, проверяющий равно ли число  сумме кубов его цифр. 123 = 1+2^3+ 3^3

        //5. Написать метод, проверяющий является ли число "аутоморфным". В математике аутоморфные это числа
        // квадрат  которых заканчивается теми же числами что и само число. Пример: 5^2=25, 6^2=36, 76^2=5776

        //6. пусть есть строка являющаяся двоичным числом например "0101". Написать метод,
        // превращающий ее в десятичное число. Можно использовать только методы класса String (length, charAt) и
        // методы Math

        //7.написать метод, меняющий местами значения  двух целых переменных без использования буфера
        //public void swapWithoutBuffer (int a, int b)
        // a=2 b=3 -> a=3 b=2
    }

    public int getLongestSubstringLength(String input){
        int count =1;
        int max =1;

        for(int i=0;i<input.length()-1;i++){
            if(input.substring(i,i+1).equals(input.substring(i+1,i+2))){
                count++;
            }else{
                count=1;
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }

    //2. Написать метод, разворачивающий строку с использованием
    // рекурсии и выводящий ее на экран I always do my homework -> krowemah ym od syawla I
    static void reverseString (String str){
        if((str==null)||(str.length()<=1))
            System.out.println(str);
        else{
            System.out.print(str.charAt(str.length()-1));
            reverseString(str.substring(0,str.length()-1));
        }
    }

    //3.Написать метод, перемножающий два целых числа без использования умножения,
    // деления, побитовых операций и циклов Подсказка с использованием рекурсии

    public int multiply(int a, int b){//2 3
        if(b==0)
            return 0;

        if(b>0)
            return (a+multiply(a,b-1)); // 2 2 ->

        if(b<0)
            return -multiply(a,-b);

        return -1;
    }

    // 4. Написать метод, проверяющий равно ли число  сумме кубов его цифр. 123 = 1+2^3+ 3^3
    public boolean isArmstrongNumber(int n){
        int remainder;
        int sum =0;
        int temp=n;

        while(n>0){
            remainder=n%10;
            sum=sum+(remainder*remainder*remainder);
            n=n/10;
        }
        return sum==temp;
    }

    //5. Написать метод, проверяющий является ли число "аутоморфным". В математике аутоморфные это числа
    // квадрат  которых заканчивается теми же числами что и само число. Пример: 5^2=25, 6^2=36, 76^2=5776
    public boolean isEndedSquare(int n){
        int sqN=n*n;
        String strN = Integer.toString(n);
        String square = Integer.toString(sqN);

        return square.endsWith(strN);
    }





}
