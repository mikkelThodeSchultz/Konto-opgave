package com.company;

public class Account {
    private String kontonummer;
    private String ejernavn;
    private double saldo;

    public Account (String kontonummer, String ejernavn, double saldo){
        this.kontonummer = kontonummer;
        this.ejernavn = ejernavn;
        this.saldo = saldo;

    }

    public Account (String kontonummer, String ejernavn){
        this.kontonummer = kontonummer;
        this.ejernavn = ejernavn;
        this.saldo = 0;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public String getEjernavn() {
        return ejernavn;
    }

    public void setEjernavn(String ejernavn) {
        this.ejernavn = ejernavn;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double insertMoney(double insertAmount){
        saldo = saldo + insertAmount;
        return saldo;
    }

    public double withdrawMoney(double withdrawAmount){
        saldo = saldo - withdrawAmount;
        if (saldo < 0){
            throw new IllegalArgumentException();
        }
        return saldo;
    }

    @Override
    public String toString() {
        return "Kontonummer: " + kontonummer + "\nEjernavn: " + ejernavn + "\nSaldo: " + saldo;
    }

    public double transfer(double transferAmount, Account receivingAccount) {
        int gebyr = 5;
        saldo = saldo - transferAmount - gebyr;
        if (saldo < 0){
            throw new IllegalArgumentException();
        }
        receivingAccount.saldo = receivingAccount.saldo + transferAmount;
        return saldo;
    }
}


