import java.util.ArrayList;
import java.util.Random;

public class Population {
    public double numAdamantium;
    public double numUnobtainium;
    public double numDilithium;
    public double numPandemonium;
    public Random random;


    public ArrayList<Unit> genPop(int size)
    {
        random = new Random();
        ArrayList<Unit> popArray = new ArrayList<>();
        for (int i =0 ; i< size; i++)
        {
            popArray.add(GenUnit());
        }
        return popArray;
    }

    public Unit GenUnit()
    {

        numAdamantium = random.nextDouble()*50.00;
        numUnobtainium =random.nextDouble()*50.00;
        numDilithium = random.nextDouble()*50.00;
        numPandemonium = random.nextDouble()*50.00;
        Double[] arr=  new Double[4];
        arr[0] = numAdamantium;
        arr[1] = numUnobtainium;
        arr[2] = numDilithium;
        arr[3] = numPandemonium;
        Unit unit = new Unit(arr);
        return unit;
    }


}
