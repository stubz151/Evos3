import java.util.ArrayList;

public class Calculator {
    ArrayList<Alloy> alloys = new ArrayList<>();

    public Calculator(ArrayList<Alloy> alloys) {
        this.alloys = alloys;
    }
    public double getProfit()
    {
        return getSP() - getCosts();
    }
    public double getSP()
    {
        double profit=0.00;
        for (Alloy alloy : alloys)
        {
            profit = profit + (alloy.getSellingPrice()*alloy.getUnitsMade());
        }
        return profit;
    }

    public double getCosts()
    {
        double plat=0;
        double iron=0;
        double copper=0;
        double elec=0;
        for (Alloy alloy : alloys)
        {
            plat = plat + alloy.getPlat();
            iron = iron + alloy.getIron();
            copper = copper + alloy.getCopper();
            elec = elec + alloy.getElec();
        }
        plat = plat/10;
        iron = iron/10;
        copper = copper/10;
        iron = iron - plat;
        if (iron<0)
        {
            iron =0;
        }
        double platMoney =  (10*((int)plat) +1200)*plat;
        double ironMoney =  iron* 300.00;
        double copperMoney =  copper * 800.00;
        if (copper>8)
        {
            copperMoney = copperMoney * 0.90;
        }
        double elecMoney = Math.exp(0.005*elec);
        return platMoney + ironMoney +copperMoney + elecMoney;
    }

}