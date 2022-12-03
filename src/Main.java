import model.Employee;
import model.OfficeTime;
import services.TimeCalculator;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    
    static HashMap<String, Employee> employees;
    
    public static void main(String[] args) {

        employees = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        TimeCalculator timeCalculator = new TimeCalculator();

        System.out.println("Welcome to Work Time Decider");

        while(true) {
            System.out.println("Enter any from below options :" +
                    "\n 1 for New Employee Details" +
                    "\n 2 for Employee List"+
                    "\n 3 to Know Employee Work Time" +
                    "\n 4 to delete existing Employee");


            String input = scanner.nextLine();

            switch(input) {
                case "1" :
                    getEmployee(scanner, employees);
                    break;
                case "2":
                    if(employees.size() == 0){
                        System.out.println("No Employee Exists !! ");
                        break;
                    }
                    System.out.println("Employee List : ");
                    for(Employee e : employees.values()) {
                        System.out.println(e);
                    }
                    break;
                case "3":
                    System.out.println("Enter employee Id to Know his work time : ");
                    String eId = scanner.nextLine();
                    if(employees.containsKey(eId)){
                        timeCalculator.calculate(employees.get(eId));
                    }
                    else{
                        System.out.println("Employee does not exist!!");
                    }
                    break;
                case "4" :
                    System.out.println("Enter employeeId of the employee whom you want to delete : ");
                    String eid = scanner.nextLine();
                    if(employees.containsKey(eid)){
                        employees.remove(eid);
                    }
                    else{
                        System.out.println("Employee does not exist!!");
                    }
                default :
                    System.out.println("Sorry, Wrong Input!! Please enter correct details.");
            }
            System.out.println("----------------------------------------------------\n");
        }
    }

    private static void getEmployee(Scanner scanner, HashMap<String,Employee> list) {
        System.out.println("Add new Employee :");
        System.out.println("Enter employee name : ");
        String name = scanner.nextLine();
        System.out.println("Enter employee Id : ");
        String employeeId = scanner.nextLine();
        System.out.println("Enter "+name+" entry Time :");
        String inTime = scanner.nextLine();
        System.out.println("Enter "+name+" exit Time :");
        String outTime = scanner.nextLine();

        // check entry time and exit time as well
        if(list.containsKey(employeeId)){
            System.out.println("Employee already exists !!");
        }
        else if(timeFormatChecker(inTime)){
            System.out.println("InTime format is not correct !!");
        }
        else if(timeFormatChecker(outTime)){
            System.out.println("OutTime format is not correct !!");
        }
        else if(ifNumber(employeeId)){
            list.put(employeeId,new Employee(Integer.parseInt(employeeId), name, new OfficeTime(inTime), new OfficeTime(outTime)));
        }
        else{
            System.out.println("EmployeeId must be numeric...");
        }
    }

    public static boolean timeFormatChecker(String time) {
        if(time.length() != 8){
            return true;
        }

        if(!ifNumber(time.substring(0,2)) || !ifNumber(time.substring(3,5))){
            return true;
        }

        if(Integer.parseInt(time.substring(1,2)) > 12 || Integer.parseInt(time.substring(3,5))>60)
            return false;

        return !ifMode(time.substring(6, 8));
    }

    public static boolean ifNumber(String num){
        try{
            Integer.parseInt(num);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    public static boolean ifMode(String mode) {
        return mode.equals("AM") || mode.equals("PM");
    }
}