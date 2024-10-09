package cn.edu.nbpt.lilingyi.campusmanage.pojo.entity;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private Integer total;
    private List<T> rows;

    //TODO 抽象工具方法，提高复用性
    public static <T> PageBean<T> page(Integer pageNum, Integer pageSize,List<T> list) {
        Page<T> studentPage= (Page<T>) list;
        PageBean pageBean =new PageBean();
        pageBean.setRows(list);
        pageBean.setTotal((int) studentPage.getTotal());
        return pageBean;
    }
}
