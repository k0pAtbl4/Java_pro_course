package lesson10.bouquetParts;

public class Bouquet {
    private Flower[] flowers;
    private Accessory[] accessories;

    public Bouquet(Flower[] flowers, Accessory[] accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public Bouquet() {
        flowers = new Flower[0];
        accessories = new Accessory[0];
    }

    public void printBouquet() {
        System.out.println("Flowers:");
        if (flowers.length > 0) {
            for (Flower flower : flowers) {
                System.out.println(flower);
            }
        } else {
            System.out.println("No flowers in the bouquet");
        }
        System.out.println("Accessories:");
        if (accessories.length > 0) {
            for (Accessory accessory : accessories) {
                System.out.println(accessory);
            }
        } else {
            System.out.println("No accessories in the bouquet");
        }
        System.out.println();
    }

    public int sumCalculate() {
        int sum = 0;
        for (Flower flower : flowers) {
            sum += flower.getPrice();
        }
        for (Accessory accessory : accessories) {
            sum += accessory.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "Flowers:\n";
        for (Flower flower : flowers) {
            result += flower + "\n";
        }
        result += "Accessories:\n";
        for (Accessory accessory : accessories) {
            result += accessory + "\n";
        }
        return result;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessory[] accessories) {
        this.accessories = accessories;
    }
}
