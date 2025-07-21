import java.util.ArrayList;

abstract class Employee{
    private  String name;
    private  int id;

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return  name;
    }
   public int getId(){
        return  id;
    }
    public abstract  double calculateSalary();

    @Override
    public  String toString(){
        return "Employee [name = "+name+", id = "+id+", salarry = "+calculateSalary()+"]";

    }

}
class FulltimeEmployee extends Employee {
    private  double monthlySalary;
    public  FulltimeEmployee(String name , int id , double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends  Employee{
    private  int hoursWorked;
    private  double hourlyRate;
    public  PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayRollSystem{
    private ArrayList <Employee> employees;
    public PayRollSystem(){
        employees = new ArrayList<>();

    }
    public  void  addEmployee(Employee employee){
        employees.add(employee);
    }
    public  void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee : employees){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }}
        if(employeeToRemove!=null){
            employees.remove(employeeToRemove);
            }

        }
        public  void displayEmployees(){
        for(Employee employee : employees){
            System.out.println(employee);
        }
        }

    }


public class Main{
    public static void main(String[] args) {
        PayRollSystem payrollSystem = new PayRollSystem();
        FulltimeEmployee  narayana = new FulltimeEmployee("Narayana")
    }
}