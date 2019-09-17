import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Alloy Adamantium = new Alloy(3000,"Adamantium");
        Alloy Unobtainium = new Alloy(3100, "Unobtainium");
        Alloy Dilithium = new Alloy(5200,"Dilithium");
        Alloy Pandemonium = new Alloy(2500,"Pandemonium");
        Adamantium.create(2.5);
        Unobtainium.create(3.5);
        Dilithium.create(4.6);
        Pandemonium.create(5.7);
        ArrayList<Alloy> alloys = new ArrayList<>();
        alloys.add(Adamantium);
        alloys.add(Unobtainium);
        alloys.add(Dilithium);
        alloys.add(Pandemonium);
        Calculator calculator = new Calculator(alloys);
        Trainer trainer = new Trainer();
       // trainer.writeTenPop();
        System.out.println("Untrained");
        trainer.writeTopPop(trainer.getOrignalPop());
        System.out.println("Trained");
        trainer.writeTopPop(trainer.getTrainedPop());
    }
}
