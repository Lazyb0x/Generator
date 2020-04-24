package cn.beanbang.generator.dao;

import cn.beanbang.generator.pojo.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateDAO extends JpaRepository<Template, Integer> {
}
