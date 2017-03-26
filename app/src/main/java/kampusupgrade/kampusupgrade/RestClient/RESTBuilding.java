package kampusupgrade.kampusupgrade.RestClient;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Mathijs on 26-3-2017.
 */
@Root (name = "building")
public class RESTBuilding {

    @Attribute(name = "id")
    private String id;
    @Element(name = "name")
    private String name;
    @Element (name = "street")
    private String street;
    @Element (name = "city")
    private String city;
    @Element (name = "postal_code")
    private String postalCode;
    @Element (name = "number")
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
