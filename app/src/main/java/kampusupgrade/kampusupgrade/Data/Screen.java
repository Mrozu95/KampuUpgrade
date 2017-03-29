package kampusupgrade.kampusupgrade.Data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Mathijs on 18-3-2017.
 */
@Root(name = "screens")
public class Screen {
    @Element (name = "mac")
    String mac;
    @Attribute (name = "id")
    int id;
    @Element (name = "rotation")
    int rotation;
    @Element (name = "building", required=false)
  public   Building building;
    @ElementList (name = "neighbourlist", required=false)
    public ArrayList<Screen> neighbours;
    @Element (name = "coordinates")
    public Coordinate coordinate;
    @Element (name = "distance", required = false)
    int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Screen(String mac, int id, Coordinate coordinate, int rotation, Building building, ArrayList<Screen> neighbours) {
        this.mac = mac;
        this.id = id;
        this.coordinate = coordinate;

        this.rotation = rotation;
        this.building = building;
        this.neighbours = neighbours;
    }

    public Screen(){

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

    public ArrayList<Screen> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<Screen> neighbours) {
        this.neighbours = neighbours;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
