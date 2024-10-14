package cn.edu.nbpt.lilingyi.campusmanage1014.service;

import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Student;

import java.util.List;


public interface StudentService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);
    int batchInsert(List<Student> students);
    int batchDeleteByClassId(Integer classId);
    PageBean<Student> pageStudentsByMemory(Integer pageNum, Integer pageSize);
    PageBean<Student> pageStudentsBySql(Integer pageNum, Integer pageSize);
    PageBean<Student> pageStudenetsByHelper(Integer pageNum, Integer pageSize);
    PageBean<Student> pageStudenets(Integer pageNum, Integer pageSize);
}
