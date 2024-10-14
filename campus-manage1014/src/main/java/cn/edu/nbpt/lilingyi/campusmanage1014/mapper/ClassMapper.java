package cn.edu.nbpt.lilingyi.campusmanage1014.mapper;

import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.params.ClassStudent;
import org.apache.ibatis.annotations.Mapper;

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

    ClassStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassStudent classStudent);

}
