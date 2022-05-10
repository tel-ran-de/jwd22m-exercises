import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private Main m= new Main();

    @Test
    public void one_length(){
        String actual ="a";
        assertEquals(1,m.getLongestSubstringLength(actual));
    }


    @Test
    public void three_length(){
        String actual ="aabbbc";
        assertEquals(3,m.getLongestSubstringLength(actual));
    }

    @Test
    public void three_length_end(){
        String actual ="aacbbb";
        assertEquals(3,m.getLongestSubstringLength(actual));
    }
    @Test
    public void multiply_test_two_positive(){
        assertEquals(6,m.multiply(2,3));
    }

    @Test
    public void multiply_test_two_negative(){
        assertEquals(6,m.multiply(-2,-3));
    }

    @Test
    public void multiply_test_first_negative(){
        assertEquals(-6,m.multiply(-2,3));
    }

    @Test
    public void multiply_test_second_negative(){
        assertEquals(-6,m.multiply(2,-3));
    }

}
