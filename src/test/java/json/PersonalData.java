package json;

public class PersonalData {
    public String firstName;
    public String lastName;
    public String gender;
    public Integer age;
    public Address address;

    public static class Address {
        public Integer streetAddress;
        public String city;
        public String state;
        public Integer postalCode;
    }
}
