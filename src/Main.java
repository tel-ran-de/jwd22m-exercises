import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //1.Написать метод, который принимает список имен и их анаграмм и имя, по которому
        // он выдает список всех его анаграмм, включая само имя. Все буквы маленькие
        // {ivan, maria,petr, vani,amria,navi} ivan -> vani,ivan,navi
        // 2.с использованием множеств написать метод, который вернет лист без повторяю
        //щихся элементов List<String> removeDuplicates(List<String> input)
        // {"Ivan", "Maria","Piotr","Anna","Maria","Ivan"}->{Ivan, Maria,Piotr,Anna}
        //3.с использованием множеств написать метод, который вернет повторяющиеся
        // элементы из данного листа
        //List<String> getDuplicates(List<String> input)
        // {"Ivan", "Maria","Piotr","Anna","Maria","Ivan"}->{Ivan, Maria}
        //в задачах 2 и 3 все имена во входящем списке написаны с большой буквы

        //{ivan, maria,petr, vani,amria,navi}

        //
        // ainv: {ivan,navi,vani}
        // eptr: {

    }
    public List<String> anagramsList(String str, List<String>strings){
        Map<String,List<String>> anagrams=new HashMap<>();

        for(String s:strings){
            String sortedKey=sortAnagram(s);
            if(anagrams.containsKey(sortedKey)){
                List<String>value=anagrams.get(sortedKey);
                value.add(s);
                anagrams.put(sortedKey,value);
            }
            else{
                List<String>value=new ArrayList<>();
                value.add(s);
                anagrams.put(sortedKey,value);
            }
        }
        return anagrams.get(sortAnagram(str));
    }

    private String sortAnagram(String str) {
        char[]chars=str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // 2.с использованием множеств написать метод, который вернет лист без повторяю
    //щихся элементов List<String> removeDuplicates(List<String> input)
    // {"Ivan", "Maria","Piotr","Anna","Maria","Ivan"}->{Ivan, Maria,Piotr,Anna}

    List<String> removeDuplicates(List<String> input){
        Set<String>set=new HashSet<>(input);
        return new ArrayList<>(set);
    }

    //3.с использованием множеств написать метод, который вернет повторяющиеся
    // элементы из данного листа
    //List<String> getDuplicates(List<String> input)
    // {"Ivan", "Maria","Piotr","Anna","Maria","Ivan"}->{Ivan, Maria}
    //в задачах 2 и 3 все имена во входящем списке написаны с большой буквы

    List<String> getDuplicates(List<String> input){
        Set<String>set=new HashSet<>();
        List<String>duplicates = new ArrayList<>();

        for(String s: input){
            if(!set.add(s)&& !duplicates.contains(s)) duplicates.add(s);
        }
        return duplicates;
    }



}
