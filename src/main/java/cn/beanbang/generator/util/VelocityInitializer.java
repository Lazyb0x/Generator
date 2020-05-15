package cn.beanbang.generator.util;

import org.apache.velocity.app.Velocity;

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
}
