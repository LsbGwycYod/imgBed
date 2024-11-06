package cn.edu.nbpt.lilingyi.campusmanage.service;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.params.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.ClassStudentVo;

public interface ClassService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ClassStudent classStudent);

    Class selectByPrimaryKey(Integer id);

    Boolean updateByPrimaryKeySelective(ClassStudent classStudent);

    PageBean<ClassStudentVo> pageClass(Integer pageNum, Integer pageSize);
    PageBean<ClassStudentVo> pageClassByTerm(Integer pageNum, Integer pageSize,Integer id,String name,String code);
}
