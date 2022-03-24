package mavendemo.dentalCsvDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	int num;
	String name,address,date;
	final String CSV_LOCATION = "src/main/resources/hospital.csv";
	
	void add_appointment() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Appointmnet Number ");
		num=sc.nextInt();
		System.out.print("Enter Patient Name");
		name=sc.next();
		System.out.print("Event Patient Address");
		address=sc.next();
		System.out.print("Event Appointment Date ");
		date=sc.next();
	}
	
	public ArrayList CsvUpdate(ArrayList<appointmentCsv> a1) {
		try {

			FileWriter writer = new FileWriter(CSV_LOCATION);
			ColumnPositionMappingStrategy mappingStrategy=new ColumnPositionMappingStrategy();
			mappingStrategy.setType(appointmentCsv.class);
			String[] columns = new String[]{ "ap_no", "p_name", "p_address", "date" };
			mappingStrategy.setColumnMapping(columns);

			StatefulBeanToCsvBuilder<appointmentCsv> builder=new StatefulBeanToCsvBuilder(writer);
			StatefulBeanToCsv<appointmentCsv> beanWriter =builder.withMappingStrategy(mappingStrategy).build();

			beanWriter.write(a1);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return a1;
	}
    public static void main( String[] args )
    {
    			
    		}
    
}
