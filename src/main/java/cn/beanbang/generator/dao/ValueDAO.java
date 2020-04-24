package cn.beanbang.generator.dao;

import cn.beanbang.generator.pojo.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueDAO extends JpaRepository<Value, Integer> {
}
