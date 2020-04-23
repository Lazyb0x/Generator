package cn.beanbang.generator.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * 属性值表
 * 实例的配置，储存具体的项目信息，比如包名，artifact id 等
 */
@Entity
@Data
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    Attribute attribute;

    String content;
}
