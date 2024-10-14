package cn.edu.nbpt.lilingyi.campusmanage1014.controller;

import cn.edu.nbpt.lilingyi.campusmanage1014.Result;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage1014.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public Result<Student> selectByPrimaryKey(@PathVariable Integer id) {
        return Result.success(studentService.selectByPrimaryKey(id));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable Integer id) {
        return Result.success(studentService.deleteByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insertSelective(@RequestBody Student student) {
        return Result.success(studentService.insertSelective(student));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKeySelective(@RequestBody Student student) {
        return Result.success(studentService.updateByPrimaryKeySelective(student));
    }
    @GetMapping("/page")
    public Result<PageBean<Student>> pageStudents(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return Result.success(studentService.pageStudenets(pageNum,pageSize));
    }
}
