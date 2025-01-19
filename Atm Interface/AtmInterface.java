import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}

class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final BankAccount account = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(account);

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> atm.checkBalance();
                    case 2 -> {
                        System.out.print("Enter deposit amount: ");
                        try {
                            double depositAmount = scanner.nextDouble();
                            atm.deposit(depositAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            scanner.next(); // Clear invalid input
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ");
                        try {
                            double withdrawalAmount = scanner.nextDouble();
                            atm.withdraw(withdrawalAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            scanner.next(); // Clear invalid input
                        }
                    }
                    case 4 -> {
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
