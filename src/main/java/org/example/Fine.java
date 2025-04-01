package org.example;

public class Fine {
    private final String type;
    private final double amount;
    private final String city;

    public Fine(String type, double amount, String city) {
        this.type = type;
        this.amount = amount;
        this.city = city;
    }

    public String getType() {
        return  type;
    }

    public String getCity() {
        return city;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public  String toString() {
        return type + " - " + amount + " руб. (" + city + ")";
    }
}
