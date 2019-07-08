package ccg.caitlyn.repository;

import ccg.caitlyn.vo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentDao {

    @Select("select * from department")
    public List<Department> getDeps();



    @Select({"select * from department where id=#{depid}"})
    public Department getDepById(@Param("depid") int depid);

}
