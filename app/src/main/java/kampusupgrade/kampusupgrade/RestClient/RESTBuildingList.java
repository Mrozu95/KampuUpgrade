package kampusupgrade.kampusupgrade.RestClient;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Building;


/**
 * Created by Mathijs on 22-3-2017.
 */
@Root (name ="buildings")
public class RESTBuildingList {
    @ElementList
ArrayList<Building> list;

    public ArrayList<Building> getList() {
        return list;
    }

    public void setList(ArrayList<Building> list) {
        this.list = list;
    }
}

