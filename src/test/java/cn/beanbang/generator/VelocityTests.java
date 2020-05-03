package cn.beanbang.generator;

import cn.beanbang.generator.dao.FieldDAO;
import cn.beanbang.generator.model.po.Field;
import cn.beanbang.generator.util.VelocityInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VelocityTests {

    @Autowired
    FieldDAO fieldDAO;

    @Test
    void parseSQLTest(){
        VelocityInitializer.initVelocity();
        Field field = fieldDAO.findById(1).get();
        System.out.println(field);
        assert true;
    }
}
