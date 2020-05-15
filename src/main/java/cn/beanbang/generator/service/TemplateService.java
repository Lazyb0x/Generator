package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.TemplateDAO;
import cn.beanbang.generator.model.po.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    TemplateDAO templateDAO;

    public List<Template> findAll(){
        return templateDAO.findAll();
    }

    public Template add(Template template){
        return templateDAO.save(template);
    }

    public Template update(Template template){
        return templateDAO.save(template);
    }

    public void delete(int id){
        templateDAO.deleteById(id);
    }
}
