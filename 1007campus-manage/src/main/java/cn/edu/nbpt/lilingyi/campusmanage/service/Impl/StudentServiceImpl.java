package cn.edu.nbpt.lilingyi.campusmanage.service.Impl;

import cn.edu.nbpt.lilingyi.campusmanage.dao.StudentDao;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int batchInsert(List<Student> students) {
        return studentDao.batchInsert(students);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public PageBean<Student> pageStudenets(Integer pageNum, Integer pageSize) {
//        List<Student> students = studentDao.selectAll();
        //TODO 内存分页

        //数据库分页 mapper->limit
//        Integer start=(pageNum-1)*pageSize;
//        List<Student> students = studentDao.selectAll(start,pageSize);
        //TODO limit分页

        //如果越界，返回界内
        //page-Helper
//        PageHelper.startPage(pageNum,pageSize);
//        List<Student> students = studentDao.selectAll();
//        Page<Student> studentPage= (Page<Student>) students;
//        PageBean pageBean =new PageBean();
//        pageBean.setRows(students);
//        pageBean.setTotal((int) studentPage.getTotal());

        PageHelper.startPage(pageNum,pageSize);
        return PageBean.page(pageNum,pageSize,studentDao.selectAll());
    }

    @Override
    public int deleteById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public int batchDeleteByClassId(Integer classId) {
        return studentDao.batchDeleteByClassId(classId);
    }

    @Override
    public Student selectById(Integer id) {
        return studentDao.selectById(id);
    }
}
