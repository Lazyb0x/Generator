package cn.beanbang.generator.model.po;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * 字段表
 * 对应数据库表的字段
 */
@Entity
@Data
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    cn.beanbang.generator.model.po.Entity entity;

    private String fieldName;

    private String columnName;

    private String dataType;

    @Column(columnDefinition = "boolean default false")
    private boolean primaryKey;

    @Column(columnDefinition = "boolean default false")
    private boolean notNull;

    @Column(columnDefinition = "boolean default false")
    private boolean valueUnique;

    @Column(columnDefinition = "boolean default false")
    private boolean zeroFilled;

    @Column(columnDefinition = "boolean default false")
    private boolean autoIncremental;

    private String defaultValue;
}
