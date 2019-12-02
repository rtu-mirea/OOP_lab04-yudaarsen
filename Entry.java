public class Entry {
    private String name;
    private String s_name;
    private String phoneNumber;
    private String birthDate;
    private String address;

    public Entry(String name, String s_name, String phoneNumber, String birthDate, String address) throws IllegalArgumentException
    {
        if(name.equals("") || s_name.equals(""))
            throw new IllegalArgumentException("Name or S_Name is empty.");
        this.name = name;
        this.s_name = s_name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getS_name() {
        return s_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
