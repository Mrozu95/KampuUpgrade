package kampusupgrade.kampusupgrade.Data;

/**
 * Created by Mathijs on 18-3-2017.
 */

public class Room {
    String name,wing;
    int id,number,floor, xCoordinate, yCoordinate;
    Building building;

    public Room(String name, String wing, int id, int number, int floor, int xCoordinate, int yCoordinate, Building building) {
        this.name = name;
        this.wing = wing;
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.building = building;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
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
