package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.EntityDAO;
import cn.beanbang.generator.pojo.Entity;
import cn.beanbang.generator.pojo.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {
    @Autowired
    EntityDAO entityDAO;

    public List<Entity> findByModelId(int modelId){
        return entityDAO.findEntityByModel(new Model(){{setId(modelId);}});
    }

    public Entity add(Entity entity){
        return entityDAO.save(entity);
    }

    public Entity update(Entity entity){
        return  entityDAO.save(entity);
    }

    public void delete(int id){
        entityDAO.deleteById(id);
    }
}
