package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.FieldDAO;
import cn.beanbang.generator.dao.InstanceDAO;
import cn.beanbang.generator.model.dto.EntityDTO;
import cn.beanbang.generator.model.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class InstanceService {
    @Autowired
    InstanceDAO instanceDAO;

    @Autowired
    FieldDAO fieldDAO;

    public List<Instance> findByModelIdAndTemplateId(int modelId, int templateId){
        return instanceDAO.findInstanceByModelAndTemplate(
                new Model(){{setId(modelId);}},
                new Template(){{setId(templateId);}}
        );
    }

    public Instance add(Instance instance){
        return instanceDAO.save(instance);
    }

    public Instance update(Instance instance){
        return instanceDAO.save(instance);
    }

    public void delete(int id){
        instanceDAO.deleteById(id);
    }

    public File generate(int id) {
        //todo
        return  null;
    }

    /**
     * 获取实例对象
     * @param id
     * @return
     */
    public EntityDTO getEntityDTO(int id){
        Instance instance = instanceDAO.findById(id).get();
        String folderName = instance.getTemplate().getName();
        Model model = instance.getModel();
        //todo
        return  null;
    }
}
