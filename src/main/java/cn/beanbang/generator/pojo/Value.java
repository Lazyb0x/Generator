package cn.beanbang.generator.pojo;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * 属性值表
 * 实例的配置，储存具体的项目信息，比如包名，artifact id 等
 */
@Entity
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    Attribute attribute;

    String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
