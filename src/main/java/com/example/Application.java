package com.example;

import com.example.springboot.Department;
import com.example.springboot.StudentRepo.DepartmentRepo;
import com.example.springboot.StudentRepo.EmployeeRepo;
//import com.example.springboot.StudentRepo.StudentRepo;
import com.example.springboot.StudentRepo.StudentRepo;
import com.example.springboot.test.Employee.Employee;
import com.example.springboot.test.Employee.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;


import java.util.*;

@Scope("prototype")
@ComponentScan(basePackages = {"com.example"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeRepo employeeRepo= context.getBean(EmployeeRepo.class);
		DepartmentRepo departmentRepo = context.getBean(DepartmentRepo.class);

		Employee employee= new Employee();
		employee.setEid(2);
		employee.setEname("Divyesh");
		employee.setCity("Surat");

		Employee Emp1 = employeeRepo.save(employee);
		System.out.println(Emp1);

		StudentRepo studentRepo = context.getBean(StudentRepo.class);

//		UsingProperty property = context.getBean(UsingProperty.class);
//		property.readProperty();  //PropertySource using Environment
//		System.out.println("----------------------");
//		property.readProp();	//PropertySource using @Value

//		User user1= context.getBean(User.class);
//		user1.UserTest();	//ConfigurationProperties

		Scanner str = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. Insert Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Display Student by ID");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Insert Department");
			System.out.println("7. Display Department");
			System.out.println("8. Display students by Department");
			System.out.println("Enter Your Choice = ");
			ch = s.nextInt();

			switch (ch) {
				case 1:
					int flag;
					Student stu = context.getBean(Student.class);

					System.out.println("Enter Student ID: ");
					int stu_id = s.nextInt();
					String stu_name;
					String dept_name;

					Iterable<Department> dItr=departmentRepo.findAll();

					if(studentRepo.existsById(stu_id)){
						System.out.println("A record with this Id already exists");
					}else {
						stu.setStudent_id(stu_id);
						System.out.println("Enter Student Name: ");
						stu_name = s.next();
						while(stu_name.isEmpty()){
							System.out.println("Enter Student Name");
							stu_name = s.next();
						}
						stu.setStudent_name(stu_name);
						int count=0;
//						dItr.forEach(department -> System.out.println(department));//-----------------------------------------
						System.out.println("Enter one of the listed departments");
						for (Department dept:dItr){
							System.out.println(dept);
							count++;
						}
						if(count==0){
							System.out.println("There are no departments currently" + "\n"+ "Add a Department First");
							break;
						}
						System.out.println("Enter Department Name: ");
						dept_name = str.nextLine();
						while(dept_name.isEmpty()){
							System.out.println("Enter Department Name: ");
							dept_name = str.nextLine();
						}
						flag=0;
						for (Department dept: dItr) {
							if (dept_name.equalsIgnoreCase(dept.getDepartment_name())) {
//								stu.setDept_d_id(dept.dId);
								stu.setDepartment(dept_name.toUpperCase());
								Student stu1 = studentRepo.save(stu);
								System.out.println("Student Added "+stu1);
								flag=1;
							}
						}
						if(flag==0) {
							System.out.println("Cannot identify such Department");
						}
					}

					System.out.println("-----------------------------------");
					break;

				case 2: //System.out.println(Students);
					int count=0;
					Iterable<Student> itr = studentRepo.findAll();
//					itr.forEach(student -> System.out.println(student));
					for (Student displayStu:itr){
						System.out.println(displayStu);
						count++;
					}
					if(count==0){
						System.out.println("There are no Students currently");
						break;
					}

					System.out.println("-----------------------------------");
					break;

				case 3:
					flag = 0;
					System.out.println("Enter Student ID: ");
					stu_id = s.nextInt();
					System.out.println("-----------------------------------");
					if(studentRepo.existsById(stu_id)){
						Student student = studentRepo.findById(stu_id).get();
						System.out.println(student);
						flag=1;
					}
					if (flag==0){
						System.out.println("Invalid Id");
					}

					System.out.println("-----------------------------------");
					break;

				case 4:
					flag=0;
					int flagForD=0;
					System.out.println("Enter the ID of record you want to Update: ");
					stu_id = s.nextInt();
					System.out.println("------------------------------------");
					itr = studentRepo.findAll();
					for (Student student: itr) {
						if (student.getStudent_id() == stu_id) {
							flag=1;
							student.setStudent_id(stu_id);
							System.out.println("Enter New Student Name: ");
							stu_name = s.next();
							student.setStudent_name(stu_name);
							System.out.println("Enter one of the listed departments");
							dItr = departmentRepo.findAll();
							dItr.forEach(department -> System.out.println(department));
							System.out.println("Enter New Department Name: ");
							dept_name = s.next();
							student.setDepartment(dept_name);

							dItr = departmentRepo.findAll();
							for (Department dept: dItr) {
								if (dept_name.equalsIgnoreCase(dept.getDepartment_name())) {
//									student.setDept_d_id(dept.dId);
									System.out.println("Record is Updated");
									studentRepo.save(student);
									flagForD=1;
								}
							}
							if(flagForD==0) {
								System.out.println("Cannot identify such Department");
							}
						}
					}

					if (flag==0){
						System.out.println("No such record found");
					}
					System.out.println("------------------------------------");
					break;

				case 5:
					flag=0;
					System.out.println("Enter the ID of record you want to delete: ");
					stu_id = s.nextInt();
					System.out.println("----------------------------------");
					if(true){
						studentRepo.deleteById(stu_id);
						System.out.println("Record with id "+stu_id+" is Deleted");
						flag=1;
						break;
					}
					if (flag==0){
						System.out.println("No such record found");
					}
					System.out.println("--------------------------------");
					break;

				case 6:
					Department dept1 = context.getBean(Department.class);
					System.out.println("Enter id of the department: ");
					int dept1_id = s.nextInt();

					flag=0;
					dItr = departmentRepo.findAll();
					if (departmentRepo.existsById(dept1_id)) {
							System.out.println("This Id is already in use. Choose Unique ID.");
							flag = 1;
							break;
						}

					dept1.setdId(dept1_id);
					System.out.println("Enter name of the department: ");
					String dept1_name = s.next();

					if(flag==0) {
						for (Department dept : dItr) {
							if (dept1_name.equalsIgnoreCase(dept.getDepartment_name())) {
								System.out.println("This Department Already Exists.");
								flag=1;
							}
						}
					}
					dept1.setDepartment_name(dept1_name);

					if(flag==0) {
						departmentRepo.save(dept1);
					}
					break;

				case 7:
					count=0;
					Iterable<Department> ditr= departmentRepo.findAll();
					for (Department displayDept: ditr){
						System.out.println(displayDept);
						count++;
					}
					if (count==0){
						System.out.println("No Departments Available");
					}
					break;

				case 8:
					flagForD=0;
					int flagForS=0;
					System.out.println("Enter the name of Department: ");
					dept_name = s.next();
					dItr = departmentRepo.findAll();
					for (Department displayByDept: dItr) {
						if (dept_name.equalsIgnoreCase(displayByDept.getDepartment_name())) {
							flagForD=1;
							System.out.println("Students in the " + dept_name.toUpperCase() + " Department");
							System.out.println("-----------------------------------");
							int id = displayByDept.getdId();
							Iterable<Student> st =studentRepo.findAll();
							for(Student student: st){
								if(student.getDept_d_id() == id ){
									System.out.println(student);
									flagForS=1;
								}
							}
							System.out.println("-----------------------------------");
							if (flagForS == 0){
								System.out.println("No Students in this Department");
								System.out.println("-----------------------------------");
							}
						}
					}
					if(flagForD==0){
						System.out.println("No such department found");
						System.out.println("-----------------------------------");
					}
			}
		} while (ch != 0);
//	@Bean
//	FilterRegistrationBean<specificFilter> filterBean() {

//		final FilterRegistrationBean<specificFilter> Bean1 = new FilterRegistrationBean<>();
//		Bean1.setFilter(new specificFilter());
//		Bean1.addUrlPatterns("/specificUrl/*");
//
//		return Bean1;
//	}

	}
}