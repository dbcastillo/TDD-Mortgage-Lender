package com.galvanize;

public class AvailableFunds {
    private  int funds;
    private int pendingFunds;

    public int showBalance() {
        return funds;
    }

    public int depositAmount(int value) {
        return funds += value;
    }

    public void set(int _funds) {
        this.funds = _funds;
    }

    public int getPendingFunds() {
        return this.pendingFunds;
    }

    public boolean getApprovedStatus(ApplicantProfile applicationProfile) {
        if (this.showBalance() == 0)
            return false;

        if (applicationProfile.approved && !applicationProfile.determinedExpiredStatus()) {
            this.pendingFunds = applicationProfile.loanAmount;
            this.funds = this.funds - this.pendingFunds;
            return applicationProfile.loanAmount <= this.showBalance();
        }

        return true;
    }
}
