package cn.beanbang.generator.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Properties;

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

    @Transient
    @JsonIgnore
    Properties properties;

}
