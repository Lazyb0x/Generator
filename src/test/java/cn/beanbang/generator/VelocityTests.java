package cn.beanbang.generator;

import cn.beanbang.generator.dao.EntityDAO;
import cn.beanbang.generator.dao.FieldDAO;
import cn.beanbang.generator.model.dto.EntityDTO;
import cn.beanbang.generator.model.po.Entity;
import cn.beanbang.generator.model.po.Field;
import cn.beanbang.generator.util.VelocityInitializer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

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
        System.out.println(serialize(edto));

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

    public String serialize(EntityDTO entityDTO){
        // JSON对象序列化
        String employeeJson = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter stringWriter = new StringWriter();
            JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(stringWriter);
            objectMapper.writeValue(jsonGenerator, entityDTO);
            jsonGenerator.close();
            employeeJson = stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeJson;
    }

    @Test
    void getMacros(){
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template t = ve.getTemplate("templates/sql/entity/hello.vm");
        System.out.println(t.getName());
    }

    @Test
    void velocityStringUtils(){
        String s = "Attir";
        System.out.println(s.substring(0,1).toLowerCase() + s.substring(1));
    }

    @Test
    void mapTest(){
        Properties properties = new Properties();
        properties.setProperty("test", "test");
        properties.setProperty("greet", "hello");

        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("properties", properties);

        String s = "Here is a $properties[\"test\"], ${properties[\"greet\"]}! I did it!";

        StringWriter sw = new StringWriter();
        Velocity.evaluate(context, sw, "mytest", s);
        System.out.println(sw.toString());
    }
}
