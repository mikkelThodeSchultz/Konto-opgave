package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testSum_After_Money_Has_Been_Inserted() {
        //Arrange
        Account account = new Account("kontonummer", "ejernavn", 100);
        double expected = 200;
        //Act
        double result = account.insertMoney(100);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSum_After_Money_Has_Been_Inserted_If_Saldo_is_Zero() {
        //Arrange
        Account account = new Account("kontonummer", "ejernavn");
        double expected = 100;
        //Act
        double result = account.insertMoney(100);
        //Assert
        assertEquals(expected, result);

    }

    @Test
    public void testSum_After_Money_Has_Been_Withdrawn(){
        //Arrange
        Account account = new Account("kontonummer", "ejernavn", 100);
        double expected = 50;
        //Act
        double result = account.withdrawMoney(50);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSum_If_Sum_Is_Negative_Amount(){
        //Arrange
        Account account = new Account("kontonummer", "ejernavn", 50);
        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> account.withdrawMoney(100));

    }

    @Test
    public void testTransfer_After_Money_Has_Been_Transfered(){
        //Arrange
        Account account1 = new Account("kontonummer", "ejernavn", 200);
        Account account2 = new Account("kontonummer", "ejernavn", 400);
        double expected1 = 95;
        double expected2 = 500;
        //Act
        double result1 = account1.transfer(100,account2);
        double result2 = account2.getSaldo();
        //Assert
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }

    @Test
    public void testTransfer_If_Sum_Is_Negative_Amount(){
        //Arrange
        Account account = new Account("kontonummer", "ejernavn", 50);
        Account account2 = new Account("kontonummer", "ejernavn", 50);
        //Act + Assert
        assertThrows(IllegalArgumentException.class, () -> account.transfer(46,account2));
    }
}