package org.example.main;
import java.util.Scanner;

import org.example.admin.Sample;

public class RailwayReservationSystem  {
	
	public static void main(String args[]) throws Exception{
		Sample sample=new Sample();
		 Scanner sc = new Scanner(System.in);
		 int ch;

		 System.out.println("----- RAILWAY RESERVATION SYSTEM ----- \n");
		 do{
			 System.out.println("\n MAIN MENU \n");
			 System.out.println("1.Admin mode\n2.Reserve and Cancel Ticket for user\n3.Exit \n");

			 System.out.println("Enter your choice : ");
			 ch = sc.nextInt();

			 switch(ch){
			 	case 1:
			 	    sample.database();
			 		break;
			 	case 2:
			 		sample.user();
			 		break;
			 	default:
			 		break;
			 }
			 
		 } while(ch<3);
		 sc.close();
		
	}
	
}




