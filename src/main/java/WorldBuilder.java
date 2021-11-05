import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class WorldBuilder {


    private static final int size_x = 1000; //Area limit X
    private static final int size_y = 1000; //Area Limit Y
    private static final int numOfSensors = 2; // Number of sensors

    private static WorldBuilder builder_instance = null;

    private WorldBuilder(){
    };

    public static WorldBuilder getInstance(){
        if(builder_instance == null){
            builder_instance = new WorldBuilder();
        }

        return builder_instance;
    }

    public List buildSensors(){
        //Generate randomly located sensors
        List<Point> sensors = new ArrayList<>();
        for(int i = 0 ; i < numOfSensors ; i++){
            sensors.add(new Sensor(ThreadLocalRandom.current().nextInt(-500, 500 + 1) , ThreadLocalRandom.current().nextInt(-500, 500 + 1)));
        }

        return sensors;
    }

    public Target buildTarget(){
        //Generate randomly located target
        Target target = new Target(ThreadLocalRandom.current().nextInt(-500, 500 + 1),ThreadLocalRandom.current().nextInt(-500, 500 + 1));

        return target;
    }

}
