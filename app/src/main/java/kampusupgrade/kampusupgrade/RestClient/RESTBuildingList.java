package kampusupgrade.kampusupgrade.RestClient;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;

/**
 * Created by Mathijs on 22-3-2017.
 */
@Root
public class RESTBuildingList {





}
@Root
class RESTBuilding {

    @Element (name = "id")
    private String id;
    @Element (name = "name")
    private String name;
    @Element (name = "street")
    private String street;
    @Element (name = "city")
    private String city;
    @Element (name = "postalcode")
     private String postalCode;
    @Element (name = "number")
    private String number;



}
