package entity;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneModel;
    private String mobileOperator;

    public User(Integer id, String firstName, String lastName, String phoneModel, String mobileOperator) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneModel = phoneModel;
        this.mobileOperator = mobileOperator;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneModel='" + phoneModel + '\'' +
                ", mobileOperator='" + mobileOperator + '\'' +
                '}';
    }

}
