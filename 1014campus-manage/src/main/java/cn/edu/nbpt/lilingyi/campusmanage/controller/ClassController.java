package cn.edu.nbpt.lilingyi.campusmanage.controller;

import cn.edu.nbpt.lilingyi.campusmanage.Result;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.entity.Class;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.params.ClassStudent;
import cn.edu.nbpt.lilingyi.campusmanage.pojo.vo.ClassStudentVo;
import cn.edu.nbpt.lilingyi.campusmanage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("/{id}")
    public Result<Class> selectByPrimaryKey(@PathVariable Integer id){
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

    @GetMapping("/page")
    Result<PageBean<ClassStudentVo>> pageClass(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(classService.pageClass(pageNum,pageSize));
    }
    @GetMapping()
    Result<PageBean<ClassStudentVo>> pageClassByTerm(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam(required = false) Integer id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String code){
        return Result.success(classService.pageClassByTerm(pageNum,pageSize,id,name,code));
    }
}
