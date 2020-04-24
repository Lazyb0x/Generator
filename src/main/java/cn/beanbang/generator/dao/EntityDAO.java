package cn.beanbang.generator.dao;

import cn.beanbang.generator.pojo.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityDAO extends JpaRepository<Entity, Integer> {
}
