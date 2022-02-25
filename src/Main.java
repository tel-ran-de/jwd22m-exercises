import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        listToListModifiedFile("inputPersons2.txt","outputPersons2.txt");
        Person person1 =new Person("Petr",40);
        Person person2 =new Person("Ivan",43);
        Person person3 =new Person("Vasiliy",4);
        List<Person>persons= Arrays.asList(person1,person2,person3);
        writeToFile("outputPerson.txt",persons);


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
    //4. Записать в файл обьекты класса Person (name, age) в таком виде: name, age.
    //"Petr", 35
    // Semen, 3
    // Petr, 35
    //public static void writeToFile(String fileName, List<Person>persons)
    public static void writeToFile(String filename, List<Person>persons){
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename,true));
            BufferedWriter bw1=new BufferedWriter(new OutputStreamWriter(System.out))){
            for(Person person:persons){
                bw.write("\""+person.name+ "\""+","+person.age);
                bw1.write("\""+person.name+ "\""+","+person.age);
                bw.newLine();
                bw1.newLine();
            }

        }catch (IOException e){e.printStackTrace();}
    }

    //5.есть файл содержащий строки такого вида name,surname,equipment,price. Например:
    // Evgeny,Grazhdanskiy,Notebook,500.  Имена и фамилии могут повторяться. Создать новый файл
    // содержащий строки вида : name, sum , где name  это имя и фамилия из входящео файла, а sum
    // это сумма цен товаров по этому человеку.
    // например входящие записи  Petr,Ivanov,TVSet, 500
    //                           Petr,Ivanov,Computer,200
    // на выходе Petr Ivanov, 700
    // Evgeny Grazhdansky 500
    // public static void listToListModifiedFile (String inFile, String outFile)

    public static void listToListModifiedFile (String inFile, String outFile){
        try(BufferedReader br= new BufferedReader(new FileReader(inFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile,false))){
            String line;
            Map<String,Integer> result =new HashMap<>();
            while((line=br.readLine())!=null){
                System.out.println(line);
                String[] entry = line.split(",");
                String name= entry[0].trim().concat(" ").concat(entry[1].trim());
                int price = Integer.parseInt(entry[3].trim());
                if(result.containsKey(name))
                    result.put(name,price+result.get(name));
                else result.put(name,price);
            }

            for(Map.Entry<String,Integer>me:result.entrySet()){
                bw.write(me.getKey()+" "+me.getValue());
                bw.newLine();
            }

        } catch (IOException e){e.printStackTrace();}
    }
}
