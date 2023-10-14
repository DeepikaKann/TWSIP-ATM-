package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bank {
    private String accountName;
    private String pin;
    private double balance;

    public Bank(String accountName, String pin, double balance) {
        this.accountName = accountName;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
