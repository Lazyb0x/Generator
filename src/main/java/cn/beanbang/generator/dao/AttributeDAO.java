package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeDAO extends JpaRepository<Attribute, Integer> {
}
