package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.InstanceDAO;
import cn.beanbang.generator.pojo.Instance;
import cn.beanbang.generator.pojo.Model;
import cn.beanbang.generator.pojo.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceService {
    @Autowired
    InstanceDAO instanceDAO;

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
}
