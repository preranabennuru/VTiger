package array;

public class Demo {
	public static void main(String[] args) {
		Employee emps[]= {
				new Employee(101,"smith"),new Employee(102,"sravani"),new Employee(103,"sheela")
		};
		for(Employee emp:emps)
			System.out.println(emp);
	}

}
