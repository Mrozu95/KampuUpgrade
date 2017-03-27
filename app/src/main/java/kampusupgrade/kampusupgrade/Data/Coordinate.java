package kampusupgrade.kampusupgrade.Data;

import org.simpleframework.xml.Element;

/**
 * Created by Michal on 2017-03-24.
 */

public class Coordinate
{
    //cooridantes on map from default position 0,0
    @Element
    private float x;
    @Element
    private float y;

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public  Coordinate(){

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
