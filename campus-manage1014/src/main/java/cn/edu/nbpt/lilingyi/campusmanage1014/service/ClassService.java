package cn.edu.nbpt.lilingyi.campusmanage1014.service;

import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.params.ClassStudent;

public interface ClassService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ClassStudent classStudent);

    ClassStudent selectByPrimaryKey(Integer id);

    Boolean updateByPrimaryKeySelective(ClassStudent classStudent);

}
