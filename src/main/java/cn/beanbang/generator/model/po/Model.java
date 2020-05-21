package cn.beanbang.generator.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * 数据库模型表
 * 一个模型里面有多个表
 */
@Entity
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String comment;

    public Model(){};

    public Model(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Transient
    @JsonIgnore
    List<cn.beanbang.generator.model.po.Entity> entities;
}
