package cn.edu.nbpt.lilingyi.campusmanage.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Class {
    private Integer id;
    private String name;
    private String code;
    private Date createTime;
    private Date updateTime;
}
