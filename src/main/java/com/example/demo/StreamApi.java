package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args)  {

        Address address1 = new Address(1,"lane1","Digana","Sri Lanka");
        Address address2 = new Address(2,"lane2","Menikhinna","Sri Lanka");
        Address address3 = new Address(3,"lane3","Theldeniya","Sri Lanka");
        Address address4 = new Address(4,"lane4","PJ","Malaysia");
        Address address5 = new Address(5,"lane5","Johor","Malaysia");

        Department department1 = new Department(1,"Finance");
        Department department2 = new Department(2,"IT");
        Department department3 = new Department(3, "HR");
        Department department4 = new Department(4, "Middle Office");


        Employee employee1 = new Employee(1, "kalinga","kk@gmail.com","123",32,address1,1,12345.33);
        Employee employee2 = new Employee(2, "malinga","kk2@gmail.com","123",50,address2,2,15672.88);
        Employee employee3 = new Employee(3, "sunil","kk3@gmail.com","123",21, address3,3,10345.23);
        Employee employee4 = new Employee(4, "amal","kk4@gmail.com","123",76,address4,1,12000);
        Employee employee5 = new Employee(5, "kamal","kk5@gmail.com","123",19,address2,1,20500);
        Employee employee6 = new Employee(6, "bandara","kk6@gmail.com","123", 46,address4,1,11570);
        Employee employee7 = new Employee(7, "john","kk7@gmail.com","123",28,address5,4,26200);
        Employee employee8 = new Employee(7, "alex","kk8@gmail.com","123",11,address5,3,16400);

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();

        Collections.addAll(addressList,address1,address2,address3,address4,address5);
        Collections.addAll(departmentList,department1,department2,department3,department4);
        Collections.addAll(employeeList, employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8);

        // #### forEach
        //userList.stream().forEach(x-> System.out.println(x.getEmail()));

        // store emails into the new list
        List<String> userEmailList = employeeList.stream().map(Employee::getEmail).toList();

        // filter users who older than 40
        List<Employee> usersOlderThan40 = employeeList.stream().filter(employee -> employee.getAge() > 40)
                .toList();

        // get List of address which only for users who older 40
        List<Address> addressListForUserOlder40 = employeeList.stream().
                filter(employee -> employee.getAge() > 40).map(Employee::getAddress).toList();

        //addressListForUserOlder40.forEach(System.out::println);

        // Map -> <String , Address>
        Map<String, Address> userAddressMapForOlder40 = employeeList.stream()
                .filter(employee -> employee.getAge() > 40)
                .collect(Collectors.toMap(Employee::getUserName , Employee::getAddress));

        /*

        userAddressMapForOlder40.forEach((username,address)-> {
            System.out.print("UserName is :" + username);
            System.out.println(" And Address is " + address.getCity());
        });

         */



/*
 * List All Departments
 */
       //  departmentList.stream().forEach(System.out::println);

/*
 *  List employees with their department information
 */

        /*
        employeeList.stream()
                .map(user -> user + " | " +
                        departmentList.stream()
                        .filter(dept -> dept.getDepartmentId() == user.getDepartmentId())
                        .findFirst())
                .forEach(System.out::println);

         */

/*
 *
 * List all the employees in each department
 * This is equal to SQL group by
*/
    Map<Integer, List<Employee>> userDepartments = employeeList.stream()
            .collect(Collectors.groupingBy(Employee::getDepartmentId));

    /*

        userDepartments.forEach((depId , userlistdep) -> {
                System.out.print("Department :: " + depId);
                System.out.println();
                userlistdep.forEach(user -> System.out.println(" User Id is - > " + user.getUserId()));
        });

         */
/*
 * Count the number of employees in each department
 * department1 -> 2
 * department2 -> 4
 * return Map<Integer,Integer> -> departmentId , count
 */

Map<Integer,Long> employeeCountInEachDepartment = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.counting()));

//        employeeCountInEachDepartment.forEach((depatmentId,userCount) -> {
//            System.out.println("Department Id - " + depatmentId + ", employeeCount is " + userCount);
//        });

/*
 * List Departments with more than 1 users
 *  Return List
 *  departmentIDs which more than 1 user ,
*/

List<Integer> departmentsWithMoreThan1Employees = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() >= 2)
        .map(x -> x.getKey()).collect(Collectors.toList());

       // departmentsWithMoreThan1Employees.forEach(x -> System.out.println("department Id is - " + x));

/*
 * Find the employee with the highest salary
 * return Integer
 * employeeID
*/


Employee employeeIdHighestSalary = employeeList.stream()
        .max(Comparator.comparingDouble(Employee::getSalary)).get();

       // System.out.println("Highest salary is for user - " + employeeIdHighestSalary);

/*
 *  List Average salary for each department
 *  Return Map
 *  <departmentID, Average Salary>
*/

    Map<Integer, Double> salaryDepartmentMap = employeeList.stream()
            .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.averagingDouble(Employee::getSalary)));
/*
    salaryDepartmentMap.forEach((depId,avgSalary) -> {
        System.out.println("department ID is " + depId + " Avg Salary is " + avgSalary);
    });
*/

 /*
   *  List the Employee who earn more than average salary in their department
 */

   List<Employee> employessSalarygreatedThanAverage = employeeList.stream()
           .filter(emp -> emp.getSalary() > salaryDepartmentMap.get(emp.getDepartmentId())).toList();
      //  employessSalarygreatedThanAverage.forEach(System.out::println);

        boolean allMatch = employeeList.stream().allMatch(emp -> emp.getSalary() > 45000);
        boolean anyMatch = employeeList.stream().anyMatch(emp -> emp.getSalary() > 10000);
        boolean noneMatch = employeeList.stream().noneMatch(emp -> emp.getSalary() > 50000);

        System.out.println(noneMatch);

    }


}
