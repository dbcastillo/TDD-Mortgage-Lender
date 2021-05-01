package com.galvanize;

public class ApplicantProfile {
    int requestedAmount;
    int dti;
    int creditScore;
    int savings;
    int loanAmount;
    boolean qualified;

    public ApplicantProfile(int _requestedAmount,
                            int _dti,
                            int _creditScore,
                            int _savings){
        this.requestedAmount = _requestedAmount;
        this.dti = _dti;
        this.creditScore = _creditScore;
        this.savings = _savings;
    }

    public boolean getQualification() {
        if(this.dti < 36 && this.creditScore > 620) {
            determineQualifiedStatus();
        } else {
            qualified = false;
        }
        return qualified;
    }

    private void determineQualifiedStatus() {
        if(savings >= (requestedAmount * 0.25)) {
            loanAmount = requestedAmount;
            qualified = true;
        } else {
            loanAmount = savings * 4;
            qualified = true;
        }
    }
}
