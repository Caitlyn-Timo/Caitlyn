package ccg.caitlyn.service;

import ccg.caitlyn.repository.EmployeeDao;
import ccg.caitlyn.vo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private SqlSession sqlsession;

    public List<Employee> getEmployees(){
       EmployeeDao empDao= sqlsession.getMapper(EmployeeDao.class);
       return empDao.getEmployees();
    }

    public Employee getEmployeeById(int userid){
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);
        return empDao.getEmpoyeeById(userid);
    }

    public void addEmployee(Employee employee){
        EmployeeDao empDao= sqlsession.getMapper(EmployeeDao.class);
        empDao.insertEmployee(employee);
    }

    public void deleteEmployee(int userid){
        EmployeeDao empDao= sqlsession.getMapper(EmployeeDao.class);
        empDao.deleteEmployee(userid);
    }


    public void updateEmployee(Employee employee){
        EmployeeDao empDao= sqlsession.getMapper(EmployeeDao.class);
        empDao.updateEmployeeById(employee);
    }
}
