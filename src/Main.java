import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        File filename = new File("input.txt");
        System.out.println(readIntoString("input.txt"));

    }
    // написать метод, читающий текстовый файл в строку. Разделить строчки c помощью
    // line separator System.lineSeparator();
    // public static String readIntoString(String filename)
    public static String readIntoString(String filename) throws IOException {
        StringBuilder sb =new StringBuilder();

        try(BufferedReader br =new BufferedReader(new FileReader(filename))){
            String line;

            while((line=br.readLine())!=null){
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        }
        return new String(sb);
    }



}
