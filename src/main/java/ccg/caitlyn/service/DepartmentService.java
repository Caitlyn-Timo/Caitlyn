package ccg.caitlyn.service;

import ccg.caitlyn.repository.DepartmentDao;
import ccg.caitlyn.vo.Department;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private SqlSession sqlSession;

    public List<Department>  getDeps(){
        DepartmentDao departmentDao= sqlSession.getMapper(DepartmentDao.class);
        return departmentDao.getDeps();
    }
}
