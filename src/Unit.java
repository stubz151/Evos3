import java.util.ArrayList;

public class Unit {
    Alloy Adamantium = new Alloy(3000,"Adamantium");
    Alloy Unobtainium = new Alloy(3100, "Unobtainium");
    Alloy Dilithium = new Alloy(5200,"Dilithium");
    Alloy Pandemonium = new Alloy(2500,"Pandemonium");
    Double[] createArray;
    ArrayList<Alloy> alloys = new ArrayList<>();
    Calculator calculator;
    public Unit(Double[] createArray) {
        this.createArray = createArray;
        Create();
        calculator = new Calculator(alloys);
    }


    private void Create()
    {
        Adamantium.create(createArray[0]);
        Unobtainium.create(createArray[1]);
        Dilithium.create(createArray[2]);
        Pandemonium.create(createArray[3]);
        alloys.add(Adamantium);
        alloys.add(Unobtainium);
        alloys.add(Dilithium);
        alloys.add(Pandemonium);
    }
    public double getProfit()
    {
        return calculator.getProfit();
    }

    public ArrayList<Alloy> getAlloys() {
        return alloys;
    }

    public void setAlloys(ArrayList<Alloy> alloys) {
        this.alloys = alloys;
    }
}
