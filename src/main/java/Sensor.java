public class Sensor extends Point {

    public Sensor(int x , int y){
        super(x,y);
    }

    public double calculateBearingAngle(Point target){
        double vector_y = target.getY() - getY();
        double vector_x = target.getX() - getX();

        if(vector_y == 0 && vector_x != 0){
            if(vector_x > 0){
                return 0;
            }
            else{
                return 180;
            }
        }

        double tan = 0;
        try {
            tan = vector_y / vector_x;
        }
        catch (ArithmeticException e){
            if(vector_y > 0){
                return 270.0;
            }
            else if(vector_y < 0){
                return 90.0;
            }
        }
        double arctan = Math.abs(Math.toDegrees(Math.atan(tan)));

        if(vector_x > 0 && vector_y < 0){
            arctan = arctan + 90;
        }
        else if(vector_x < 0 && vector_y < 0){
            arctan += 180;
        }
        else if(vector_x < 0 && vector_y > 0){
            arctan += 270;
        }

        return arctan;
    }
}
