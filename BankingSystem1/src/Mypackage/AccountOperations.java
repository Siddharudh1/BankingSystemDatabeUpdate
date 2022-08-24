package Mypackage;

import java.util.HashMap;
import java.util.Map;

public class AccountOperations {
	Map<String, Account> map = new HashMap<String, Account>();
	public void createCustomerAccount(String id,String firstName, String userName, String lastName, String age, String address,
			String mobileNumber, String emailId,String dateOfBirth, double balance) 
	{
		long pin = (long) (Math.random()*10000);
		System.out.println("Pin generated is :"+pin);
		long accNumber = (long)(Math.random()*1000000000);
		System.out.println("Account Number :"+accNumber);
		
		Account a1 = new Account(id,firstName,userName,lastName,age, address,mobileNumber, emailId,dateOfBirth,pin, balance);
		map.put(id, a1);
		System.out.println(map);
		System.out.println("Account created successfully...");
	}
	public void addMoney(String id,double amount) {
		for(Map.Entry<String, Account> entry : map.entrySet()) {
			String id1 = entry.getKey();
			Account acc1 = entry.getValue();
			if(id1.equals(id)) {
				double bal = acc1.getBalance()+amount;
				System.out.println("amount "+amount+" credited successfully,total balnce is "+bal);
				acc1.setBalnce(bal);
			}
			/*else {
				System.out.println("Invalid Id");
			}*/
		}
	}
	public void withDrawMoney(String id,double amount) {
		for(Map.Entry<String, Account> entry : map.entrySet()) {
			String id2 = entry.getKey();
			Account acc2 = entry.getValue();
			if(id2.equals(id)||amount>acc2.getBalance()) {
				double bal = acc2.getBalance()-amount;
				System.out.println("amount "+amount+" withdraw successfully.....");
				acc2.setBalnce(bal);
			}
			/*else {
				System.out.println("Invalid Id");
			}*/
		}
	}
	
	public void closeAccount(String id,long pin) {
		for(Map.Entry<String, Account> entry : map.entrySet()) {
			String id3 = entry.getKey();
			Account acc3= entry.getValue();
			 if(id3.equals(id) && acc3.getPin() == pin )
 	        {
 	        	map.remove(id);
 	        	System.out.println("Account closed successfully");
 	        }
			 /*else {
				 System.out.println("Invalid Id or Pin");
			 }*/
		}
	}
	
	public void viewBalnce(String id,String username,long pin) {
		for(Map.Entry<String, Account> entry : map.entrySet()) {
			String id4 = entry.getKey();
			Account acc4 = entry.getValue();
			if(id4.equals(id) && acc4.getUsername().equals(username)&& acc4.getPin() == pin) {
				System.out.println("Current balance= "+acc4.getBalance());
			}
		}
	}
	public void withDrawMoney(String id,String username,long pin ,double amount) {
		for(Map.Entry<String, Account> entry : map.entrySet()) {
			String id5 = entry.getKey();
			Account acc5 = entry.getValue();
			if(id5.equals(id) && acc5.getUsername().equals(username)&& acc5.getPin() == pin && amount < acc5.getBalance()) {
				double bal = acc5.getBalance()-amount;
				System.out.println("The "+amount+" withdraw successfully available balance is :"+bal);
				acc5.setBalnce(bal);
			}
			/*else {
				System.out.println("Invalid id or username or pin or insufficient balance to withDraw");
			}*/
		}
	}
	
}
