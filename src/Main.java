import org.jfree.chart.JFreeChart;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Trainer trainer = new Trainer();
       // trainer.writeTenPop();
        System.out.println("Untrained");
        trainer.writeTopPop(trainer.getOrignalPop());
        System.out.println("Trained");
        trainer.writeTopPop(trainer.getTrainedPop());


    }
}
