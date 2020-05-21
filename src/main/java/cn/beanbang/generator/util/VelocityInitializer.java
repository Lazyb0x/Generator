package cn.beanbang.generator.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Properties;

public class VelocityInitializer {
    public static void initVelocity(){
        Properties properties = new Properties();
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");

        try{
            Velocity.init(properties);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static StringWriter render(String path, VelocityContext context){
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template t = ve.getTemplate(path);
        StringWriter sw = new StringWriter();
        t.merge(context, sw);
        return sw;
    }
}
