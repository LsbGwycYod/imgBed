package cn.edu.nbpt.lilingyi.campusmanage.controller;

import cn.edu.nbpt.lilingyi.campusmanage.pojo.Result;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("{id}")
    public Result<ClassStudent> select(@PathVariable int id){
        return Result.success(classService.selectById(id));
    }
    @PostMapping
    public Result<Integer> insert(@RequestBody ClassStudent classStudent){
        return Result.success(classService.insert(classStudent));
    }
    @DeleteMapping("{id}")
    public Result<Integer> delete(@PathVariable int id){
        return Result.success(classService.deleteById(id));
    }
    @PutMapping
    public Result<Boolean> update(@RequestBody ClassStudent classStudent){
        return Result.success(classService.update(classStudent));
    }
}
