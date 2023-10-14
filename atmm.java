package atm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class atmm{
	    private static List<Bank> accounts = new ArrayList();

	    public atmm() {
	        accounts.add(new Bank("deepu", "1234", 1000.0));
	        accounts.add(new Bank("lekha", "5678", 1500.0));
	        accounts.add(new Bank("Divya", "9101", 2000.0));
	    }
	    public void displayMenu() {
	        System.out.println("Menu:");
	        System.out.println("1. View Balance");
	        System.out.println("2. Withdraw");
	        System.out.println("3. Exit");
	    }
	   

	    public static void main(String[] args) {
	        atmm a = new atmm();
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter your account name: ");
	        String accountName = sc.nextLine();

	        Bank currentAccount = null;

	        for (Bank account : accounts) {
	            if (account.getAccountName().equals(accountName)) {
	                currentAccount = account;
	                break;
	            }
	        }

	        if (currentAccount != null) {
	            System.out.print("Enter your PIN: ");
	            String pin = sc.nextLine();

	            if (currentAccount.validatePin(pin)) {
	                System.out.println("Welcome, " + accountName + "! Your current balance is: " + currentAccount.getBalance());

	                while (true) {
	                    a.displayMenu();
	                    System.out.print("Enter your choice: ");
	                    int choice = sc.nextInt();

	                    switch (choice) {
	                        case 1:
	                            System.out.println("Your current balance is: " + currentAccount.getBalance());
	                            break;
	                        case 2:
	                            System.out.print("Enter the withdrawal amount: ");
	                            double withdrawalAmount = sc.nextDouble();
	                            currentAccount.withdraw(withdrawalAmount);
	                            break;
	                        case 3:
	                            System.out.println("Exiting. Thank you!");
	                            sc.close();
	                            return;
	                        default:
	                            System.out.println("Invalid choice. Please try again.");
	                            break;
	                    }
	                }
	            } else {
	                System.out.println("Invalid PIN.");
	            }
	        } else {
	            System.out.println("Account not found.");
	        }
	    }
	}
