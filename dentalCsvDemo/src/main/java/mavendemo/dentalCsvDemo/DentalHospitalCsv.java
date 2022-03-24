package mavendemo.dentalCsvDemo;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


public class DentalHospitalCsv {
	int num;
	String name,address,date;
	static ArrayList<appointmentCsv> a1=new ArrayList<appointmentCsv>();
//	final String CSV_LOCATION = "src/main/resources/hospital.csv";
//	void add_appointment() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter Appointmnet Number ");
//		num=sc.nextInt();
//		System.out.print("Enter Patient Name");
//		name=sc.next();
//		System.out.print("Event Patient Address");
//		address=sc.next();
//		System.out.print("Event Appointment Date ");
//		date=sc.next();
//	}
//	
//	void CsvUpdate() {
//		DentalHospitalCsv dh = new DentalHospitalCsv();
//		try {
//
//			FileWriter writer = new FileWriter(CSV_LOCATION);
//			ColumnPositionMappingStrategy mappingStrategy=new ColumnPositionMappingStrategy();
//			mappingStrategy.setType(appointmentCsv.class);
//			String[] columns = new String[]{ "ap_no", "p_name", "p_address", "date" };
//			mappingStrategy.setColumnMapping(columns);
//
//			StatefulBeanToCsvBuilder<appointmentCsv> builder=new StatefulBeanToCsvBuilder(writer);
//			StatefulBeanToCsv<appointmentCsv> beanWriter =builder.withMappingStrategy(mappingStrategy).build();
//
//			beanWriter.write(a1);
//			writer.close();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		int a=1,input,choice=0;
		Scanner sc = new Scanner(System.in);
		DentalHospitalCsv dh = new DentalHospitalCsv();
		App app = new App();
		
		while(a==1) {
			System.out.println();
			System.out.print("Enter Your Choice : \n 1.Add Appoinment \n 2.View Appoinment\n 3.Delete Appoinment\n 4.Search\n 5.Update Appoinment\n 6.Exit\n ");
			choice =sc.nextInt();
		
			if(choice==1) {
				
				app.add_appointment();
				appointmentCsv ap = new appointmentCsv(app.num,app.name,app.address,app.date);
				dh.a1.add(ap);  //adding obj ap in array a1
				a1=app.CsvUpdate(a1);
				
			}
			if (choice==2) {
				if (a1.size()==0) {
					System.out.println("No Records Found !!");
				}
				else
				{
					System.out.println();
					System.out.println("Ap_Number"+"\t "+"Patient_Name"+"\t"+"Address"+"\t"+"\t"+" Date");
					System.out.println();
					for (appointmentCsv apt : a1) {
						System.out.println(apt.getAp_no()+"\t "+"\t "+apt.getP_name()+"\t"+"\t "+apt.getP_address()+"\t"+"\t "+apt.getDate());
					}
					System.out.println();
				}
			}
			if(choice==3) {

				System.out.println("Enter the appointment number you want to Delete");
				input=sc.nextInt();
				int count=0;
				for (appointmentCsv apt : a1) {
					if (apt.getAp_no()==input) {
						a1.remove(apt);
						System.out.println();
						System.out.println("Appointment Deleted Succesfully !!");
						System.out.println();
						count++;
						break;
					}
				}
				if (count==0) {
					System.out.println("Record Does not Exist !!");
				}
				a1=app.CsvUpdate(a1);
			}
			if(choice==4) {
				int count=0;
				System.out.println("Enter the date of Appointment");
				String in=sc.next();
				for (appointmentCsv apt1 : a1) {
					if (apt1.getDate().equals(in)) {
						System.out.println("Ap_Number"+"\t "+"Patient_Name"+"\t"+"Address"+"\t"+"\t"+" Date");
						break; //For printing heading
					}
				}
				for (appointmentCsv apt : a1) {
					if (apt.getDate().equals(in)) {
						System.out.println(apt.getAp_no()+"\t "+"\t "+apt.getP_name()+"\t"+"\t "+apt.getP_address()+"\t"+"\t "+apt.getDate());
						count++;
					}
				}
				if (count==0) {
					System.out.println("No Appointments on this Date !!");
				}
			}
			if(choice==5) {
				int count=0;
				System.out.println("Enter Patient's Appointment Number");
				input=sc.nextInt();
				for (appointmentCsv apt : a1) {
					if (apt.getAp_no()==input) {
						System.out.println("Enter Next Date of the Appointment :");
						String in =sc.next();
						apt.setDate(in);
						count++;
					}
				}
				if (count==0) {
					System.out.println("Invalid Appointment Number !!");
				}
				a1=app.CsvUpdate(a1);  //passing array a1 to app.java
			}
			if(choice==6) {
				break;
			}
	}
	}
}
