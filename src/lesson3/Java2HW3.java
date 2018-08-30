package Java2;

import java.util.*;


/**
 * Created by Irina on 28.08.2018.
 */
public class Java2HW3 {

    public  static void main (String [] args){

        String [] arr = {"apple", "orange", "lemon", "banana", "apricot", "apple", "mango", "carrot",
                "cherry", "garlic", "mango", "apple", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "olive"};

        HashSet<String> fruit = new HashSet<>(Arrays.asList(arr));

        System.out.println(fruit);

        Map<String, Integer> words = new HashMap<>();

        Integer count;
        for (int i = 0; i < arr.length; i++) {
            count = words.get(arr[i]);
            if (count != null) {
                words.put(arr[i], count + 1);
            } else {
                words.put(arr[i], 1);
            }
        }

        System.out.println(Arrays.asList(words));

    }

}


