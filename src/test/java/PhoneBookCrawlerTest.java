import phonebook.PhoneBookCrawler;
import phonebook.PhoneBookEntries;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBookEntries());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number found");

        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Neha");
    }

    @Test
    public void findPhoneNumberByName_AndFindSomething(){
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Pratibha");

        assertThat(phoneNumber).isEqualTo("9888999999");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBook = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Sakshee");

        assertThat(phoneBook).isEqualTo("PhoneBook{phoneBookEntries={Sneha=9192939495, Pratibha=9888999999, Sakshi=7535956545}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByName() {
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Sakshi", "12345678");

        assertThat(phoneNumber).isEqualTo("7535956545");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Sakshee", "7535956545");

        assertThat(name).isEqualTo("Sakshi");
    }

}
