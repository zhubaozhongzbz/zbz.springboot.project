package com.zbz.boot.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;
    private  String  title;
    private  String  type;
    private  String  link;
    @TableField(exist=false)
    private  String   age;

}
