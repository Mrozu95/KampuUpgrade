package kampusupgrade.kampusupgrade.RestClient;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import kampusupgrade.kampusupgrade.Data.Screen;

/**
 * Created by Mathijs on 29-3-2017.
 */
@Root(name = "buildings")
public class RESTScreenList {


        @ElementList
        ArrayList<Screen> list;

        public ArrayList<Screen> getList() {
            return list;
        }

        public void setList(ArrayList<Screen> list) {
            this.list = list;
        }
}

