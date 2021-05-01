package com.galvanize;

public class AvailableFunds {
    private int funds = 500000;

    public int showBalance() {
        return funds;
    }

    public int depositAmount(int value) {
        return funds += value;
    }
}
