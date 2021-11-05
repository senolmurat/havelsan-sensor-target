import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Handler {

    private static Handler handler_instance = null;
    static HashMap<Point , Double > bearingAngles = new HashMap<>();
    static List<Point> sensors = new ArrayList<Point>();

    private Handler(){};

    public static Handler getInstance(){
        if(handler_instance == null){
            handler_instance = new Handler();
        }

        return handler_instance;
    }

    public void storeSensors(Point sensor , double bearingAngle){
        sensors.add(sensor);
        bearingAngles.put(sensor , bearingAngle);
    }

    public Target findTarget(){

        //find the line that passes through a point(sensor) with bearing angle
        double m1 = Math.tan(Math.toRadians(bearingAngles.get(sensors.get(0))));       //LINE 1 y = m1*x + b1
        double b1 = sensors.get(0).getY() - (m1 * sensors.get(0).getX());

        double m2 = Math.tan(Math.toRadians(bearingAngles.get(sensors.get(1))));       //LINE 2 y = m2*x + b2
        double b2 = sensors.get(1).getY() - (m2 * sensors.get(1).getX());

        //Calculate the intersection point of thees lines

        double X = (b2 - b1) / (m1 - m2);
        double Y = m1 * X + b1;

        return new Target(X , Y);
    }



}
