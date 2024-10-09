package cn.edu.nbpt.lilingyi.campusmanage.service;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.ClassStudent;

public interface ClassService {
    public ClassStudent selectById(Integer id);
    public int insert(ClassStudent classStudent);
    public int deleteById(Integer id);
    public Boolean update(ClassStudent classStudent);
}
