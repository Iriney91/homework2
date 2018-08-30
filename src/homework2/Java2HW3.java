package homework2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Java2HW3 {

    public static void main(String[] args) {

        String[] arr = {"apple", "orange", "lemon", "banana", "mango", "avocado", "broccoli", "carrot",
                "cherry", "olive", "apple", "melon", "apple", "kiwi", "mango", "olive", "nut", "olive", "pea",
                "olive"};


        HashSet<String> fruit = new HashSet<String>(Arrays.asList(arr));

        System.out.println(fruit);

        Map<String, Integer> words = new HashMap<String, Integer>();

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
