package org.example.userdomain;

import java.io.IOException;
import java.util.Scanner;

//reservation class Reservation details
public class Reservation {

	
	public String passengerName;
	public int seatNo,passengerId;
	public long trainNumber;
	public int amount;

	Scanner sc=new Scanner(System.in);
	public void getReservationDetail() throws IOException
	{
		
	System.out.print("\n\n Enter passenger name: ");
	passengerName=sc.nextLine();
	System.out.print(" Enter passenger id=");
	passengerId=sc.nextInt();
	System.out.print(" Enter passenger seat no=");
	seatNo=sc.nextInt(); 
	System.out.print(" Enter passenger train no=");
	trainNumber=sc.nextLong();

 amount = seatNo+ 200;
 System.out.println("You should pay: "+ amount + "rs");
	   
	}
	
}