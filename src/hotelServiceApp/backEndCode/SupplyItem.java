package hotelServiceApp.backEndCode;

import java.util.UUID;

public class SupplyItem {

    private UUID id;
    private SupplySections section;
    private String name;
    private double price;
    private int stock;
    private String desc;

    public SupplyItem() {

        this.id = UUID.randomUUID();
    }

    public SupplyItem(SupplySections section, String name, double price, int stock, String desc) {

        this.id = UUID.randomUUID();
        this.section = section;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.desc = desc;
    }

    public SupplySections getSection() {

        return section;
    }

    public void setSection(SupplySections section) {

        this.section = section;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public int getStock() {

        return stock;
    }

    public void setStock(int stock) {

        this.stock = stock;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    /**
     * public String toString()
     * This method returns all the info of the class in String type.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Price: " + this.price + "\n" +
                "Item desc: " + this.desc + "\n";
    }
}
