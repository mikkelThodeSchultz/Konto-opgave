package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Account ac1 = new Account("17", "Jens", 400);
        Account ac2 = new Account("20", "Peter", 1000);

        ac1.transfer(200,ac2);
        System.out.println(ac1);
        System.out.println(ac2);
    }
}
