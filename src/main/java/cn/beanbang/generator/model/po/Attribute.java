package cn.beanbang.generator.model.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

/**
 * 属性表
 * 储存模板的信息的默认值，比如包名
 */
@Entity
@Data
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Template template;

    private String name;

    private String defaultValue;
}
