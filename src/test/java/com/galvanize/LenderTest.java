package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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

    @Test
    public void testFundisPendingAfterAppovedLoan() {
        //Act
        availableFunds.set(350000);
        newApplicant1.getQualification();
        boolean approvedStatus = availableFunds.getApprovedStatus(newApplicant1);

        //Assert
        assertEquals(250000, availableFunds.getPendingFunds());
        assertEquals(100000, availableFunds.showBalance());
    }

    @Test
    public  void testIfPendingAdjustedAfterLoanRejected() {
        availableFunds.set(350000);
        newApplicant2.getQualification();
        boolean approvedStatus = availableFunds.getApprovedStatus(newApplicant2);

        //Assert
        assertEquals(350000, availableFunds.showBalance());
    }

    @Test
    public void testWhenLoanExpiresPendingAmountReturnedToAvailableFunds() {
        // Arrange
        availableFunds.set(350000);
        newApplicant1.getQualification();

        // Act
        newApplicant1.setEffectiveLoanDate(LocalDateTime.now().minusDays(4));
        boolean approvedStatus = availableFunds.getApprovedStatus(newApplicant1);
        // Assert
        // When Loan is expired, pending amount goes back to the available funds
        assertEquals(350000, availableFunds.showBalance());
    }

}
