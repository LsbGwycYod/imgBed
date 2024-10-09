package cn.edu.nbpt.lilingyi.campusmanage.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;
    private String userName;
    private int age;
    private String name;
    private int gender;
    private Date birthday;
    private Date entryTime;
    private Date graduationTime;
    private String address;
    private Integer classId;
    private Date createTime;
    private Date updateTime;
}
