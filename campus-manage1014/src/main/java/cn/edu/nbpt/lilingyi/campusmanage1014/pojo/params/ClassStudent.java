package cn.edu.nbpt.lilingyi.campusmanage1014.pojo.params;


import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class ClassStudent extends Class {
    private List<Student> students;
}
