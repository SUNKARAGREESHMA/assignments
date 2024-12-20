package JAVA_FULLSTACK;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class company {
    public static void main(String[] args) {
        double[] salaries = {32000, 45000, 37000, 36000, 76000, 80000, 50000, 33000, 85000};

        System.out.println("Employees salary less than 40000:");
        Arrays.stream(salaries)
                .filter(salary -> salary < 40000)
                .forEach(salary -> System.out.println("Salary: " + salary));

      
        System.out.println("Employees salary more than 75000:");
        Arrays.stream(salaries)
                .filter(salary -> salary > 75000)
                .forEach(salary -> System.out.println("Salary: " + salary));

      
        System.out.println(" 10% increment for 33000-37000 range:");
        Arrays.stream(salaries)
                .map(salary -> (salary >= 33000 && salary <= 37000) ? salary * 1.10 : salary)
                .forEach(salary -> System.out.println("Updated Salary: " + salary));

 
        double averageSalary = Arrays.stream(salaries)
                .average()
                .orElse(0);
        System.out.println("Average salary: " + averageSalary);

       
        double yearlyTurnover = averageSalary * salaries.length;
        System.out.println("Company yearly turnover: " + yearlyTurnover);

     
        System.out.println("Salaries in descending order:");
        
        Arrays.stream(salaries)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(salary -> System.out.println("Salary: " + salary));

    }
}

