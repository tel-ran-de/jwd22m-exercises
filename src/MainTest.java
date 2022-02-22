import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public  void  testSum(){
        assertEquals(15, Main.returnSum("inputInt.txt"));
    }

    @Test
    public  void  testLongest() throws IOException {
        assertEquals("bbbbbb", Main.findLongestLine(new File("inputlongest.txt")));
    }
}
