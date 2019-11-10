package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private Enum salutation;
    private String firstName;
    private String lastName;
    private String co;
    private String street;
    private String streetNumber;
    private String addressAddition;


    public Enum getSalutation() {
        return salutation;
    }

    public void setSalutation(Enum salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setAddressAddition(String addressAddition) {
        this.addressAddition = addressAddition;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCo() {
        return co;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getAddressAddition() {
        return addressAddition;
    }

}
