import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BearingAngleTest {

    private static Handler handler;
    private static final float EPSILON = 0.000001f;

    @BeforeClass
    public static void createHandler(){
        handler = Handler.getInstance();
    }

    @Test
    public void findTargetTest(){
        //Creating sensors
        Sensor sensor_1 = new Sensor(-5,1);
        Sensor sensor_2 = new Sensor(5,-1);

        //Creating Target
        Target target = new Target(-1 , 5);

        //Needs to be Sent with Apache Kafka -----------------------------------
        handler.storeSensors(sensor_1 , sensor_1.calculateBearingAngle(target));
        handler.storeSensors(sensor_2 , sensor_2.calculateBearingAngle(target));
        //----------------------------------------------------------------------

        Target calculatedTarget = handler.findTarget();

        assertTrue(areIdentical(target,calculatedTarget));
    }

    private boolean areIdentical(Target target , Target calculatedTarget){
        return (Math.abs(target.getX() - calculatedTarget.getX()) < EPSILON && Math.abs(target.getY() - calculatedTarget.getY()) < EPSILON);
    }

}
