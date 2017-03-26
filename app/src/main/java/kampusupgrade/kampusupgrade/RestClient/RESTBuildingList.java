package kampusupgrade.kampusupgrade.RestClient;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;

/**
 * Created by Mathijs on 22-3-2017.
 */
@Root (name ="buildings")
public class RESTBuildingList {
    @ElementList
ArrayList<RESTBuilding> list;

    public ArrayList<RESTBuilding> getList() {
        return list;
    }

    public void setList(ArrayList<RESTBuilding> list) {
        this.list = list;
    }
}

