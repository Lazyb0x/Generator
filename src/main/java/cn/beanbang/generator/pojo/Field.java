package cn.beanbang.generator.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    cn.beanbang.generator.pojo.Entity entity;

    private String fieldName;

    private String columnName;

    private String dataType;

    private boolean primaryKey;

    private boolean notNull;

    private boolean valueUnique;

    private boolean zeroFilled;

    private boolean autoIncremental;

    private String defaultValue;
}
