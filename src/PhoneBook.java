import java.util.HashMap;
import java.util.Map;

class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();

    public void addContact(String telNumber, String surname) {
        phoneBook.put(telNumber, surname);
        System.out.println("Контакт " + surname + " добавлен в Список контактов");
    }

    public void searchSurnameTel(String surname) {
        System.out.println("Список телефонов для фамилии : " + surname);
        for (Map.Entry entry : phoneBook.entrySet()) {
            if (entry.getValue() == surname) {
                System.out.println("Телефон: " + entry.getKey());
            }
        }
    }
}


