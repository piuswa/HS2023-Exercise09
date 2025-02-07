package ch.unibas.dmi.dbis;

import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class, containing application's entry point.
 */
public class Main {

    public static final Logger LOGGER = LogManager.getLogger(WebsiteWordCounter.class.getName());
    /**
     * Application's entry point; scans for user input.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        final WebsiteWordCounter loader = new WebsiteWordCounter();
        try (final Scanner scanner = new Scanner(System.in)) {
            while (true) {
                /* Prompt user for input. */
                System.out.print("Enter a URL to a valid website: ");
                String input = scanner.nextLine();

                /* Check if the user wants to quit (e.g., by typing "quit" or "exit") */
                if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                    System.out.println("Good bye!");
                    break;
                }

                /* Count the number of words on the website. */
                final List<Pair<String,Integer>> count;
                try {
                    count = loader.topKWordsOnWebsite(input, 10);
                } catch (Exception e){
                    System.out.println("This is not a valid URL, please try again. (It has to have https:// at the front.)");
                    LOGGER.error(e.getMessage());
                    continue;
                }
                System.out.println("Here are your top " + count.size() + " entries for" + input + ":");
                for (Pair<String,Integer> entry : count) {
                    System.out.println(entry.getLeft() + ": " + entry.getRight());
                }
            }
        }
    }
}