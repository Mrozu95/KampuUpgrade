package kampusupgrade.kampusupgrade.Data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Mathijs on 18-3-2017.
 */
@Root
public class Room{
    @Element (name = "name")
    String name ;
    @Element (name = "wing")
    String wing;
    @Attribute (name = "id")
    int id;
    @Element (name = "roomnumber")
    int number;
    @Element (name = "floor")
    int floor;
    @Element (name = "coordinates")
   public Coordinate coordinate;
    @Element (name = "building")
   public Building building;
    @Element (name = "screen")
    Screen closestScreen;

    public Room(String name, String wing, int id, int number, int floor, Coordinate coordinate, Building building, Screen screen ) {
        this.name = name;
        this.wing = wing;
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.coordinate = coordinate;
        this.building = building;
        this.closestScreen = screen;
    }
    public  Room(){

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Screen getClosestScreen() {
        return closestScreen;
    }

    public void setClosestScreen(Screen closestScreen) {
        this.closestScreen = closestScreen;
    }
}
