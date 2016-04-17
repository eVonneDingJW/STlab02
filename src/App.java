/**
 * Created by DingJingwen on 16/4/17.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static Map<String, String> read() throws FileNotFoundException {
        File file = new File("/Users/DingJingwen/Desktop/info.csv");

        Scanner scanner = new Scanner(file);
        Map<String, String> map = new HashMap<String, String>();
        String oneline;
        String[] words;
        while (scanner.hasNextLine()) {
            oneline = scanner.nextLine();
            words = oneline.split(",");
            map.put(words[0], words[1]);
        }
        scanner.close();
        return map;
    }
}