package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Attribute;
import cn.beanbang.generator.model.po.Instance;
import cn.beanbang.generator.model.po.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValueDAO extends JpaRepository<Value, Integer> {
    List<Value> findValueByInstanceAndAttribute(Instance instance, Attribute attribute);
    List<Value> findValueByInstance(Instance instance);
}
