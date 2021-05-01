package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LenderTest {

    AvailableFunds availableFunds;
    ApplicantProfile newApplicant1;
    ApplicantProfile newApplicant2;

    @BeforeEach
    void setUp() {
        availableFunds = new AvailableFunds();

        newApplicant1 = new ApplicantProfile(
                250000,
                21,
                700,
                100000);
        newApplicant2 = new ApplicantProfile(
                250000,
                37,
                700,
                100000);
    }

    @Test
    public void testMyFundsShowAvailableBalance() {
        // Arrange
        availableFunds.set(500000);

        // Act
         int fundsAvailable = availableFunds.showBalance();

        // Assert
        assertTrue(fundsAvailable > 0);
        assertEquals(500000, fundsAvailable);
    }

    @Test
    public void testTotalAmountEqualsDepositAmountPlusBalance() {
        // Arrange
        availableFunds.set(500000);

        // Act
        int newDeposit = availableFunds.depositAmount(10000);

        // Assert
        assertEquals(510000, availableFunds.showBalance());

    }

    // As a lender, I want to accept and qualify loan applications,
    // so that I can ensure I get my money back.

//    Rule: To qualify for the full amount, candidates must have debt-to-income
//            (DTI) less than 36%, credit score above 620
//    and savings worth 25% of requested loan amount.
//
//    Rule: To partially qualify, candidates must still meet the same dti and credit
//    score thresholds.
//    The loan amount for partial qualified applications is four times the applicant's
//    savings.
//
//    Given a loan applicant with <dti>, <credit_score>, and <savings>
//    When they apply for a loan with <requested_amount>
//    Then their qualification is <qualification>
//    And their loan amount is <loan_amount>
//    And their loan status is <status>

//    Example:
//            |  requested_amount  |   dti  |  credit_score  |  savings  |     qualification    |  loan_amount  |   status   |
//            |      250,000       |   21   |       700      | 100,000   |       qualified      |   250,000     |  qualified |
//            |      250,000       |   37   |       700      | 100,000   |     not qualified    |         0     |  denied    |
//            |      250,000       |   30   |       600      | 100,000   |     not qualified    |         0     |  denied    |
//            |      250,000       |   30   |       700      |  50,000   |  partially qualified |   200,000     |  qualified |

    @Test
    public void testSeeIfApplicantIsQualified() {
        // Arrange


        // Act
        boolean qualification = newApplicant1.getQualification();

        // Assert
        assertTrue(qualification);


    }

    @Test
    public void testSeeIfApplicantIsNotQualified() {
        // Arrange


        // Act
        boolean qualification = newApplicant2.getQualification();

        // Assert
        assertFalse(qualification);


    }

    @Test
    public void testLoanShouldBeApproved() {
        availableFunds.set(500000);
        // Act
        boolean approvalStatus = availableFunds.getApprovedStatus(newApplicant1);
        //Assert
        assertTrue(approvalStatus);
    }

    @Test
    public void testLoanShouldBeDenied() {

        // Act
        availableFunds.set(0);
        boolean approvalStatus = availableFunds.getApprovedStatus(newApplicant2);
        //Assert
        assertFalse(approvalStatus);
    }

}
