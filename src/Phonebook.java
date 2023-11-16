import java.util.*;

public class Phonebook {
    private static HashMap<String, ArrayList<Integer>> phonebook = new HashMap<>();

    public static void main(String[] args) {
        Phonebook phonebook1 = new Phonebook();
        phonebook1.add("Дима Трубы",123456);
        phonebook1.add("Артем Кум",234567);
        phonebook1.add("Валентин Дядька",345678);
        phonebook1.add("Дима Трубы",345678);
        phonebook1.add("Валентин Дядька",345679);
        phonebook1.add("Валентин Дядька",345670);
        getPhoneBook();
    }

    public void add(String name, Integer phoneNum) {
        if (!phonebook.containsKey(name)) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNum);
            phonebook.put(name, list);
        } else {
            ArrayList<Integer> lst = phonebook.get(name);
            lst.add(phoneNum);
        }
    }

    public ArrayList<Integer> find(String name) {
        if(phonebook.containsKey(name)) {
            return phonebook.get(name);
        }
        return new ArrayList<>() {};
    }

    public static void getPhoneBook() {
        for (ArrayList<Integer> phones:
                sortedPhoneBook()) {
            for (Map.Entry<String, ArrayList<Integer>> pair:
                    phonebook.entrySet()) {
                if (phonebook.get(pair.getKey()).equals(phones)) {
                    System.out.println(pair.getKey() + " - " + pair.getValue().toArray().length
                            + " phone numbers: " + pair.getValue());
                }
            }
        }
    }

    public static Set<ArrayList<Integer>> sortedPhoneBook() {
        Comparator<ArrayList<Integer>> comparator = Comparator.comparingInt(obj -> obj.toArray().length);
        comparator = comparator.reversed();
        Set<ArrayList<Integer>> set = new TreeSet<>(comparator);
        for (Map.Entry<String, ArrayList<Integer>> pair:
                phonebook.entrySet()) {
            set.add(pair.getValue());
        }
        return set;
    }
}
