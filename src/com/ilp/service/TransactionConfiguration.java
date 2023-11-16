package com.ilp.service;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;
 
public class TransactionConfiguration {
 
	public static void accountTransaction(Customer customer) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("enter custmr code");
		String customerCode = s.nextLine();
		System.out.println("you have followng acnts");
		for (Account account : customer.getAccountList()) {
			System.out.println(
					(customer.getAccountList().indexOf(account) + 1) + " " + account.getProduct().getProductName());
		}
		System.out.println("choose the acnt(index)");
		int choosedAccount = s.nextInt();
		Account selectedAccount = customer.getAccountList().get(choosedAccount - 1);
		System.out.println("select service you want(index)");
		System.out.println("1.Deposit Money 2.Withdraw Money 3.Display Balance");
		int choosedService = s.nextInt();
		switch (choosedService) {
		case 1:
			TransactionConfiguration.depositMoney(selectedAccount);
			break;
		case 2:
			TransactionConfiguration.withdrawMoney(selectedAccount);
			break;
		case 3:
			CustomerAccountConfiguration.displayAccounts(customer);
			break;
		}
	}
 
	private static void withdrawMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		SavingsMaxAccount savingsMaxAccount=null;
		Scanner s = new Scanner(System.in);
		double balance = selectedAccount.getAccountBalance();
		double amount = 0;
 
		if (selectedAccount.getProduct() instanceof SavingsMaxAccount) {
			savingsMaxAccount = (SavingsMaxAccount) selectedAccount.getProduct();
			double minBalance = savingsMaxAccount.getMinimumBalance();
			System.out.println("Enter the amount to withdraw");
			amount = s.nextDouble();
			if ((balance-amount)<minBalance){
				while((balance-amount)<minBalance) {
					System.out.println("Cannot withdraw the money. Minimum balance of 1000 rupees has to be kept");
					System.out.println("Enter another amount");
					amount=s.nextDouble();
				}
			}
			balance = balance - amount;
			selectedAccount.setAccountBalance(balance);
		} 
		
		else {
			System.out.println("Enter the amount to withdraw"); // loan and currnt
			amount = s.nextDouble();
			balance = selectedAccount.getAccountBalance();
			balance = balance - amount;
			selectedAccount.setAccountBalance(balance);
		}
	}
 
	private static void depositMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		SavingsMaxAccount savingsMaxAccount = null; 
		double balance = selectedAccount.getAccountBalance();
 
		LoanAccount loanAccount = null; 
		if (selectedAccount.getProduct() instanceof LoanAccount) {
			loanAccount = (LoanAccount) selectedAccount.getProduct();
			double rate = loanAccount.getRate();
			System.out.println("1.On The Counter Deposit 2.Cheque Deposit");
			System.out.println("Choose the option");
			int choice = s.nextInt();
			double amount;
			switch (choice) {
			case 1:
				System.out.println("Enter the amount to be deposited");
				amount = s.nextDouble();
				balance = balance + amount;
				selectedAccount.setAccountBalance(balance);
				break;
			case 2:
				System.out.println("Enter the amount to be deposited");
				amount = s.nextDouble();
				balance = balance + amount;
				balance = balance - (balance * rate);
				selectedAccount.setAccountBalance(balance);
				break;
			}
		} 
		
		else { 
			double amount;
			System.out.println("Enter the amount to be deposited");
			amount = s.nextDouble();
			balance = balance + amount;
			selectedAccount.setAccountBalance(balance);
		}
	}
}