package kampusupgrade.kampusupgrade.Data;

/**
 * Created by Mathijs on 18-3-2017.
 */

public class Building {

    String name,street,city,postalCode;
    int id,number;



    public  Building(int id, String name, String street, String city, int number, String postalCode){
        name=this.name;
        street = this.street;
        city = this.city;
        number = this.number;
        postalCode =this.postalCode;
        id= this.id;

    }

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
