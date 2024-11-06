package cn.edu.nbpt.lilingyi.campusmanage.service.impl;

import cn.edu.nbpt.lilingyi.campusmanage.exception.BizException;
import cn.edu.nbpt.lilingyi.campusmanage.mapper.ClassMapper;
import cn.edu.nbpt.lilingyi.campusmanage.mapper.StudentMapper;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.enums.ErrorCode;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.params.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.ClassStudentVo;
import cn.edu.nbpt.lilingyi.campusmanage.service.ClassService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        studentMapper.batchDeleteByClassId(id);
        return classMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(ClassStudent classStudent) {
        classMapper.insertSelective(classStudent);
        batchInsertStudents(classStudent.getStudents(),classStudent.getId());
        return classStudent.getId();
    }

    @Override
    public Class selectByPrimaryKey(Integer id) {
        Class aClass=classMapper.selectByPrimaryKey(id);
        return aClass;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateByPrimaryKeySelective(ClassStudent classStudent) {
        int row= classMapper.updateByPrimaryKeySelective(classStudent);
        if(row==0){
            throw new BizException(ErrorCode.UPDATE_ERROR);
        }
        studentMapper.batchDeleteByClassId(classStudent.getId());
        batchInsertStudents(classStudent.getStudents(),classStudent.getId());
        return true;
    }

    @Override
    public PageBean<ClassStudentVo> pageClass(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageBean<ClassStudentVo> page = PageBean.page(classMapper.selectAll());
        return page;
    }

    @Override
    public PageBean<ClassStudentVo> pageClassByTerm(Integer pageNum, Integer pageSize,Integer id,String name,String code) {
        PageHelper.startPage(pageNum,pageSize);
        PageBean<ClassStudentVo> page = PageBean.page(classMapper.selectByTerm(id,name,code));
        return page;
    }

    public void batchInsertStudents(List<Student> students,Integer classId){
        students.forEach(student -> {
            student.setClassId(classId);
            studentMapper.insertSelective(student);
        });
    }
}
