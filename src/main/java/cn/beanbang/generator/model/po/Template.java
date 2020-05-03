package cn.beanbang.generator.model.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 模板表
 * 一个模板包含一系列模板文件，模板可以被渲染成实例项目
 */
@Entity
@Data
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    Instance instance;

    private String name;

    private String description;
}
