package ccg.caitlyn.ctroller;

import ccg.caitlyn.service.DepartmentService;
import ccg.caitlyn.service.EmployeeService;
import ccg.caitlyn.vo.Department;
import ccg.caitlyn.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class empController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    /*
        去员工列表页面
     */
    @GetMapping("/emps")
    public String getEmps(Model model){
        List<Employee> employees=employeeService.getEmployees();
        model.addAttribute("emps",employees);
        return "list";
    }

    /*
        去员工添加页面
     */
    @GetMapping("/emp")
    public String getEmp(Model model){
        List<Department> departments=departmentService.getDeps();
        model.addAttribute("deps",departments);
        return "add";
    }

    /*
        新增员工，然后去员工列表
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("新增员工信息 : "+employee);
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }


    /*
        根据id查询员工,然后去修改员工页面
     */
    @GetMapping("/emp/{userid}")
    public String getEmpAndToModifyPage(@PathVariable("userid")int userid, Model model){
        Employee employee=employeeService.getEmployeeById(userid);
        model.addAttribute("emp",employee);
        System.out.println("modify user: "+employee);

        //需要显示所有的部门信息
        List<Department> departments=departmentService.getDeps();
        model.addAttribute("deps",departments);

        //新增和修改公用一个add页面
        return "add";
    }


    /*
        修改员工信息,然后去员工列表页面
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("modify user : "+employee);
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }


    /*
        删除员工，然后去员工列表页面
     */
    @DeleteMapping("emp/{userid}")
    public String  deleteEmp(@PathVariable("userid") int userid){
        employeeService.deleteEmployee(userid);
        return "redirect:/emps";
    }
}
