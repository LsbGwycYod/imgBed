package cn.edu.nbpt.lilingyi.campusmanage.controller;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.Result;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Student;
import cn.edu.nbpt.lilingyi.campusmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    public Result<Student> select(@PathVariable Integer id){
        return Result.success(studentService.selectById(id));
    }
    @PostMapping
    public Result<Integer> insert(@RequestBody Student student){
        return Result.success(studentService.insert(student));
    }
    @DeleteMapping
    public Result<Integer> delete(@PathVariable Integer id){
        return Result.success(studentService.deleteById(id));
    }
    @PutMapping
    public Result<Integer> update(@RequestBody Student student) {
        return Result.success(studentService.update(student));
    }

    @GetMapping("")
    Result<PageBean<Student>> pageStudents(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        return Result.success(studentService.pageStudenets(pageNum,pageSize));
    }
}
