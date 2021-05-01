package com.galvanize;

public class ApplicantProfile {
    int requestedAmount;
    int dti;
    int creditScore;
    int savings;
    int loanAmount;
    boolean qualified;
    boolean approved = false;

    public ApplicantProfile(int _requestedAmount,
                            int _dti,
                            int _creditScore,
                            int _savings){
        this.requestedAmount = _requestedAmount;
        this.dti = _dti;
        this.creditScore = _creditScore;
        this.savings = _savings;
    }

    public void setLoanAmount(int amount) {
        this.loanAmount = amount;
    }

    public int getLoanAmount() {
        return this.loanAmount;
    }

    public boolean getQualification() {
        if(this.dti < 36 && this.creditScore > 620) {
            determineQualifiedStatus();
        } else {  // denied
            qualified = false;
            loanAmount = 0;
        }
        return qualified;
    }

    private void determineQualifiedStatus() {
        if(savings >= (requestedAmount * 0.25)) {
            this.setLoanAmount(this.requestedAmount);
            qualified = true;
            this.approved = true;
        } else {
            this.setLoanAmount(savings * 4);
            qualified = true;
        }
    }
}
