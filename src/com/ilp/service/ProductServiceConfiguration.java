package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductServiceConfiguration {

	public static Service createServices() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("What additional service you want to add:");
		System.out.println("Eg: Internet Banking,ATM WIthdrawal,Online Banking\n");
		System.out.println("Enter Service Code: ");
		String serviceCode = scanner.nextLine();
		System.out.println("Enter Service Name: ");
		String serviceName = scanner.nextLine();
		System.out.println("Enter transaction rate: ");
		double rate  = scanner.nextDouble();
		return new Service(serviceCode,serviceName,rate);
	}

	public static Product createProducts(ArrayList<Service> serviceList) {
		// TODO Auto-generated method stub
		ArrayList<Service> serviceListForProduct = new ArrayList<Service>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("What product you want to add:");
		System.out.println("Eg:Savings Account,Current Account,Loan Account\n");
		Product product=null;
		System.out.println("Enter Product Code:");
		String productCode = scanner.nextLine();
		System.out.println("Enter Product Name: ");
		String productName = scanner.nextLine();
		
		char continueToChoose = 'y';
		do {
			System.out.println("Choose service you want to add to product(Enter Service Code)");
			for(Service service : serviceList) {
				System.out.println(service.getServiceCode() + ":"+ service.getServiceName());
			}
			scanner.nextLine();
			String choiceOfService = scanner.nextLine();
	        for (Service service : serviceList) {
	            if (service.getServiceCode().equals(choiceOfService)) {
	                serviceListForProduct.add(service);
	                break;
	            }
	        }
			System.out.println("Do you want to add another service?(y/n)");
			continueToChoose = scanner.next().charAt(0);
		}while(continueToChoose=='y');
		
		if(productName.equalsIgnoreCase("Savings Account")) {
			product =  new SavingsMaxAccount(productCode,productName,serviceListForProduct);
		}
		else if(productName.equalsIgnoreCase("Current Account")) {
			product =  new CurrentAccount(productCode,productName,serviceListForProduct);
		}
		else if(productName.equalsIgnoreCase("Loan Account")) {
			product =  new LoanAccount(productCode,productName,serviceListForProduct);
		}
		return product;
	}

}