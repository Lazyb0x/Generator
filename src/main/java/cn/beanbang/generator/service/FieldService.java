package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.FieldDAO;
import cn.beanbang.generator.model.po.Entity;
import cn.beanbang.generator.model.po.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {
    @Autowired
    FieldDAO fieldDAO;

    public List<Field> findByEntityId(int entityId){
        return fieldDAO.findFieldByEntity(new Entity(){{setId(entityId);}});
    }

    public Field add(Field field){
        return fieldDAO.save(field);
    }

    public Field update(Field field){
        return fieldDAO.save(field);
    }

    public void delete(int id){
        fieldDAO.deleteById(id);
    }
}
