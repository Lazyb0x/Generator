package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.EntityDAO;
import cn.beanbang.generator.model.po.Entity;
import cn.beanbang.generator.model.po.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {
    @Autowired
    EntityDAO entityRepository;

    public List<Entity> findByModelId(int modelId){
        return entityRepository.findEntityByModel(new Model(){{setId(modelId);}});
    }

    public Entity add(Entity entity){
        return entityRepository.save(entity);
    }

    public Entity update(Entity entity){
        return  entityRepository.save(entity);
    }

    public void delete(int id){
        entityRepository.deleteById(id);
    }
}
