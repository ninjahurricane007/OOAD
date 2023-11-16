package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.CustomerAccountConfiguration;
import com.ilp.service.ProductServiceConfiguration;
import com.ilp.service.TransactionConfiguration;


public class AccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Product product=null;
		Customer customer=null;
        ArrayList<Service> serviceList =new ArrayList<Service>(); //Services provided by bank
        ArrayList<Product> productList =new ArrayList<Product>(); //Products provided by bank
        ArrayList<Account> accountList = new ArrayList<Account>();
		char goToMainMenu='y';
		while(goToMainMenu == 'y') {
			System.out.println("\n*******Welcome to Bank*******");
			System.out.println("1.Create Services");
			System.out.println("2.Create Products");
			System.out.println("3.Create Accounts");
			System.out.println("4.Transaction");
			System.out.println("5.Display Accounts");
			System.out.println("6.Transaction Bill");
			System.out.println("7.Exit");
			System.out.print("Enter your choice : ");
			int mainMenuChoice = scanner.nextInt();
			switch(mainMenuChoice) {
				case 1:
					serviceList.add(ProductServiceConfiguration.createServices());
					break;
				case 2:
					productList.add(ProductServiceConfiguration.createProducts(serviceList));
					break;
				case 3:
					customer=CustomerAccountConfiguration.createCustomer(accountList,productList);
					for(Account account : customer.getAccountList()) {
						System.out.println(account.getProduct().getProductName()+" created for "+customer.getCustomerName() + " with the following services" );
						for(Service service : account.getProduct().getServiceList()) {
							System.out.println(service.getServiceCode() + " : "+service.getServiceName());
						}
						System.out.println("Account is active");
					}
					break;
				case 4:
					TransactionConfiguration.accountTransaction(customer);
					break;
				case 5:
					CustomerAccountConfiguration.displayAccounts(customer);
					break;
				case 6:
					CustomerAccountConfiguration.transactionBill(customer);
					break;
				case 7:
					System.exit(0);
					break;
			}
			System.out.println("Do you want to continue(y/n):");
			goToMainMenu = scanner.next().charAt(0);
		}
		
	}

}

