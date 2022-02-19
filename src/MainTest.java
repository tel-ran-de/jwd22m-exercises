import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    Main main =new Main();
    List<String>actual;

    @BeforeEach
    public void init(){
        actual=new ArrayList<>();
        actual.add("aram");
        actual.add("vani");
        actual.add("vian");
        actual.add("mara");
        actual.add("ivan");
        actual.add("semen");

    }
    @Test
    public void ivan_anagram_test(){
        List<String>expected=new ArrayList<>();
        expected.add("vani");
        expected.add("vian");
        expected.add("ivan");

        assertEquals(expected,main.anagramsList("ivan",actual));

    }

    @Test
    public void no_such_anagram_test(){
        assertEquals(null,main.anagramsList("rob",actual));

    }

    @Test
    public void one_name_test(){
        List<String>expected=new ArrayList<>();
        expected.add("semen");


        assertEquals(expected,main.anagramsList("semen",actual));

    }

    public void removeDuplicates_test_one_element(){
        List<String>actual= Arrays.asList("Ivan");
        List<String>expected= Arrays.asList("Ivan");

        assertEquals(actual,main.removeDuplicates(expected));
    }

    public void removeDuplicates_test_no_duplicates(){
        List<String>actual= Arrays.asList("Ivan","Pyotr","Maria","Anna");
        List<String>expected= Arrays.asList("Ivan","Pyotr","Maria","Anna");


        assertEquals(actual,main.removeDuplicates(expected));
    }

    public void removeDuplicates_test_duplicates(){
        List<String>actual= Arrays.asList("Ivan","Maria","Pyotr","Anna","Maria","Ivan");
        List<String>expected= Arrays.asList("Ivan","Maria","Pyotr","Anna");


        assertEquals(expected,main.removeDuplicates(actual));
    }
    @Test
    public void getDuplicates_test_one_element(){
        List<String> actual= Arrays.asList("Ivan");
        List<String> expected= Arrays.asList();
        assertEquals(expected,main.getDuplicates(actual));
    }

    @Test
    public void getDuplicates_test_no_duplicates(){
        List<String> actual= Arrays.asList("Ivan","Pyotr","Maria", "Anna");
        List<String> expected= Arrays.asList();
        assertEquals(expected,main.getDuplicates(actual));
    }

    @Test
    public void getDuplicates_test_two_duplicates(){
        List<String> actual= Arrays.asList("Ivan","Maria","Pyotr","Anna","Maria","Ivan");
        List<String> expected= Arrays.asList("Maria","Ivan");
        assertEquals(expected,main.getDuplicates(actual));
    }

    @Test
    public void getDuplicates_test_two_ivans_three_marias(){
        List<String> actual= Arrays.asList("Ivan","Maria","Pyotr","Anna","Maria","Ivan","Maria","Ivan");
        List<String> expected= Arrays.asList("Maria","Ivan");
        assertEquals(expected,main.getDuplicates(actual));
    }

}
