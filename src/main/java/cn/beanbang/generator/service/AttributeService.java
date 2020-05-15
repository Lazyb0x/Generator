package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.AttributeDAO;
import cn.beanbang.generator.model.po.Attribute;
import cn.beanbang.generator.model.po.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {
    @Autowired
    AttributeDAO attributeDAO;

    public List<Attribute> findByTemplateId(int templateId){
        return attributeDAO.findAttributeByTemplate(new Template(){{setId(templateId);}});
    }

    public Attribute add(Attribute attribute){
        return attributeDAO.save(attribute);
    }

    public Attribute update(Attribute attribute){
        return attributeDAO.save(attribute);
    }

    public void delete(int id){
        attributeDAO.deleteById(id);
    }
}
