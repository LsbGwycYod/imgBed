package cn.edu.nbpt.lilingyi.campusmanage.service.impl;

import cn.edu.nbpt.lilingyi.campusmanage.mapper.ClassMapper;
import cn.edu.nbpt.lilingyi.campusmanage.mapper.StudentMapper;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.StudentClassVo;
import cn.edu.nbpt.lilingyi.campusmanage.service.StudentService;
import cn.hutool.core.bean.BeanUtil;
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

    @Autowired
    ClassMapper classMapper;

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

//    @Override
//    public PageBean<Student> pageStudentsByMemory(Integer pageNum, Integer pageSize) {
//        List<Student> students = studentMapper.selectAll();
//        Integer start=(pageNum-1)*pageSize;
//        Integer end=pageNum*pageSize;
//        PageBean<Student> studentPageBean=new PageBean<>(students.size(),students.subList(start,end));
//        return studentPageBean;
//    }

//    @Override
//    public PageBean<Student> pageStudentsBySql(Integer pageNum, Integer pageSize) {
//        Integer start=(pageNum-1)*pageSize;
//        Integer end=pageNum*pageSize;
//        List<Student> students = studentMapper.selectLimit(start,pageSize);
//        PageBean<Student> studentPageBean=new PageBean<>(studentMapper.selectAll().size(),students);
//        return studentPageBean;
//    }

//    @Override
//    public PageBean<Student> pageStudenetsByHelper(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
//        List<Student> students = studentMapper.selectAll();
//        Page<Student> studentPage= (Page<Student>) students;
//        PageBean pageBean =new PageBean();
//        pageBean.setRows(students);
//        pageBean.setTotal((int) studentPage.getTotal());
//        return pageBean;
//    }

    @Override
    public PageBean<StudentClassVo> pageStudenets(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageBean<StudentClassVo> page = PageBean.page(studentMapper.selectAll());
        return page;
    }

    @Override
    public PageBean<StudentClassVo> pageStudenetsByTerm(Integer pageNum, Integer pageSize,Integer id, String name, Integer gender) {
        PageHelper.startPage(pageNum,pageSize);
        PageBean<StudentClassVo> page = PageBean.page(studentMapper.selectByTerm(id,name,gender));
        return page;
    }
}
