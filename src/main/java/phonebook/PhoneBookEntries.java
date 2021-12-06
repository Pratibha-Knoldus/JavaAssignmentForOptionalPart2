package phonebook;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBookEntries {
    static HashMap<String, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put("Pratibha","9888999999");
        phoneMap.put("Sneha","9192939495");
        phoneMap.put("Sakshi","7535956545");
    }
    Map<String, String> phoneMapEntries = phoneMap;

    public Optional<String> findPhoneNumberByName(String name) {
        if (phoneMapEntries.containsKey(name)) {
            return Optional.of(phoneMapEntries.get(name));
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber) {

        for (Map.Entry<String, String> entry : phoneMapEntries.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }
    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneMapEntries +
                '}';
    }
}
