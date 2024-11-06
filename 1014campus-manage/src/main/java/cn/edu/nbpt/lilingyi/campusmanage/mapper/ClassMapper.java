package cn.edu.nbpt.lilingyi.campusmanage.mapper;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.params.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.ClassStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 22273
* @description 针对表【class】的数据库操作Mapper
* @createDate 2024-10-14 20:32:53
* @Entity cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Class
*/
@Mapper
public interface ClassMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(ClassStudent classStudent);

    Class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassStudent classStudent);
    List<ClassStudentVo> selectAll();
    List<ClassStudentVo> selectByTerm(@Param("id") Integer id, @Param("name") String name, @Param("code") String code);
}
