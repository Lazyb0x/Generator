package cn.beanbang.generator.dao;

import cn.beanbang.generator.pojo.Instance;
import cn.beanbang.generator.pojo.Model;
import cn.beanbang.generator.pojo.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstanceDAO extends JpaRepository<Instance, Integer> {
    List<Instance> findInstanceByModelAndTemplate(Model model, Template template);
}
