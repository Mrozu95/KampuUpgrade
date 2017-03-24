package kampusupgrade.kampusupgrade.Data;

/**
 * Created by Mathijs on 18-3-2017.
 */

public class Room{
    String name,wing;
    int id,number,floor;
    Coordinate coordinate;
    Building building;

    public Room(String name, String wing, int id, int number, int floor, Coordinate coordinate, Building building) {
        this.name = name;
        this.wing = wing;
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.coordinate = coordinate;
        this.building = building;
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
}
