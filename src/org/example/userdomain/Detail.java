package org.example.userdomain;

import java.util.Scanner;

//Detail class Adding train details
public class Detail {
	public long trainNo;
	public String trainName;
	public String boardingPt;
	public String destinationPt;

	public int day, month, year;


	//  Method for getting train details
	public void getDetail() {
		try (Scanner sc = new Scanner(System.in)) {
           try {
				System.out.println("\n--Add New details--\n");

				System.out.println("Train no: ");
				trainNo = sc.nextLong();
				
				System.out.println("Train Name: ");
				trainName = sc.nextLine();
				trainName = sc.nextLine();
				System.out.println("Boarding point: ");
				boardingPt = sc.nextLine();

				System.out.println("Destination pt: ");
				destinationPt = sc.nextLine();

				System.out.println("Date of travel\n");
				System.out.println("Day: ");
				day = sc.nextInt();

				System.out.println("Month: ");
				month = sc.nextInt();

				System.out.println("Year: ");
				year = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e);
				
			}
			sc.close();
		}
		
	}
}


