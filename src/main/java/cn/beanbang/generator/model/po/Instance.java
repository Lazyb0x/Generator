package cn.beanbang.generator.model.po;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * 实例表
 * 通过数据库模型和模板可以生成实例项目
 */
@Entity
@Data
public class Instance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    Model model;

    @ManyToOne
    Template template;

    private String name;

    private String comment;
}
