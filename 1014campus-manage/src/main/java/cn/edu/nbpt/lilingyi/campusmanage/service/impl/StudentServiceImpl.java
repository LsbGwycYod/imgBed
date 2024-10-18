package cn.edu.nbpt.lilingyi.campusmanage.service.impl;

import cn.edu.nbpt.lilingyi.campusmanage.mapper.StudentMapper;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int batchInsert(List<Student> students) {
        return studentMapper.batchInsert(students);
    }

    @Override
    public int batchDeleteByClassId(Integer classId) {
        return studentMapper.batchDeleteByClassId(classId);
    }

    @Override
    public PageBean<Student> pageStudentsByMemory(Integer pageNum, Integer pageSize) {
        List<Student> students = studentMapper.selectAll();
        Integer start=(pageNum-1)*pageSize;
        Integer end=pageNum*pageSize;
        PageBean<Student> studentPageBean=new PageBean<>(students.size(),students.subList(start,end));
        return studentPageBean;
    }

    @Override
    public PageBean<Student> pageStudentsBySql(Integer pageNum, Integer pageSize) {
        Integer start=(pageNum-1)*pageSize;
        Integer end=pageNum*pageSize;
        List<Student> students = studentMapper.selectLimit(start,pageSize);
        PageBean<Student> studentPageBean=new PageBean<>(studentMapper.selectAll().size(),students);
        return studentPageBean;
    }

    @Override
    public PageBean<Student> pageStudenetsByHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.selectAll();
        Page<Student> studentPage= (Page<Student>) students;
        PageBean pageBean =new PageBean();
        pageBean.setRows(students);
        pageBean.setTotal((int) studentPage.getTotal());
        return pageBean;
    }

    @Override
    public PageBean<Student> pageStudenets(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return PageBean.page(pageNum,pageSize,studentMapper.selectAll());
    }

    @Override
    public PageBean<Student> pageStudenetsByTerm(Integer pageNum, Integer pageSize, String name, short gender, Date birthdayStart, Date birthdayEnd) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.selectByTerm(name,gender,birthdayStart,birthdayEnd);
        Page<Student> studentPage= (Page<Student>) students;
        PageBean pageBean =new PageBean();
        pageBean.setRows(students);
        pageBean.setTotal((int) studentPage.getTotal());
        return pageBean;
    }
}
