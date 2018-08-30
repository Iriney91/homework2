package homework2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> phonebook = new HashMap<>();




    public add(String name, String phone) {


        phonebook.put(name, phone);

    }

    public get(String name) {

        String phone = phonebook.get(name);

    }
}
