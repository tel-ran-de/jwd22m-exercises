import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println(returnSum("inputInt.txt"));
        File file =new File("inputLongest.txt");
        System.out.println(findLongestLine(file));
        //1 есть текстовый файл
        //1
        //2
        //3
        //4
        //5
        //прочитать его и вернуть сумму всех чисел
        //2. написать метод, возвращающий самую длинную строкув текстовом файле
        //aa
        //bbbbb
        //cc

        //3.есть текстовый файл содержащий имена и возраст людей в каждой строке,такого вида:
        // Petr, 35
        // Semen, 3
        // Petr, 35
        //написать метод, возвращающий список людей (имена и возраст) старше 18 лет,
        // отсортированный по возрасту
        //public List<Person> composeList(String fileName)

        //4. Записать в файл обьекты класса Person (name, age) в таком виде: name, age.
        //"Petr", 35
        // Semen, 3
        // Petr, 35
        //public static void writeToFile(String fileName, List<Person>persons)

        //5.есть файл содержащий строки такого вида name,surname,equipment,price. Например:
        // Evgeny,Grazhdanskiy,Notebook,500.  Имена и фамилии могут повторяться. Создать новый файл
        // содержащий строки вида : name, sum , где name  это имя и фамилия из входящео файла, а sum
        // это сумма цен товаров по этому человеку.
        // например входящие записи  Petr,Ivanov,TVSet, 500
        //                           Petr,Ivanov,Computer,200
        // на выходе Petr Ivanov, 700
        // public static void listToListModifiedFile (String inFile, String outFile)
    }
    //1 есть текстовый файл
    //1
    //2
    //3
    //4
    //5
    //прочитать его и вернуть сумму всех чисел

    public static int returnSum (String fileName){
        int sum=0;
        String lineInt;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while ((lineInt=br.readLine())!=null){
                sum=sum+Integer.parseInt(lineInt);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return sum;
    }

    //2. написать метод, возвращающий самую длинную строкув текстовом файле
    //aa
    //bbbbb
    //cc

    public static String findLongestLine(File filename)throws IOException{
        String longest="";

        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            String current;

            while ((current=br.readLine())!=null){
                if(current.length()>longest.length())
                    longest=current;
            }
        }
        return longest;
    }

    //3.есть текстовый файл содержащий имена и возраст людей в каждой строке,такого вида:
    // Petr, 35
    // Semen, 3
    // Petr, 35
    //написать метод, возвращающий список людей (имена и возраст) старше 18 лет,
    // отсортированный по возрасту
    //public List<Person> composeList(String fileName)

    public List<Person> composeList(String fileName){
        List<Person> persons = new ArrayList<>();
        List<String>temp =new ArrayList<>();

        try( BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line=bufferedReader.readLine())!=null){
                temp.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        for (String s: temp){
            String[] nameAge=s.split(",");
            int age = Integer.parseInt(nameAge[1].trim());
            if(age>18)
                persons.add(new Person(nameAge[0].trim(),age));
        }
        Collections.sort(persons);
        return persons;

    }
}
