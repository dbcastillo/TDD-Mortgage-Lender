package com.galvanize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ApplicantProfile {
    int requestedAmount;
    int dti;
    int creditScore;
    int savings;
    int loanAmount;
    boolean qualified;
    boolean approved = false;
    boolean expired = false;
    LocalDateTime effectiveLoanDate;
    ArrayList<String> applicantInfo = new ArrayList<>();

    public ApplicantProfile(int _requestedAmount,
                            int _dti,
                            int _creditScore,
                            int _savings){
        this.requestedAmount = _requestedAmount;
        this.dti = _dti;
        this.creditScore = _creditScore;
        this.savings = _savings;
    }

//    public ArrayList<String> applicantProfileData() {
//        // we were out of time but were going to make this have applicant info
//        // we were going to use this for the last method to get loan details based on status
//    }

    public void setEffectiveLoanDate(LocalDateTime date) {
        this.effectiveLoanDate = date;
    }

    public LocalDateTime getEffectiveLoanDate(){
        return effectiveLoanDate;
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
            determinedExpiredStatus();
        } else {  // denied
            qualified = false;
            loanAmount = 0;
        }
        return qualified;
    }

    public boolean determinedExpiredStatus() {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime expirationDate = effectiveLoanDate.plusDays(3);
        currentDate.isAfter(expirationDate);
        return expired = currentDate.isAfter(expirationDate);
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
        effectiveLoanDate = LocalDateTime.now();
    }
}
