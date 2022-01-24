package models;

public class Expense {
    private String userid1;
    private String userid2;
    private Double amount;

    public Expense(String userid1, String userid2, Double amount) {
        this.userid1 = userid1;
        this.userid2 = userid2;
        this.amount = amount;
    }

    public String getUserid1() {
        return userid1;
    }

    public String getUserid2() {
        return userid2;
    }

    public Double getAmount() {
        return amount;
    }
}