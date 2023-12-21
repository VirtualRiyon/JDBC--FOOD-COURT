package jdbc2.controller;

import java.util.Scanner;

import jdbc2.dao.UserCrud;
import jdbc2.dto.User;

public class UserController {

	public static void main(String[] args) throws Throwable {
		Scanner sc=new Scanner(System.in);
		UserCrud crd= new UserCrud();
		boolean check=true;
		do {
			System.out.println("Welcome...........");
			System.out.println();
			System.out.println("Enter Your choice \n 1)Register \n 2) login \n 3) exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter The name:-");
				String name=sc.next();
				System.out.println("Enter the email:-");
				String emial=sc.next();
				System.out.println("Enter the phno:-");
				int phno=sc.nextInt();
				System.out.println("enter the password:-");
				String password=sc.next();
				System.out.println("enter the wallet money");
				int wallet =sc.nextInt();
				System.out.println("enter the Age:-");
				int age=sc.nextInt();
				System.out.println("enter the gender:-");
				String gender=sc.next();
				
				User user=new User(name,emial,phno,password,wallet,age,gender);
				crd.register(user);
			}break;
			case 2:{
				System.out.println("Enter The mail:-");
				String email=sc.next();
				System.out.println("Enter The password:-");
				String password=sc.next();
				
				User user=new User(email,password);
		    	if(crd.login(user)) {
		    		System.out.println("\u001B[32mLogin Successfull...................."+"\u001B[0m");
		    		crd.items();
		    		boolean check2=true;
		    		double bill=0;
		    		do {
		    			System.out.println("choose the option \n 1) place an order \n 2) exit");
		    			int choice2=sc.nextInt();
		    			
		    			switch(choice2) {
		    			case 1:{
		    				System.out.println("enter the food item");
		    				int item1=sc.nextInt();
		    				System.out.println("enter the quantity");
		    				int quan=sc.nextInt();
		    				
		    				
		    				bill+=crd.Bill(item1, quan);
		    			}break;
		    			case 2: {
		    				check2=false;
		    			}
		    			}
		    		}while(check2);
		    		double wallet=crd.wallet(email);
		    		System.out.println("your current balance is :- " +wallet);
		    		System.out.println("your bill is :-" +bill);
		    		if(wallet>bill) {
		    			wallet-=bill;
		    			crd.updatePrice(wallet, email);
		    			System.out.println("your updated balance is :- "+wallet);
		    			System.out.println("***************************");
		    			System.out.println("Thank you for visiting....!");
		    		}
		    		else {
		    			 System.err.println("insufficient balance......");
		    			 System.out.println("Enter the valid amount");
		    			 System.out.println("enter the amount to added");
		    			 double amount=sc.nextDouble();
		    			 wallet+=amount;
		    			 crd.updatePrice(wallet, email);
		    			 System.out.println("your total:- "+wallet);
		    			 wallet-=bill;
		    			 crd.updatePrice(wallet, email);
		    			 wallet=crd.wallet(email);
		    			 System.out.println("Your updated wallet is:- "+wallet);
		    		}
		    	}else {
		    		System.err.println("enter the correct details");
		    	}
			}break;
			case 3:{
				check=false;
			}break;
			default:System.out.println("enter the correct option........");
			}
		}while(check);

	}

}
