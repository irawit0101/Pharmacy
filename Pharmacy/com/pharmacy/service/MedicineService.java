package com.pharmacy.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.MedicineDaoImpl;
import com.pharmacy.model.Medicine;



public class MedicineService {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		MedicineDaoImpl dao = new MedicineDaoImpl();
		int id, quantity;
		BigDecimal price;
		String name;

		System.out.println("**********WELCOME TO PHARMACY MANAGEMENT SYSTEM**********");
		Medicine med = null;
		int choice;
		String uName = "admin";
		String Pwd = "1234";
		System.out.println("Enter the username: ");
		String user = sc.nextLine();
		System.out.println("Enter the password: ");
		String password = sc.nextLine();
		if(!user.equals(uName) || !password.equals(Pwd)) {
			System.out.println("Invalid Credentials");
		}else {
			do {
				showMenu();
				System.out.println("Enter the choice : ");
				choice = sc.nextInt();
				sc.nextLine();
	
				switch (choice) {
				case 1:
					dao.connect();
					System.out.println("Enter the id of the Medicine: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the name of the medicine: ");
					name = sc.nextLine();
					System.out.println("Enter the price of the medicine: ");
					price = sc.nextBigDecimal();
					System.out.println("Enter the quantity of the medicine: ");
					quantity = sc.nextInt();
					sc.nextLine();
					
					med = new Medicine(id, name, price, quantity);
					dao.createMedicine(med);
					break;
					
				case 2:
					dao.connect();
					List<Medicine> medi = new ArrayList<>();
					medi = dao.showMedicines();
					for(Medicine m : medi) {
						System.out.println(m);
					}
					break;
					
				case 3:
					dao.connect();
					System.out.println("Enter the details to update ");
					System.out.println("Enter the id of the Medicine to update ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the name of the Medicine ");
					name = sc.nextLine();
					System.out.println("Enter the price of the Medicine ");
					price = sc.nextBigDecimal();
					System.out.println("Enter the quantity of the Medicine ");
					quantity = sc.nextInt();
					
					med = new Medicine(id,name, price, quantity);
					dao.upMedicine(med);
					break;
					
				case 4:
					dao.connect();
					System.out.println("Enter the id of the medicine ");
					id = sc.nextInt();
					dao.delMedicine(id);
					break;
					
				case 5:
					dao.connect();
					System.out.println("Enter the id of the medicine to get its details ");
					id = sc.nextInt();
					sc.nextLine();
					Medicine medic = dao.getMedicineByid(id);
					System.out.println(medic);
					break;
					
				case 6:
					dao.connect();
					System.out.println("Enter the id of the medicine to get its name ");
					id = sc.nextInt();
					sc.nextLine();
					String Mname = dao.GetMedicineName(id);
					System.out.println(Mname);
					break;
					
				case 7:
					System.out.println("Thank you");
					break;
					
				default:
					System.out.println("Invalid Input");
				}
				
			} while (choice != 7);
			sc.close();
		}
	}
	
	public static void showMenu() {
		System.out.println();
		System.out.println("1: Add new Medicine ");
		System.out.println("2: Display all the Medicine ");
		System.out.println("3: Update the details of the Medicine ");
		System.out.println("4: Delete a medicine ");
		System.out.println("5: Get a particular medicine details by id");
		System.out.println("6: Get the name of the medicine by providing its id ");
		System.out.println("7: Exit");
	}
}
