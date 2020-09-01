import java.util.*;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class Leet690 {
    List<Integer> visited = new ArrayList<>();
    public int getImportance(List<Employee> employees, int id) {
        Employee empInQuestion = getEmployee(employees, id);
        int totalImp;
        if(!visited.contains(empInQuestion.id)) {
            totalImp = empInQuestion.importance;
            visited.add(empInQuestion.id);
        }
        else
            totalImp = 0;
        for(int e : empInQuestion.subordinates) {
            Employee employee = getEmployee(employees, e);
            totalImp += employee.importance;
            visited.add(employee.id);
            if(!employee.subordinates.isEmpty())
                totalImp += getImportance(employees, employee.id);
        }
        return totalImp;
    }
    private static Employee getEmployee(List<Employee> employees, int id) {
        Employee empInQuestion = employees.stream().filter(employee -> employee.id == id).findFirst().orElse(null);
        return empInQuestion;
    }
    public int getImportanceQ(List<Employee> employees, int id) {
        int totImportance = 0;
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }
        q.offer(employeeMap.get(id));
        while (!q.isEmpty()) {
            Employee empCurrent = q.poll();
            totImportance += empCurrent.importance;
            for (int i : empCurrent.subordinates) {
                q.offer(employeeMap.get(i));
            }
        }
        return totImportance;
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.importance = 5;
        List<Integer> subList1 = new ArrayList<>();
        subList1.add(2);
        subList1.add(3);
        emp1.subordinates = subList1;
        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.importance = 3;
        List<Integer> subList2 = new ArrayList<>();
        emp2.subordinates = subList2;
        Employee emp3 = new Employee();
        emp3.id = 3;
        emp3.importance = 3;
        List<Integer> subList3 = new ArrayList<>();
        emp3.subordinates = subList3;
        List<Employee> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        Leet690 leet690 = new Leet690();
        int res = leet690.getImportance(empList, emp1.id);
        System.out.println(res);
        int res3 = leet690.getImportanceQ(empList, emp1.id);
        System.out.println(res3);
        List<Employee> empList2 = new ArrayList<>();
        Employee empl1 = new Employee();
        empl1.id = 2;
        empl1.importance = 5;
        empl1.subordinates = new ArrayList<>();
        empList2.add(empl1);
        Leet690 leet6901 = new Leet690();
        int res2 = leet6901.getImportance(empList2, empl1.id);
        System.out.println(res2);
        int res4 = leet6901.getImportanceQ(empList2, empl1.id);
        System.out.println(res4);
    }
}
