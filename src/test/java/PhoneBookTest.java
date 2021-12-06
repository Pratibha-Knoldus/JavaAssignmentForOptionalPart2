import phonebook.PhoneBookEntries;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookEntries phoneBook_Test = new PhoneBookEntries();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Pratibha");

        //assert phoneNumber.get().equals("9897999999");
        assertThat(phoneNumber.get()).isEqualTo("9888999999");
    }
    @Test
    public void findPhoneNumberByName_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Rishika");
        phoneNumber.get();
    }
    @Test
    public void findNameByPhoneNumber(){
        Optional<String> name=phoneBook_Test.findNameByPhoneNumber("7535956545");
        assertThat(name.get()).isEqualTo("Sakshi");
    }
    @Test
    public void findNameByPhoneNumber_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findNameByPhoneNumber("7462335481");
        phoneNumber.get();
    }
}
