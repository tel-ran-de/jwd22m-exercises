package lambdas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private Solution solution;
    String input;
    Predicate<String>predicate;
    Function<String,String>function;

    @BeforeEach
    public void init(){
        solution=new Solution();
        input= "aaa BBBB dEF cDkls bbb";
    }


    @Test
    public void test_empty(){
        input="";
        predicate= s->s.length()==3;
        function= String::toLowerCase;
        assertEquals(input,solution.transforming(input,predicate,function));
    }
    @Test
    public void test_3_lower_case(){
        predicate= s->s.length()==3;
        function= String::toLowerCase;
        assertEquals("aaa BBBB def cDkls bbb",solution.transforming(input,predicate,function));
    }

    @Test
    public void test_3_upper_case(){
        predicate= s->s.length()==3;
        function= String::toUpperCase;
        assertEquals("AAA BBBB DEF cDkls BBB",solution.transforming(input,predicate,function));
    }

    @Test
    public void test_4_lower_case(){
        predicate= s->s.length()==4;
        function= String::toLowerCase;
        assertEquals("aaa bbbb dEF cDkls bbb",solution.transforming(input,predicate,function));
    }

    @Test
    public void test_4_upper_case(){
        predicate= s->s.length()==4;
        function= String::toUpperCase;
        assertEquals("aaa BBBB dEF cDkls bbb",solution.transforming(input,predicate,function));
    }

    @Test
    public void test_5_stars(){
        predicate= s->s.length()==5;
        function= s->s="*****";
        assertEquals("aaa BBBB dEF ***** bbb",solution.transforming(input,predicate,function));
    }

    @Test
    public void test_no_changes(){
        input="aaa bbbbbbbbbbb";
        predicate= s->s.length()==4;
        function= String::toUpperCase;
        assertEquals(input,solution.transforming(input,predicate,function));
    }


}
