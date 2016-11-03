import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jasonskipper on 10/19/16.
 */
public class Main {

    public static void main(String[] args){

//        // primatives are PASS BY VALUE
//        int test = 5;
//        test = changeIt(test);
//        System.out.print(test);
//
//        // objects are pass by reference
//        List<Integer> testList = new ArrayList<>();
//        testList.add(5);
//        changeIt(testList);
//        System.out.println(testList);
//
//        // pass by reference
//        Person p = new Person("jason", 40);
//        happyBirthday(p);
//        System.out.println(p.getAge());
//
//        // String are by by value FUCK
//        String name = "jason";
//        changeIt(name);
//        System.out.println(name);

//        playWithHashKeysDontChange();
//        hashPutGetRemove();
//        hashPutWithSameKeyReplacesWhatWasThere();

        hashStoreAListOfObjectsByKey();

        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        List<Integer> two = new ArrayList<>(one);

        System.out.print(two);
    }

    private static void hashStoreAListOfObjectsByKey() {
        Person kim = new Person("Kim", 39, "k@email.com");
        Person jason = new Person("Jason", 40, "j@email.com");
        Person tc = new Person("TC", 8, "tc@email.com");

        Movie a = new Movie("Matrix", "R");
        Movie b = new Movie("Hello", "G");
        Movie c = new Movie("Goodbye", "PG");
        Movie d = new Movie("Home Alone", "PG13");
        Movie e = new Movie("Another Movie", "R");

        HashMap<String, List<Movie>> map = new HashMap<>();
        addMovieForPerson(kim, a, map);
        addMovieForPerson(kim, b, map);
        addMovieForPerson(kim, c, map);
        addMovieForPerson(jason, a, map);
        addMovieForPerson(jason, b, map);
        addMovieForPerson(tc, c, map);
        addMovieForPerson(tc, e, map);
    }

    private static void addMovieForPerson(Person p, Movie m, HashMap<String, List<Movie>> map){
        List<Movie> foundYourList = map.remove(p.getName());

        // first time looking for your movies
        if(foundYourList == null){
            foundYourList = new ArrayList<>();
        }

        foundYourList.add(m);

        map.put(p.getName(),foundYourList);

    }

    private static void hashPutWithSameKeyReplacesWhatWasThere() {
        Person x = new Person("Kim", 39, "k@email.com");
        Person y = new Person("Jason", 40, "j@email.com");
        Person z = new Person("TC", 8, "tc@email.com");

        HashMap<String, Person> phoneBook = new HashMap<>();
        phoneBook.put(x.getName(), x);
        phoneBook.put(y.getName(), y);

        System.out.println(phoneBook);
        phoneBook.put(x.getName(), z);
        System.out.println(phoneBook);
    }

    private static void hashPutGetRemove() {
        Person x = new Person("Kim", 39, "k@email.com");
        Person y = new Person("Jason", 40, "j@email.com");

        HashMap<String, Person> phoneBook = new HashMap<>();
        phoneBook.put(x.getName(), x);
        phoneBook.put(y.getName(), y);

        System.out.println(phoneBook);
        Person found = phoneBook.remove("Jason");
        phoneBook.put("hello", found);
        System.out.println(phoneBook);
    }

    private static void playWithHashKeysDontChange() {
        Person x = new Person("Kim", 39, "k@email.com");
        Person y = new Person("Jason", 40, "j@email.com");

        HashMap<String, Person> phoneBook = new HashMap<>();
        phoneBook.put(x.getName(), x);
        phoneBook.put(y.getName(), y);

        System.out.print(phoneBook);

        Person found = phoneBook.get("Jason");

        found.setName(found.getName()+"-changed");

        Person found2 = phoneBook.get("Jason");

        System.out.printf("\nI found this:%s",found2);
    }

    private static void changeIt(String name) {
        name = name + "changed";

    }

    public static void happyBirthday(Person p){
        int age = p.getAge();
        age++;
        p.setAge(age);
    }

    public static int changeIt(int changeme){
        changeme = changeme + 1;
        return changeme;
    }

    public static void changeIt(List<Integer> changeMe){
        int x = changeMe.get(0);
        x = x + 1;
        changeMe.set(0, x);
    }
}
