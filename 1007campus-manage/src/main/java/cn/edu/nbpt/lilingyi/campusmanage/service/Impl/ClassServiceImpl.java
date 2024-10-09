package cn.edu.nbpt.lilingyi.campusmanage.service.Impl;

import cn.edu.nbpt.lilingyi.campusmanage.dao.ClassDao;
import cn.edu.nbpt.lilingyi.campusmanage.dao.StudentDao;
import cn.edu.nbpt.lilingyi.campusmanage.exception.BizException;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.enums.ErrorCode;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    ClassDao classDao;
    @Autowired
    StudentDao studentDao;

    @Override
    public ClassStudent selectById(Integer id) {
        return classDao.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ClassStudent classStudent) {
       int row = classDao.insert(classStudent);
       batchInsert(classStudent.getStudents(),classStudent.getId());
       return classStudent.getId();
    }

    @Override
    public int deleteById(Integer id) {
        return classDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(ClassStudent classStudent) {
        int row= classDao.update(classStudent);
        if(row==0){
            throw new BizException(ErrorCode.UPDATE_ERROR);
        }
        studentDao.batchDeleteByClassId(classStudent.getId());
        batchInsert(classStudent.getStudents(),classStudent.getId());
        return true;
    }

    public void batchInsert(List<Student> students, Integer classId){
        students.forEach(student -> {
            student.setClassId(classId);
            studentDao.insert(student);
        });
    }
}
