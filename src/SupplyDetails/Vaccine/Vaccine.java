package SupplyDetails.Vaccine;

import java.util.Date;

public class Vaccine {
    int price, quantity,type;
    Date pDate, eDate;
    String name,supplier,manufacturer,id;

    public Vaccine(int price, int quantity, Date pdate, Date edate, String name, String supplier, String manufacturer, String id,int type) {
        this.price = price;
        this.quantity = quantity;
        this.pDate = pdate;
        this.eDate = edate;
        this.name = name;
        this.supplier = supplier;
        this.manufacturer = manufacturer;
        this.id = id;
        this.type=type;
    }

    public Vaccine(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
