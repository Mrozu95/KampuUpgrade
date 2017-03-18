package kampusupgrade.kampusupgrade.Data;

/**
 * Created by Mathijs on 18-3-2017.
 */

public class Screen {

    String mac;
    int id, xCoordinate, yCoordinate, rotation ;
    Building building;
    Screen[] neighbours;

    public Screen(String mac, int id, int xCoordinate, int yCoordinate, int rotation, Building building, Screen[] neighbours) {
        this.mac = mac;
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.rotation = rotation;
        this.building = building;
        this.neighbours = neighbours;
    }
}
