import com.example.SortUniqueWords;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SortUniqueWordsTest {
    @Test
    public void countOccurenceUnitTest() {
        String input = "This is a test example.... A short example of a valid input.";

        List<Map.Entry<String, Integer>> sortedList = new SortUniqueWords().printOccurencesOfWordsInString(input);

        assertEquals(sortedList.get(0).getKey(), "a");
        assertEquals(sortedList.get(1).getKey(), "example");
        assertEquals(sortedList.get(2).getKey(), "input");
        assertEquals(sortedList.get(3).getKey(), "is");
        assertEquals(sortedList.get(4).getKey(), "of");
        assertEquals(sortedList.get(5).getKey(), "short");
        assertEquals(sortedList.get(6).getKey(), "test");
        assertEquals(sortedList.get(7).getKey(), "this");
        assertEquals(sortedList.get(8).getKey(), "valid");


    }
}
