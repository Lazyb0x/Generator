package cn.beanbang.generator.dao;

import cn.beanbang.generator.pojo.Entity;
import cn.beanbang.generator.pojo.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldDAO extends JpaRepository<Field, Integer> {
    List<Field> findFieldByEntity(Entity entity);
}
