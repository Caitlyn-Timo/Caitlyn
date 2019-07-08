package ccg.caitlyn.repository;

import ccg.caitlyn.vo.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface EmployeeDao {

    @Select("select * from employee")
    @ResultMap(value="Emp_Dep")  //引用定义的Results
    public List<Employee> getEmployees();


    @Insert("insert into employee(firstname,lastname,gender,age,phonenum,birth,dept_id) " +
            "values(#{firstName},#{lastName},#{gender},#{age},#{phoneNum},#{birth},#{dept.id})")
    public void insertEmployee(Employee employee);


    @Update("update employee set firstname=#{firstName},lastname=#{lastName},gender=#{gender},age=#{age},phonenum=#{phoneNum},birth=#{birth},dept_id=#{dept.id} " +
            "where id=#{id}")
    public void updateEmployeeById(Employee employee);


    @Delete("delete from employee where id=#{userid}")
    public void deleteEmployee(int userid);


    @Select({"select * from employee where id=#{userid}"})
    @Results(id="Emp_Dep",value = {
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "firstName",column = "firstname"),
                @Result(property = "lastName",column = "lastname"),
                @Result(property = "gender",column = "gender"),
                @Result(property = "age",column = "age"),
                @Result(property = "phoneNum",column = "phonenum"),
                @Result(property = "birth",column = "birth"),
                @Result(property = "dept", column = "dept_id",one=@One(select = "ccg.caitlyn.repository.DepartmentDao.getDepById",fetchType = FetchType.LAZY))
            })
    public Employee getEmpoyeeById(@Param("userid") int userid);

}
