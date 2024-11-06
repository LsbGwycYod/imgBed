package cn.edu.nbpt.lilingyi.campusmanage.service;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.StudentClassVo;

import java.util.Date;
import java.util.List;


public interface StudentService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);
    int batchInsert(List<Student> students);
    int batchDeleteByClassId(Integer classId);
//    PageBean<Student> pageStudentsByMemory(Integer pageNum, Integer pageSize);
//    PageBean<Student> pageStudentsBySql(Integer pageNum, Integer pageSize);
//    PageBean<Student> pageStudenetsByHelper(Integer pageNum, Integer pageSize);
    PageBean<StudentClassVo> pageStudenets(Integer pageNum, Integer pageSize);
    PageBean<StudentClassVo> pageStudenetsByTerm(Integer pageNum, Integer pageSize,Integer id, String name, Integer gender);
}
