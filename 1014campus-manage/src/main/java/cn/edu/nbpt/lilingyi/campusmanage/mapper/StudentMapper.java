package cn.edu.nbpt.lilingyi.campusmanage.mapper;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.StudentClassVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author 22273
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-10-14 20:21:58
* @Entity generator.entity.Student
*/
@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    List<Student> selectByClassId(Integer classId);

    int updateByPrimaryKeySelective(Student record);

    int batchInsert(List<Student> students);
    int batchDeleteByClassId(Integer classId);

    List<StudentClassVo> selectAll();
    List<Student> selectLimit(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    List<StudentClassVo> selectByTerm(@Param("id") Integer id, @Param("name") String name, @Param("gender") Integer gender);
}
