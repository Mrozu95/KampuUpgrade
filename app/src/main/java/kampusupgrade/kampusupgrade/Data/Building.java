package kampusupgrade.kampusupgrade.Data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Mathijs on 18-3-2017.
 */
@Root (name= "building")
public class Building {
    @Element (name = "name")
    String name;
    @Element (name= "street")
    String street;
    @Element (name= "city")
    String city;
    @Element (name= "postal_code")
    String postalCode;
    @Attribute (name= "id")
    int id;
    @Element (name= "number")
    int number;


    public Building(int id, String name, String street, String city, int number, String postalCode) {
        name = this.name;
        street = this.street;
        city = this.city;
        number = this.number;
        postalCode = this.postalCode;
        id = this.id;

    }
    public Building(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
