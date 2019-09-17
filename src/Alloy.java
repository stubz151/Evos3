public class Alloy {
    double sellingPrice;
    double plat=0;
    double iron=0;
    double copper=0;
    double elec=0;
    double unitsMade;
    String name;

    public Alloy(int sellingPrice,String name) {
        this.sellingPrice = sellingPrice;
        this.name = name;
        unitsMade=0.00;
    }

    public void create(double times)
 {
     unitsMade = unitsMade + times;
         switch (name)
         {
             case "Adamantium":
                 plat = plat +2*times;
                 iron = iron + 7*times;
                 copper = copper + 1*times;
                 elec = elec + 25*times;
                 break;
             case "Unobtainium":
                 plat =plat +3*times;
                 iron = iron+2*times;
                 copper = copper+5*times;
                 elec = elec + 23*times;
                 break;
             case "Dilithium":
                 plat =plat +8*times;
                 iron = iron+1*times;
                 copper = copper+1*times;
                 elec = elec + 35*times;
                 break;
             case "Pandemonium":
                 plat =plat +1*times;
                 iron = iron+5*times;
                 copper = copper+4*times;
                 elec = elec + 20*times;
         }
     }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getPlat() {
        return plat;
    }

    public void setPlat(double plat) {
        this.plat = plat;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public double getElec() {
        return elec;
    }

    public void setElec(double elec) {
        this.elec = elec;
    }

    public double getUnitsMade() {
        return unitsMade;
    }

    public void setUnitsMade(double unitsMade) {
        this.unitsMade = unitsMade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



