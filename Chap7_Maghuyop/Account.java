//************************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, and get a String representation
// of the account.
//************************************************************

import java.util.Random;

public class Account {
	private double balance = 0;
	private String name = "";
	private int acctNum = 0;

	private static double total_deposit = 0;
	private static double total_withdrawal = 0;
	private static int num_deposit = 0;
	private static int num_withdrawal = 0;

	private static int[] acctNums = new int[20];
	private static int totalAcctNos;

	Random generator = new Random();

	//-------------------------------------------------
	//Constructor -- initializes balance, owner, and account number
	//-------------------------------------------------
	public Account(double initBal, String owner, int number) {
		this.balance = initBal;
		name = owner;
		if(totalAcctNos < acctNums.length) {
			acctNum = generator.nextInt(number);
			while(isAccNoDuplicate(acctNum)) {
				acctNum = generator.nextInt(number);
			}
			acctNums[totalAcctNos] = acctNum;
			totalAcctNos += 1;
		}
	}

	private boolean isAccNoDuplicate(int acctNum) {
		for(int i = 0; i < acctNums.length; i += 1) {
			if(acctNums[i] == acctNum) {
				return true;
			}
		}
		return false;
	}

	//-------------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	//-------------------------------------------------
	public void withdraw(double amount) {
		if (this.balance >= amount) {
			this.balance -= amount;
			total_withdrawal += amount;
			num_withdrawal += 1;
		} else {
			System.out.println("Insufficient funds!");
		}
	}

	//-------------------------------------------------
	// Adds deposit amount to balance.
	//-------------------------------------------------
	public void deposit(double amount) {
		this.balance += amount;
		total_deposit += amount;
		num_deposit += 1;
	}

	//-------------------------------------------------
	// Returns balance.
	//-------------------------------------------------
	public double getBalance() {
		return this.balance;
	}

	//-------------------------------------------------
	// Returns a string containing the name, account number, and balance.
	//-------------------------------------------------
	public String toString() {
		return "Name:" + name +
		"\nAccount Number: " + acctNum +
		"\nBalance: " + this.balance;
	}

	public int getAcctNumber() {
		return acctNum;
	}

	public void printSummary() {
		System.out.println(toString());
	}

	public static int getNumDeposits() {
		return num_deposit;
	}

	public static int getNumWithdrawals() {
		return num_withdrawal;
	}

	public static double getTotalDeposits() {
		return total_deposit;
	}

	public static double getTotalWithdrawals() {
		return total_withdrawal;
	}
}
