package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Entity;
import cn.beanbang.generator.model.po.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntityDAO extends JpaRepository<Entity, Integer> {
    List<Entity> findEntityByModel(Model model);
}
