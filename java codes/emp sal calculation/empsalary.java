package JAVA_FULLSTACK;
import java.util.*;
public class empsalary {
    public static void main(String[] args) {

    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter no.of employees");
    	int noofemp=sc.nextInt();
    	double[] salaries=new double[noofemp];
    	System.out.println("enter salaries of employees");
    	for(int i=0;i<noofemp;i++) {
    		salaries[i]=sc.nextDouble();
    	}
//        double[] salaries = {15000, 20000, 30000, 28000, 12000, 18000, 35000, 25000, 14000, 16000};
 
        for (int i = 0; i < salaries.length; i++) {
            double currentSalary = salaries[i];

            if (currentSalary >= 30000) {
                currentSalary += currentSalary * 0.10; // 10% increment
                System.out.println("Employee " + (i + 1) + ": Salary increment. New Salary = " + currentSalary);
            }
 
            if (currentSalary == 20000) {
                currentSalary += 2000; // 2000 bonus
                System.out.println("Employee " + (i + 1) + ": Bonus . New Salary = " + currentSalary);
            }
 

            if (currentSalary < 15000) {
                System.out.println("Employee " + (i + 1));
            }
 
            double hra = currentSalary * 0.10; 
            double ta = currentSalary * 0.05; 
            double da = currentSalary * 0.08;  
 
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("  Salary after adjustments: " + currentSalary);
            System.out.println("  House Rent Allowance HRA: " + hra);
            System.out.println("  Travel Allowance TA: " + ta);
            System.out.println("  Dearness Allowance DA: " + da);
            System.out.println("  Total Earnings: " + (currentSalary + hra + ta + da));
            System.out.println();
        }
    }
}





