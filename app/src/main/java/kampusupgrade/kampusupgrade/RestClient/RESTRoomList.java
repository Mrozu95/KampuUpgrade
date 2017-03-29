package kampusupgrade.kampusupgrade.RestClient;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Room;

/**
 * Created by Mathijs on 27-3-2017.
 */
@Root(name = "rooms")
public class RESTRoomList {


        @ElementList
        ArrayList<Room> list;

        public ArrayList<Room> getList() {
            return list;
        }

        public void setList(ArrayList<Room> list) {
            this.list = list;
        }
 }

