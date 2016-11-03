import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/12/16.
 */
public class ScrapTest {

    public static void main(String[] args){
        // lets play with lists
        List<String> myList = new ArrayList();

        myList.add("Sat.");
        myList.add("Sun.");
        myList.add("Mon.");
        myList.add("Tues.");

        // traditional for loop
        for(int i = 0; i<myList.size(); i++){
            String tmp = myList.get(i);
            System.out.println(tmp);
        }

        // for each
        for(String tmp:myList){
            System.out.println(tmp);
        }

    }
}
