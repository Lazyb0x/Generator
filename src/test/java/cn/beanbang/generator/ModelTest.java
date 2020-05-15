package cn.beanbang.generator;

import cn.beanbang.generator.dao.ModelDAO;
import cn.beanbang.generator.model.po.Model;
import cn.beanbang.generator.service.ModelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ModelTest {

    @Autowired
    ModelDAO modelDAO;

    @Test
    void saveTest(){
        Model model = new Model();
        model.setName("测试模型");
        model.setComment("测试注释");
        Model newModel = modelDAO.save(model);
        System.out.println(model);
        assert model.equals(newModel);
    }
}
