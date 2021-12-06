package phonebook;

import java.util.Optional;
import java.util.stream.Stream;

public class PhoneBookCrawler {
    PhoneBookEntries phoneBook;


    public PhoneBookCrawler(PhoneBookEntries phoneBook) {

        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name)  {
        return phoneBook.findPhoneNumberByName(name).orElseThrow(()->new IllegalArgumentException("No phone number found"));
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){

        return phoneBook.findPhoneNumberByName(name).orElseGet(()->phoneBook.toString());
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){

        return Stream.of(phoneBook.findPhoneNumberByName(name), phoneBook.findNameByPhoneNumber(phoneNumber), phoneBook.findPhoneNumberByName(name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
    }
    public PhoneBookEntries getPhoneBook(){
        return phoneBook;
    }

}
