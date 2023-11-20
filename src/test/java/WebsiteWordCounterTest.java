import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ch.unibas.dmi.dbis.WebsiteWordCounter;

public class WebsiteWordCounterTest {
    
    /**
     * This method should test the WebsiteWordCouner.test() method. 
     * We are now testing the WebsiteWordCounter.count() method es there is no WebsiteWordCounter.test() method.
     * 
     * Please implement it.
     */
    @Test
    public void testCount() {
        WebsiteWordCounter wwc = new WebsiteWordCounter();
        String[] tokens = new String[]{"hallo", "du", "du", "öhhhhhh"};
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("hallo", 1);
        testMap.put("du", 2);
        testMap.put("öhhhhhh", 1);
        assertEquals(testMap, wwc.count(tokens));
    }
}
