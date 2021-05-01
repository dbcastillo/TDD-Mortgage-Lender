package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LenderTest {

    AvailableFunds availableFunds;

    @BeforeEach
    void setUp() {
        availableFunds = new AvailableFunds();
    }

    @Test
    public void testMyFundsShowAvailableBalance() {
        // Arrange


        // Act
         int fundsAvailable = availableFunds.showBalance();

        // Assert
        assertTrue(fundsAvailable > 0);
        assertEquals(500000, fundsAvailable);
    }

    // As a lender, I want to add money to my available funds,
    // so that I can offer loans to potential home buyers.

    // Given I have <current_amount> available funds
    // When I add <deposit_amount>
    // Then my available funds should be <total>

    @Test
    public void testTotalAmountEqualsDepositAmountPlusBalance() {
        // Arrange


        // Act
        int newDeposit = availableFunds.depositAmount(10000);

        // Assert
        assertEquals(510000, availableFunds.showBalance());


    }
}
