package cn.edu.nbpt.lilingyi.campusmanage1014.service.impl;

import cn.edu.nbpt.lilingyi.campusmanage1014.exception.BizException;
import cn.edu.nbpt.lilingyi.campusmanage1014.mapper.ClassMapper;
import cn.edu.nbpt.lilingyi.campusmanage1014.mapper.StudentMapper;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.enums.ErrorCode;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.params.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage1014.service.ClassService;
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
    public ClassStudent selectByPrimaryKey(Integer id) {
        return classMapper.selectByPrimaryKey(id);
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
    public void batchInsertStudents(List<Student> students,Integer classId){
        students.forEach(student -> {
            student.setClassId(classId);
            studentMapper.insertSelective(student);
        });
    }
}
