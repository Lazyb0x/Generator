package cn.beanbang.generator;

import cn.beanbang.generator.model.po.Field;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class FileTests {
    @Test
    void fileTEst(){
        File file = new File(".");
        File[] fileList = file.listFiles();
        for (File f : fileList){
            System.out.println(f.getName());
        }
    }

    @Test
    void sql(){
        // 初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        //ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        //ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        // 获取模板文件
        Template t = ve.getTemplate("templates/sql/hello.vm");
        // 设置变量
        VelocityContext ctx = new VelocityContext();
        ctx.put("entityName", "student");
        List<String> list = new ArrayList<String>();
        list.add("id");
        list.add("name");
        ctx.put("fieldList", list);
        // 输出
        StringWriter sw = new StringWriter();
        t.merge(ctx,sw);
        System.out.println(sw.toString());
    }

    @Test
    void stringTest(){
        Field field = new Field();
        System.out.println(field);
    }

}
