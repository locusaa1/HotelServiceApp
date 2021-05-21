package hotelServiceApp.backEndCode;

import java.util.UUID;

public class SupplyItem {

    private UUID id;
    private String name;
    private double price;
    private int stock;
    private String desc;

    public SupplyItem() {

        this.id = UUID.randomUUID();
    }

    public SupplyItem(String name, double price, int stock, String desc) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.desc = desc;
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

}
