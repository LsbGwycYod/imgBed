package cn.edu.nbpt.lilingyi.campusmanage.dao;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.ClassStudent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassDao {
    public ClassStudent selectById(Integer id);
    public int insert(ClassStudent classStudent);
    public int deleteById(Integer id);
    public int update(ClassStudent classStudent);
}
