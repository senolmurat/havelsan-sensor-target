import java.util.ArrayList;
import java.util.List;

public class MainTester {

    public static void main(String[] args) {

        WorldBuilder builder = WorldBuilder.getInstance();
        Handler handler = Handler.getInstance();


        List<Sensor> sensors = builder.buildSensors();
        Point target = builder.buildTarget();

        handler.storeSensors(sensors.get(0) , sensors.get(0).calculateBearingAngle(target));
        handler.storeSensors(sensors.get(1) , sensors.get(1).calculateBearingAngle(target));

        Target calculatedTarget = handler.findTarget();

        System.out.println("Sensor-1 Coordinates X: " + sensors.get(0).getX() + " Y: " + sensors.get(0).getY());
        System.out.println("Sensor-2 Coordinates X: " + sensors.get(1).getX() + " Y: " + sensors.get(1).getY());
        System.out.println("Target Coordinates X: " + calculatedTarget.getX() + " Y: " + calculatedTarget.getY());

    }
}
