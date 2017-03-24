package kampusupgrade.kampusupgrade.Data;

/**
 * Created by Mathijs on 18-3-2017.
 */

public class Screen {

    String mac;
    int id, rotation;
    Building building;
    Screen[] neighbours;
    Coordinate coordinate;

    public Screen(String mac, int id, Coordinate coordinate, int rotation, Building building, Screen[] neighbours) {
        this.mac = mac;
        this.id = id;
        this.coordinate = coordinate;
        this.rotation = rotation;
        this.building = building;
        this.neighbours = neighbours;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Screen[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Screen[] neighbours) {
        this.neighbours = neighbours;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
