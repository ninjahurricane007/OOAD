# OOAD

##Domain: Banking

Use case : When a customer attempts to deposit money, the list of all accounts which the customers possess should be listed so that the customer can select to which account he would like to deposit the money. Customer can have the following accounts

###SavingsMaxAccount

###CurrentAccount

###LoanAccount

· Customer(customerCode,customerName,List<Account>)

· Account(accountNo,accountType,balance,Product).

· Product(productCode,productName,List<Service>)

· SavingsMaxAccount is a Product(minimumBalance of Rs1000 should be maintained in the account)

· CurrentAccount is a Product

· LoanAccount is a Product.(chequeDeposit should be chargeable ie).3%).

· Service(serviceCode,serviceName,rate)

##Default services

SavingsMaxAccount(CashDeposit. ATMWithdrawl,OnlineBanking)

CurrentAccount(CashDeposit,OnlineBanking,ATMWithdrawl,MobileBanking)

LoanAccount(CashDeposit,ChequeDeposit)


##Class Diagram

![model umlcd](https://github.com/ninjahurricane007/OOAD/assets/67139570/a51f79b0-6352-4448-9bc1-d7bba5baf5eb)

