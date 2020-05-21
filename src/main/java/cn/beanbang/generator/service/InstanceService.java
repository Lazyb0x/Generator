package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.*;
import cn.beanbang.generator.model.po.*;
import cn.beanbang.generator.util.VelocityInitializer;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

@Service
public class InstanceService {
    @Autowired
    InstanceDAO instanceDAO;

    @Autowired
    FieldDAO fieldDAO;

    @Autowired
    EntityDAO entityDAO;

    @Autowired
    AttributeDAO attributeDAO;

    @Autowired
    ValueDAO valueDAO;

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
        Instance instance = this.getFullInstance(id);

        String folderName = instance.getTemplate().getName();
        String projectFolder = "./templates/" + folderName + "/project";
        File[] files = new File(projectFolder).listFiles();

        for (File f : files){
            String name = f.getName();
            VelocityEngine ve = new VelocityEngine();
            ve.init();
            org.apache.velocity.Template t = ve.getTemplate(
                    projectFolder + "/" + name
            );

            VelocityContext ctx = new VelocityContext();
            ctx.put("instance", instance);

            StringWriter sw = new StringWriter();
            t.merge(ctx, sw);

            System.out.println(sw.toString());
        }

        String entityFolder = "./templates/" + folderName + "/entity";
        File[] eFiles = new File(entityFolder).listFiles();
        List<Entity> entities = instance.getModel().getEntities();

        for (File f : eFiles){
            String path = entityFolder + "/" + f.getName();

            for (Entity e : entities){
                VelocityContext ctx = new VelocityContext();
                ctx.put("instance", instance);
                ctx.put("entity", e);
                StringWriter sw = VelocityInitializer.render(path, ctx);

                System.out.println(sw);
            }
        }
        return null;
    }

    /**
     * 获取实例对象
     * @param id 实例id
     * @return 填充了实体和字段的实例对象
     */
    public Instance getFullInstance(int id){
        Instance instance = instanceDAO.findById(id).get();
        Model model = instance.getModel();
        Template template = instance.getTemplate();

        // 填充实体
        List<Entity> entities = entityDAO.findEntityByModel(model);
        for(Entity e : entities){
            List<Field> fields = fieldDAO.findFieldByEntity(e);
            e.setFields(fields);
        }

        // 填充模型
        model.setEntities(entities);

        // 填充属性和属性值
        List<Attribute> attributes = attributeDAO.findAttributeByTemplate(template);
        List<Value> values = valueDAO.findValueByInstance(instance);
        Properties properties = new Properties();

        for (Attribute att : attributes){
            boolean isFound = false;
            for (Value val : values){
                if (att.getId()==val.getAttribute().getId()){
                    isFound = true;
                    properties.setProperty(att.getName(), val.getContent());
                }
            }
            if (!isFound){
                properties.setProperty(att.getName(), att.getDefaultValue());
            }
        }

        instance.setProperties(properties);

        return instance;
    }
}
