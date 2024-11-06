package cn.edu.nbpt.lilingyi.campusmanage.pojo.vo;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import lombok.Data;

@Data
public class StudentClassVo extends Student {

    private Class aClass;
}
