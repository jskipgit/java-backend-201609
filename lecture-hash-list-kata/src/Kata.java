import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Created by jasonskipper on 10/25/16.
 */
public class Kata {

    public static void main(String[] args){

        // howToUserPropFile(args);
        HashMap<String, List<String>> dictionary = new HashMap<>();
        String[] data = {"apple", "abc", "boy", "beachball", "code"};

        for(String tmp: data){
            // get first char
            String firstChar = tmp.substring(0,1);
            // check to see if its already in list
            List<String> wordList = null;
            wordList = dictionary.get(firstChar);

            if(wordList == null) {
                // create list
                wordList = new ArrayList<>();
            }
            // add our word to list
            wordList.add(tmp);

            // put in hashmap
            dictionary.put(firstChar, wordList);
        }
        System.out.println(dictionary);


    }


    private static void howToUserPropFile(String[] args) {
        if(args.length != 1){
            System.out.println("Usage \"java Kata <prop_file_name>\"");
            System.exit(0);
        }

        try {

            FileInputStream input = new FileInputStream(args[0]);

            // load a properties file
            Properties prop = new Properties();
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("ip"));
            System.out.println(prop.getProperty("folder"));
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
