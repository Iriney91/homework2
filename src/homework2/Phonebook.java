package Java2;

import java.util.*;

/**
 * Created by Irina on 30.08.2018.
 */
public class Phonebook {

    Map<String, Set<String>> phonebook = new HashMap<>();

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "786597889");
        phonebook.add("Ivanov", "9846456");
        phonebook.add("Sidorov", "65496490");
        print(phonebook, "Ivanov");
        print(phonebook, "Sidorov");
        print(phonebook, "Pershin");

    }

    public void add(String name, String phone) {

        Set<String> phones = phonebook.get(name);
        if (phones == null) {
            phones = new HashSet<>();
            phonebook.put(name, phones);
        }
        phones.add(phone);

    }

    Collection<String> get(String name) {

        return phonebook.get(name);
    }

    public static void print (Phonebook ph, String name){
        Collection<String> phones = ph.get(name);

        if(phones == null){
            System.out.print("Фамилия не найдена");
        }else{
            //Не знаю как лучше выводить
            //for(String phone : phones)
            //System.out.println( name + phone);
            System.out.println(name + phones);
        }
    }
}
