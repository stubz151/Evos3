import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Trainer {
    ArrayList<Unit> pop;
    ArrayList<Unit> comparePop;
    private double mutationChance=0.8;
    private double mutationRate = 1.00;
    public Trainer() {
        pop = new Population().genPop(100);
        comparePop = (ArrayList<Unit>) pop.clone();
        Train();
    }

    public void Train() {
        Collections.shuffle(pop);
        int j =0;
        Random random = new Random();
        while (j<1000) {

            ArrayList<Unit> group = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                int nextnum = (random.nextInt(pop.size() - 1));
                group.add(pop.get(nextnum));
            }
            Unit maxObject = Collections.max(group, new Comparator<Unit>() {
                @Override
                public int compare(Unit o1, Unit o2) {
                    if (o1.getProfit() == o2.getProfit()) {
                        return 0;
                    } else if (o1.getProfit() < o2.getProfit()) {
                        return -1;
                    } else if (o1.getProfit() > o2.getProfit()) {
                        return 1;
                    }
                    return 0;
                }
            });
            pop.add(Mutate(maxObject));
            j++;
        }
    }
    public Unit Mutate(Unit unit)
    {
        Random random =new Random();
        ArrayList<Alloy> vector = unit.getAlloys();
        Double[] arr = new Double[4];
        for (int i =0; i <4 ;i++)
        {
            double unitsMade = vector.get(i).getUnitsMade();
            if (random.nextDouble()<=mutationChance)
            {
                unitsMade = unitsMade + random.nextGaussian()*mutationRate;
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
            System.out.println(pop.get(i).getProfit());
        }
    }
    public void writeTopPop(ArrayList<Unit> arr)
    {
        Unit maxObject = Collections.max(arr, new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                if (o1.getProfit() == o2.getProfit()) {
                    return 0;
                } else if (o1.getProfit() < o2.getProfit()) {
                    return -1;
                } else if (o1.getProfit() > o2.getProfit()) {
                    return 1;
                }
                return 0;
            }
        });
        System.out.println("TOP profit " + maxObject.getProfit());
        ArrayList<Alloy> alloys = maxObject.getAlloys();
        for (Alloy alloy : alloys)
        {
            System.out.println("alloy name: " + alloy.getName() + " alloy count: " + alloy.getUnitsMade());
        }
    }






    public ArrayList<Unit> getPop() {
        return pop;
    }

    public void setPop(ArrayList<Unit> pop) {
        this.pop = pop;
    }

    public double getMutationChance() {
        return mutationChance;
    }

    public void setMutationChance(double mutationChance) {
        this.mutationChance = mutationChance;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public ArrayList<Unit> getComparePop() {
        return comparePop;
    }

    public void setComparePop(ArrayList<Unit> comparePop) {
        this.comparePop = comparePop;
    }
}
