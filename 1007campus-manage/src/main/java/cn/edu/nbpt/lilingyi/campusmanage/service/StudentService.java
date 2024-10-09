package cn.edu.nbpt.lilingyi.campusmanage.service;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;

import java.util.List;

public interface StudentService {
    public Student selectById(Integer id);
    public int insert(Student student);
    public int batchInsert(List<Student> students);
    public int deleteById(Integer id);
    public int batchDeleteByClassId(Integer classId);
    public int update(Student student);

    PageBean<Student> pageStudenets(Integer pageNum, Integer pageSize);
}
