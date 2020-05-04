package cn.beanbang.generator;

import cn.beanbang.generator.dao.EntityDAO;
import cn.beanbang.generator.dao.FieldDAO;
import cn.beanbang.generator.model.dto.EntityDTO;
import cn.beanbang.generator.model.po.Entity;
import cn.beanbang.generator.model.po.Field;
import cn.beanbang.generator.util.VelocityInitializer;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class VelocityTests {

    @Autowired
    FieldDAO fieldDAO;

    @Autowired
    EntityDAO entityDAO;

    @Test
    void parseSQLTest(){
//        VelocityInitializer.initVelocity();
//        Field field = fieldDAO.findById(1).get();
//        System.out.println(field);

        Entity entity = entityDAO.findById(1).get();
        List<Field> fields = fieldDAO.findFieldByEntity(entity);
        EntityDTO edto = EntityDTO.of(entity, fields);

        // 初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        //ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        //ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        // 获取模板文件
        Template t = ve.getTemplate("templates/sql/hello.vm");
        // 设置变量
        VelocityContext ctx = new VelocityContext();
        ctx.put("entity", edto);
//        List<String> list = new ArrayList<String>();
//        list.add("id");
//        list.add("name");
//        ctx.put("fieldList", list);
        // 输出
        StringWriter sw = new StringWriter();
        t.merge(ctx,sw);
        System.out.println(sw.toString());
        assert true;
    }

}
