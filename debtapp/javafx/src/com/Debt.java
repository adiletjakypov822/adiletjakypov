package com;

public class Debt {
    private String personName;
    private String amount;

    public Debt() {
    }

    public Debt(String personName, String amount) {
        this.personName = personName;
        this.amount = amount;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
