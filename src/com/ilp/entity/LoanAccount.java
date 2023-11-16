package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	double rate=0.03;

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}

}
