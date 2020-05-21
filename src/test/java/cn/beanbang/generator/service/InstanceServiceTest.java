package cn.beanbang.generator.service;

import cn.beanbang.generator.model.po.Instance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InstanceServiceTest {
    @Autowired
    InstanceService instanceService;

    @Test
    void getFullInstance() {
        Instance instance = instanceService.getFullInstance(1);
        System.out.println(instance);
    }

    @Test
    void generate(){
        instanceService.generate(1);
    }
}