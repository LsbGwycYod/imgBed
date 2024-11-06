package cn.edu.nbpt.lilingyi.campusmanage.pojo.bean;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Integer total;
    private List<T> rows;
    public static <T> PageBean<T> page(List<T> list) {
        Page<T> page= (Page<T>) list;
        PageBean pageBean=new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotal((int) page.getTotal());
        return pageBean;
    }
}
