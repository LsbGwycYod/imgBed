package cn.edu.nbpt.lilingyi.campusmanage.service;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.params.ClassStudent;

public interface ClassService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ClassStudent classStudent);

    ClassStudent selectByPrimaryKey(Integer id);

    Boolean updateByPrimaryKeySelective(ClassStudent classStudent);

}
