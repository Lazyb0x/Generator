package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Attribute;
import cn.beanbang.generator.model.po.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeDAO extends JpaRepository<Attribute, Integer> {
    List<Attribute> findAttributeByTemplate(Template template);
}
