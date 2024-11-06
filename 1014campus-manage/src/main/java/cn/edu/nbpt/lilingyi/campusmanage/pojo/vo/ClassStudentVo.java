package cn.edu.nbpt.lilingyi.campusmanage.pojo.vo;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class ClassStudentVo extends Class {
    private List<Student> students;
}
