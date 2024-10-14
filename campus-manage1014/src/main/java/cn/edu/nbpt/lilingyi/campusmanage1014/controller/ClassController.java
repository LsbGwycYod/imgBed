package cn.edu.nbpt.lilingyi.campusmanage1014.controller;

import cn.edu.nbpt.lilingyi.campusmanage1014.Result;
import cn.edu.nbpt.lilingyi.campusmanage1014.pojo.params.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage1014.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("/{id}")
    public Result<ClassStudent> selectByPrimaryKey(@PathVariable Integer id){
        return Result.success(classService.selectByPrimaryKey(id));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable Integer id){
        return Result.success(classService.deleteByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insertSelective(@RequestBody ClassStudent students){
        return Result.success(classService.insertSelective(students));
    }

    @PutMapping
    public Result<Boolean> updateByPrimaryKeySelective(@RequestBody ClassStudent students){
        return Result.success(classService.updateByPrimaryKeySelective(students));
    }
}
