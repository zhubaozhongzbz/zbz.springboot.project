package com.zbz.boot.format.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@TableName("user")//指定表名称
public class User implements Serializable {
    @TableField(exist = false)//数据库中没有的字段;
    private String userName;
    private Integer age;
    @TableField(exist = false)
    private Pet   pet;
    @TableField(exist = false)
    private String passWord;
    private Integer id;
    private String name;


    public User(String zhangsan, int i, Pet tomCat) {
    }


}
