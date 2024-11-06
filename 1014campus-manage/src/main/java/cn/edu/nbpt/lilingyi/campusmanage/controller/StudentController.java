package cn.edu.nbpt.lilingyi.campusmanage.controller;

import cn.edu.nbpt.lilingyi.campusmanage.Result;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.StudentClassVo;
import cn.edu.nbpt.lilingyi.campusmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    public Result<PageBean<Student>> pageStudents(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(studentService.pageStudenets(pageNum,pageSize));
    }
    @GetMapping()
    public Result<PageBean<StudentClassVo>> pageStudentsByTerm(@RequestParam(defaultValue = "1") Integer pageNum,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                      @RequestParam(required = false) Integer id,
                                                      @RequestParam(required = false) String name,
                                                      @RequestParam(required = false) Integer gender){
        return Result.success(studentService.pageStudenetsByTerm(pageNum, pageSize,id, name, gender));
    }
}
