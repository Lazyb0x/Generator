package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDAO extends JpaRepository<Model, Integer> {
}
