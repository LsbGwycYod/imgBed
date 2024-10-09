package cn.edu.nbpt.lilingyi.campusmanage.dao;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao {
    public Student selectById(Integer id);
    public int insert(Student student);
    public int batchInsert(List<Student> students);
    public int deleteById(Integer id);
    public int batchDeleteByClassId(Integer classIds);
    public int update(Student student);
    List<Student> selectAll();
}
