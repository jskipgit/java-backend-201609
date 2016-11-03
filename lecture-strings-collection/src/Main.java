import java.util.*;

/**
 * Created by jasonskipper on 10/18/16.
 */
public class Main {

    public static void main(String[] args) {
        playWithLoops();
    }

    public static void playWithLoops(){
        List<Person> myStringList = new ArrayList<Person>();

        myStringList.add(new Person("jason",40,"skiper.jason@w.com"));
        myStringList.add(new Person("amy",40,"amy@w.com"));
        myStringList.add(new Person("mike",40,"mike@w.com"));

        // iteration
        Iterator<Person> it = myStringList.iterator();
        while(it.hasNext()){
            Person gotOne = it.next();
            System.out.println(gotOne);
        }

        // all the ways
        System.out.println("Traditional 4 loop");

        for(int i=0; i<myStringList.size(); i++){
            System.out.println(myStringList.get(i));
        }
        System.out.println("");

        System.out.println("Newer 4 each");
        for(Person tmp: myStringList){
            System.out.println(tmp);

        }
        System.out.println("");

        System.out.println("Even Newer way");
        myStringList.forEach(tmp -> {
            // save to database
            System.out.println(tmp.getEmail());
        });

        // hash
        Person p1 = new Person("jason",40,"skiper.jason@w.com");
        Person p2 = new Person("kim",40,"skiper.kim@w.com");
        Person p3 = new Person("tc",8,"skiper.tc@w.com");

        HashMap<String, Person> map = new HashMap<>();
        map.put(p1.getName(), p1);
        map.put(p2.getName(), p2);
        map.put(p3.getName(), p3);

        System.out.println(map);

        String ask = "jason";
        Person found = map.get(ask);
        System.out.println(found);

        // traditional
        Set<String> keys = map.keySet();
        for(String aKey: keys){
            System.out.println(map.get(aKey));
        }

        System.out.println("\nCool new foreach on map!!");

        map.forEach((key,value)->{
           System.out.println("Key:"+key);
            System.out.println(" Value:"+value);
        });

    }

    public static void playWithStringBuilder() {
        String result = "skipper.jason@hotmail.com";
        StringBuilder sb  = new StringBuilder();
        sb.append(result);
        sb.reverse().reverse();
        String x = sb.toString();

        System.out.println(x);

    }

    public static void playWithIndexOf() {
        String result = "skipper.jason@hotmail.com";
        int foundAt = result.indexOf("@");
        // get me the domain part of email
        System.out.println(result.substring(foundAt+1, result.length()));
        System.out.println(result.substring(result.indexOf("@")+1, result.length()));

        // get me the name part of email
        System.out.println(result.substring(0, foundAt));

    }



    public static void playWithSubstring() {
        String result = "hamburger";
        result = result.substring(0,9);
        System.out.println(result);

    }

    public static void waysToCreateAString(){
        String result = null;

        // these are the same
        String x = "Skipper";
        result = x.substring(5);
        System.out.println(result);

        result = "Skipper".substring(5);
        System.out.println(result);

        String y = new String("Skipper");
        result = y.substring(5);
        System.out.println(result);    }

}
