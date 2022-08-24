package Mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerAccountDatabBase {
	private static Connection conn =null;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerAccountDatabBase id = new CustomerAccountDatabBase();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3307/customerdatabase";
			String user="root";
			String password="siddu@123";
			
			conn =DriverManager.getConnection(url,user,password);
			System.out.println("-----------------------------------------");
			System.out.println("press 1 to create customer Account");
			System.out.println("press 2 to Bank opearation to AddMoney , WithdrawMoney, CloseAccount");
			System.out.println("press 3 to ATM operation to ViewBalance,WithdrawBalance");
			System.out.println("Enter your choice");
			int choice  = Integer.parseInt(scanner.nextLine());
			
			switch (choice) {
			case 1:
					id.createCustomerAccount();
					break;
				
			case 2:System.out.println();
					break; 
			case 3:System.out.println();
					break;
			default:System.out.println("enter the valid number");
				break;
			}
		}
		catch(Exception e) {
			throw new RuntimeException("something went wrong....");
		}
	}
	public void createCustomerAccount() throws SQLException{
		String sql ="insert into customer(id,first_name,user_name,last_name,age,address,mobile_number,email_id,date_of_birth,balance) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		System.out.println("Enter customerId");
		stmt.setString(1, scanner.nextLine());
		
		System.out.println("Enter firstName");
		stmt.setString(2, scanner.nextLine());
		
		System.out.println("Enter userName");
		stmt.setString(3, scanner.nextLine());
		
		System.out.println("Enter lastName");
		stmt.setString(4, scanner.nextLine());
		
		System.out.println("Enter age");
		stmt.setString(5, scanner.nextLine());
		
		System.out.println("Enter address");
		stmt.setString(6, scanner.nextLine());
		
		System.out.println("Enter mobileNumber");
		stmt.setString(7, scanner.nextLine());
		
		System.out.println("Enter emailId");
		stmt.setString(8, scanner.nextLine());
		
		System.out.println("Enter dateOfBirth");
		stmt.setString(9, scanner.nextLine());
		
		System.out.println("Enter minimum balance");
		stmt.setString(10, scanner.nextLine());
		
		int rows = stmt.executeUpdate();
		if(rows>0) {
			System.out.println("Records inserted successfully.....");
		}
	}

}
