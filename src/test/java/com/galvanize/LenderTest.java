package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LenderTest {


    //As a lender, I want to be able to check my available funds,
    //so that I know how much money I can offer for loans.

    //When I check my available funds
    //Then I should see how much funds I currently have
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

    }
}
