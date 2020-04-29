package cn.beanbang.generator.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
}
