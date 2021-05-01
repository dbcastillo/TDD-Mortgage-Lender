package com.galvanize;

public class AvailableFunds {
    private  int funds;


    public int showBalance() {
        return funds;
    }

    public int depositAmount(int value) {
        return funds += value;
    }

    public void set(int _funds) {
        this.funds = _funds;
    }

    public int get() {
        return this.funds;
    }

    public boolean getApprovedStatus(ApplicantProfile applicationProfile) {
        if (this.showBalance() == 0)
            return false;
        return applicationProfile.loanAmount <= this.showBalance();
    }
}
