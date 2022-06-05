package com.duyou.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.lang.reflect.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value = "t_book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String author;
    @TableField(value = "bookDesc")
    private String bookDesc;
    @TableField(value = "imgUrl")
    private String imgUrl;
    private Double price;
    private String press;
}
