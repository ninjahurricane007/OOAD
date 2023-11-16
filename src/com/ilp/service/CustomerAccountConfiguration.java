package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class CustomerAccountConfiguration {

	public static Customer createCustomer(ArrayList<Account> accountList,ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char choice = 'y';
		
		System.out.println("Create a new Account"); 
		System.out.println("Enter Customer Code:-");
		String customerCode = scanner.nextLine();
		System.out.println("Enter Customer Name:-");
		String customerName = scanner.nextLine();
		do {
//			System.out.println("\nCreate a new Account"); 
			System.out.println("*******Accounts Available*******");
			for(Product product : productList) {
				System.out.println(product.getProductCode() + ":"+ product.getProductName());
			}
			
			accountList.add(CustomerAccountConfiguration.createAccount(productList));
			System.out.println("Do you want to create another account?(y/n)");
			choice = scanner.next().charAt(0);

		} while (choice == 'y');
		
		return new Customer(customerCode,customerName,accountList);
	}

	private static Account createAccount(ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter choice(Enter product code):-");
        String choiceOfProduct = scanner.nextLine();
		
		System.out.println("Enter account No:-");
		String accountNo = scanner.nextLine();
		System.out.println("Enter the balance:-");
		double accountBalance = scanner.nextDouble();
		scanner.nextLine();
		Product choosedProduct=null;
	    for (Product product : productList) {
	        if (product.getProductCode().equalsIgnoreCase(choiceOfProduct)) {
	        	choosedProduct = product;
	            break;
	        }
	    }
		
	    if (choosedProduct == null) {
            System.out.println("Product not found.");
            return null;
        }	
		return new Account(accountNo,accountBalance,choosedProduct);
	}

	public static void displayAccounts(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("*************************Customer-Account Details****************");
		System.out.println("CustomerId\t\tCustomerName\t\tAccountType\t\tBalance");
		System.out.println("***************************************************************");
		for(Account account : customer.getAccountList()) {
			System.out.println(customer.getCustomerCode()+"\t\t"+customer.getCustomerName()+"\t\t"+account.getProduct().getProductName()+"\t\t"+account.getAccountBalance());
		}
		for(Account account : customer.getAccountList()) {
			System.out.println("Services for "+customer.getCustomerName());
			ArrayList<Service> selectedServiceList = account.getProduct().getServiceList();
			for(Service service : selectedServiceList) {
				System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
			}
		}
	}

	public static void transactionBill(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer Code:");
		String customerCode = scanner.nextLine();
		System.out.println(customer.getCustomerName()+ " has the following accounts:");
		for(Account account : customer.getAccountList()) {
			System.out.println((customer.getAccountList().indexOf(account) +1)+"." +account.getProduct().getProductName());
		}	
		System.out.println("Enter your choice:");
		int accountChoice = scanner.nextInt();
		System.out.println("Choose the Service you want to use :");
		Account selectedAccount = customer.getAccountList().get(accountChoice-1);
		ArrayList<Service> selectedServiceList = selectedAccount.getProduct().getServiceList();
		for(Service service : selectedServiceList) {
			System.out.println((selectedServiceList.indexOf(service)+1) +"." +service.getServiceName());
		}
		System.out.println("Enter your choice:");
		int selectedService = scanner.nextInt();
		System.out.print("Enter the number of  transactions");
		int numberOfTransactions = scanner.nextInt();
		double rate = selectedServiceList.get(selectedService-1).getRate();
		System.out.println("Total amount of transaction : "+ numberOfTransactions*rate);
	}
	
	
	
}
