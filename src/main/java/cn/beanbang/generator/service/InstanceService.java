package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.*;
import cn.beanbang.generator.model.po.*;
import cn.beanbang.generator.util.TemplateConfig;
import cn.beanbang.generator.util.VelocityInitializer;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

    public List<Instance> findByModelIdAndTemplateId(int modelId, int templateId) {
        return instanceDAO.findInstanceByModelAndTemplate(
                new Model() {{
                    setId(modelId);
                }},
                new Template() {{
                    setId(templateId);
                }}
        );
    }

    public Instance add(Instance instance) {
        return instanceDAO.save(instance);
    }

    public Instance update(Instance instance) {
        return instanceDAO.save(instance);
    }

    public void delete(int id) {
        instanceDAO.deleteById(id);
    }

    public byte[] generate(int id) {
        Instance instance = this.getFullInstance(id);

        // 模板和模板配置文件
        String templateName = instance.getTemplate().getName();
        TemplateConfig config = new TemplateConfig(templateName);

        // zip文件输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        // 属于项目的代码生成
        String projectFolder = "./templates/" + templateName + "/project";
        File[] files = new File(projectFolder).listFiles();

        for (File f : files) {
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

//            System.out.println(sw.toString());
            String exportName = config.getFolder(f.getName()) + config.getSuffix(f.getName());
            ZipEntry entry = new ZipEntry(exportName);
//            System.out.println(exportName);

            zipWrite(zip, entry, sw);
        }

        // 属于软件分层（实体）的代码生成
        String entityFolder = "./templates/" + templateName + "/entity";
        File[] eFiles = new File(entityFolder).listFiles();
        List<Entity> entities = instance.getModel().getEntities();

        for (File f : eFiles) {
            String path = entityFolder + "/" + f.getName();

            for (Entity e : entities) {
                VelocityContext ctx = new VelocityContext();
                ctx.put("instance", instance);
                ctx.put("entity", e);
                StringWriter sw = VelocityInitializer.render(path, ctx);

//                System.out.println(sw);
                String exportName = config.getFolder(f.getName()) + "/" +
                        e.getEntityName() +
                        config.getSuffix(f.getName());
                ZipEntry entry = new ZipEntry(exportName);
//                System.out.println(exportName);

                zipWrite(zip, entry, sw);
            }
        }

        return outputStream.toByteArray();
    }

    /**
     * 获取实例对象
     *
     * @param id 实例id
     * @return 填充了实体和字段的实例对象
     */
    public Instance getFullInstance(int id) {
        Instance instance = instanceDAO.findById(id).get();
        Model model = instance.getModel();
        Template template = instance.getTemplate();

        // 填充实体
        List<Entity> entities = entityDAO.findEntityByModel(model);
        for (Entity e : entities) {
            List<Field> fields = fieldDAO.findFieldByEntity(e);
            e.setFields(fields);
        }

        // 填充模型
        model.setEntities(entities);

        // 填充属性和属性值
        List<Attribute> attributes = attributeDAO.findAttributeByTemplate(template);
        List<Value> values = valueDAO.findValueByInstance(instance);
        Properties properties = new Properties();

        for (Attribute att : attributes) {
            boolean isFound = false;
            for (Value val : values) {
                if (att.getId() == val.getAttribute().getId()) {
                    isFound = true;
                    properties.setProperty(att.getName(), val.getContent());
                }
            }
            // 对于属性值不存在的，用默认值来填充
            if (!isFound) {
                properties.setProperty(att.getName(), att.getDefaultValue());
            }
        }

        instance.setProperties(properties);

        return instance;
    }

    /**
     * 装配zip输出流，用于提供文件下载
     *
     * @param zip      zipOutputStream
     * @param code     生成的代码
     */
    private void zipWrite(ZipOutputStream zip, ZipEntry entry, StringWriter code) {
        try {
            zip.putNextEntry(entry);
            zip.write(code.toString().getBytes("UTF-8"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                code.close();
                zip.flush();
                zip.closeEntry();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
