import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Trainer {
    ArrayList<Unit> orignalPop;
    ArrayList<Unit> trainedPop;
    private Random random;
    private double mutationChance=0.4;
    private double mutationMag = 2.0;
    private Double[] badArr = new Double[4];
    public Trainer() {
        random = new Random();

        for (int i=0 ; i< 4;i++)
        {
        badArr[i] =999.00;
        badArr[i] =999.00;
        badArr[i] =999.00;
        badArr[i] =999.00;
        }
        orignalPop = new Population().genPop(1000);
        Train();

    }

    public void Train() {

        Collections.shuffle(orignalPop);
        Unit maxNum1 = getPop((ArrayList<Unit>) orignalPop.clone(),0);
        Unit maxNum2 = getPop((ArrayList<Unit>) orignalPop.clone(),1);
        ArrayList<Unit> workingPop = genNextPop(orignalPop,maxNum1,maxNum2);
        double checkResult = maxNum1.getProfit();
        int countNoImprove =0;
        int iterations =1000;
        Grapher grapher = new Grapher();
        for (int i= 0 ; i < iterations ; i++)
        {
            grapher.fitSeries.add(i, checkResult);
            checkResult = getPop(workingPop , 0).getProfit();
            workingPop = genNextPop(workingPop, maxNum1, maxNum2);
            if (checkResult-getPop(workingPop , 0).getProfit() <0)
            {
                if (countNoImprove>5)
                {
                    i=iterations;
                }
            }
            countNoImprove =0;
        }
        trainedPop = workingPop;
        grapher.setVisible(true);
    }

    public ArrayList<Unit> getTrainedPop() {
        return trainedPop;
    }

    public ArrayList<Unit> genNextPop(ArrayList<Unit> pop, Unit unit1, Unit unit2) {
        ArrayList<Unit> newPop = new ArrayList<>();
        newPop.add(unit1);
        newPop.add(unit2);
        while (newPop.size() < orignalPop.size()) {
            //maxNum1 is highest, maxNum2 is 2nd.
            Unit maxNum1 = new Unit(badArr);
            Unit maxNum2 = new Unit(badArr);
            for (int i = 0; i < 10; i++) {
                int nextnum = (random.nextInt(pop.size() - 1));
                double result =pop.get(nextnum).getProfit();
                    if (result>maxNum1.getProfit())
                    {
                        maxNum1= pop.get(nextnum);
                    }
                }
            for (int i = 0; i < 10; i++) {
                int nextnum = (random.nextInt(pop.size() - 1));
                double result =pop.get(nextnum).getProfit();
                if (result>maxNum2.getProfit())
                {
                    maxNum2= pop.get(nextnum);
                }
            }
            Unit crossUnit = Crossover(maxNum1, maxNum2);
            newPop.add(Mutate((crossUnit)));
            }
        return newPop;
    }

    public Unit Crossover(Unit unit1, Unit unit2)
    {

        ArrayList<Alloy> vector1 = unit1.getAlloys();
        ArrayList<Alloy> vector2 = unit2.getAlloys();
        Double[] arr = new Double[4];
        for (int i =0; i <4 ;i++)
        {
            if (random.nextDouble()>=0.5)
            {
                arr[i]= vector1.get(i).getUnitsMade();
            }
            else
            {
                arr[i]= vector2.get(i).getUnitsMade();
            }
        }
        return new Unit(arr);
    }


    public Unit Mutate(Unit unit)
    {

        ArrayList<Alloy> vector = unit.getAlloys();
        Double[] arr = new Double[4];
        for (int i =0; i <4 ;i++)
        {
            double unitsMade = vector.get(i).getUnitsMade();
            if (random.nextDouble()<=mutationChance)
            {
                unitsMade = unitsMade + random.nextGaussian()*mutationMag;
                if (unitsMade<0)
                {
                    unitsMade =0;
                }
            }
            arr[i]= unitsMade;
        }

        return new Unit(arr);
    }
    public void writeTenPop()
    {
        for (int i =0 ; i< 10; i++)
        {
            System.out.println(orignalPop.get(i).getProfit());
        }
    }
    public Unit getPop(ArrayList<Unit> arr, int pos)
    {
       arr.sort((o1, o2) -> {
           if (o1.getProfit() == o2.getProfit()) {
               return 0;
           } else if (o1.getProfit() > o2.getProfit()) {
               return -1;
           } else if (o1.getProfit() < o2.getProfit()) {
               return 1;
           }
           return 0;
       });
        return arr.get(pos);
    }

    public void writeTopPop(ArrayList<Unit> arr)
    {
        Unit maxObject = Collections.max(arr, (o1, o2) -> {
            if (o1.getProfit() == o2.getProfit()) {
                return 0;
            } else if (o1.getProfit() < o2.getProfit()) {
                return -1;
            } else if (o1.getProfit() > o2.getProfit()) {
                return 1;
            }
            return 0;
        });
        System.out.println("TOP profit " + maxObject.getProfit());
        ArrayList<Alloy> alloys = maxObject.getAlloys();
        for (Alloy alloy : alloys)
        {
            System.out.println("alloy name: " + alloy.getName() + " alloy count: " + alloy.getUnitsMade());
        }
    }

    public ArrayList<Unit> getOrignalPop() {
        return orignalPop;
    }

    public void setOrignalPop(ArrayList<Unit> orignalPop) {
        this.orignalPop = orignalPop;
    }

    public double getMutationChance() {
        return mutationChance;
    }

    public void setMutationChance(double mutationChance) {
        this.mutationChance = mutationChance;
    }

}
