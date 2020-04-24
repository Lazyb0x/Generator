package cn.beanbang.generator.dao;

import cn.beanbang.generator.pojo.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceDAO extends JpaRepository<Instance, Integer> {
}
