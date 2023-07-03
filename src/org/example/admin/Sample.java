package org.example.admin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.example.userdomain.Detail;
import org.example.userdomain.Login;
import org.example.userdomain.Reservation;

public class Sample{
	Reservation b = new Reservation();
	Login a = new Login();
	Scanner sc = new Scanner(System.in);

	// Method for user management
	public void manage() throws IOException {
		int ch;
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("UserData.txt", true));
		DataInputStream dis = new DataInputStream(new FileInputStream("UserData.txt"));

		System.out.println("\n---WELCOME TO THE USER MANAGEMENT MENU---\n");
		do {
			System.out.println("1. Add User details\n");
			System.out.println("2. Display details\n");
			System.out.println("3. Return to the main\n");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				try {
					a.getid();
					dos.writeUTF(a.id);
					dos.writeUTF(a.pass);
					System.out.println("\n*****************User details added succesfully!!*************");
				} catch (FileNotFoundException e ) {
					System.out.println("Cannot open the output file!!");
					return;
				}
				break;

			case 2:
				// if any data available in file
			
				System.out.printf("\n|%-15s|%-10s\n", "User ID","Password");
				while (dis.available() > 0) {
					try {
						System.out.printf("\n|%-15s|%-10s",dis.readUTF(),dis.readUTF());
					} catch (Exception e) {
						System.out.println(e);
					}
				}
				break;
			}
		} while (ch <= 2);
		dos.close();
		dis.close();

	} // end of manage method

	// Method for user login[only for user choice]
	public void user() throws IOException {

		DataInputStream dis = new DataInputStream(new FileInputStream("UserData.txt"));

		int ch;
		int d = 0;
		String password;
		String id;

		System.out.println("\n-----Login-----\n");

		System.out.println("Enter your ID : ");
		id = sc.nextLine();
		System.out.println("Enter your Password : ");
		password = sc.nextLine();
           
		try {
			while (dis.available() > 0) {

				String idReal = dis.readUTF();
				String passReal = dis.readUTF();

				if ((idReal.equals(id)) && (passReal.equals(password))) {
					do {
						System.out.println("\n1.Reservation\n2.Cancel\n3.Enquiry\n4.Return to the main menu\n");
						System.out.println("Enter your choice:");
						ch = sc.nextInt();
						switch (ch) {
						case 1:
							reserve();
							break;
						case 2:
							cancel();
							break;
						case 3:
							enquiry();
							break;
						}
					} while (ch <= 3);
				} else {
					d = 1;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (d == 1) {
			System.out.println("Enter your user id and password correctly\n");
		}

		dis.close();
	}// end of user method

	public void cancel() {
		System.out.print("\n\nEnter passenger id to cancel the ticket: ");
		int id = sc.nextInt();
		
		System.out.println("Ticket cancelled!!");
	}

	//  Method for handling admin operations after login menu [choice 1]
	public void database() throws IOException {

		Detail a = new Detail();
		Scanner sc = new Scanner(System.in);

		DataOutputStream dos = new DataOutputStream(new FileOutputStream("TrainData.txt", true));
		DataInputStream dis = new DataInputStream(new FileInputStream("TrainData.txt"));

		int ch;
		String password;
		String pass = "Rohit@123";

		System.out.println("\nEnter the Admin Password: ");
		password = sc.nextLine();

		if (!(pass.equals(password))) {
			System.out.println("Enter the password correctly!");
			System.out.println("You are not permitted to login this mode\n");
		}

		else {
			do 
				//Entering to admin area.
			{
				System.out.println("\n --- ADMINISTRATOR MENU ---");
				System.out.println("1. Add Train details ");
				System.out.println("2. Display Train details ");
				System.out.println("3. User Management ");
				System.out.println("4. Display Passenger details ");
				System.out.println("5. Return to Main Menu ");
				System.out.println("Enter your choice : ");
				ch = sc.nextInt();

				switch (ch) {
				case 1:
					try {
						a.getDetail();

						dos.writeLong(a.trainNo);
						dos.writeUTF(a.trainName);
						dos.writeUTF(a.boardingPt);
						dos.writeUTF(a.destinationPt);

						dos.writeInt(a.day);
						dos.writeInt(a.month);
						dos.writeInt(a.year);
						System.out.println("\n*****************Train details added succesfully!!*************");
					} catch (FileNotFoundException e) {
						System.out.println("Cannot open the output file!!");
						return;
					}
					break;

				case 2:
					display();
					break;

				case 3:
					manage();
					break;

				case 4:
					passengerDisplay();
					break;
				}
			} while (ch <= 4);
			dos.close();
			dis.close();
			sc.close();
		}
		
	}
		
	// end of database method

	public void passengerDisplay() throws IOException {

		DataInputStream dis1 = new DataInputStream(new FileInputStream("PassengerData.txt"));

		System.out.println(" ********List of passenger*********");
		System.out.println(" ============================================================");
		System.out.printf("\n|%-15s|%-13s|%-10s|%-10s", "Passenger Name", "PRN No", "Seat No", "Train No");

		while (dis1.available() > 0) {
			try {
				System.out.printf("\n|%-15s|%-13d|%-10d|%-10d", dis1.readUTF(), dis1.readInt(),dis1.readInt(),dis1.readLong());
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		dis1.close();
	}

	// Method for display train details
	public void display() throws IOException {
		try (DataInputStream dis = new DataInputStream(new FileInputStream("TrainData.txt"))) {
			System.out.printf("\n|%-12s|%-20s|%-15s|%-20s|%-15s", "Train No", "Train Name", "Borading pt", "Destination pt",
					"Day-Month-Year");
			while (dis.available() > 0) {

				try {


					System.out.printf("\n|%-12d|%-20s|%-15s|%-20s|%02d-%02d-%04d", dis.readLong(), dis.readUTF(),
							dis.readUTF(), dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt());

				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		}
	}

	//  Method for displaying reservation menu 
	public void reserve() throws Exception {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("PassengerData.txt", true));
		try {
			b.getReservationDetail();

			dos.writeUTF(b.passengerName);
			dos.writeInt(b.passengerId);
			dos.writeInt(b.seatNo);
			dos.writeLong(b.trainNumber);
			dos.flush();
			System.out.println("\n*****************Ticket reserved succesfully!!*************");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the output file!!");
			
		}
		dos.close();
	}// End of reserve method

	//  Method for displaying train details in user menu 
	public void enquiry() throws IOException {
		display();
	}// End of enquiry method
}
