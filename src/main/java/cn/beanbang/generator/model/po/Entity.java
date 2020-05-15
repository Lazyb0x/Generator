package cn.beanbang.generator.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 实体表
 * 对应数据库表
 */
@javax.persistence.Entity
@Data
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    Model model;

    private String entityName;

    private String tableName;

    private String comments;

    @Transient
    @JsonIgnore
    private List<Field> fields;
}
