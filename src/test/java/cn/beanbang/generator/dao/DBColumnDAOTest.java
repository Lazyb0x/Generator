package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Field;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DBColumnDAOTest {

    @Autowired
    DBColumnDAO dbColumnDAO;

    @Test
    void findColumnByTableName() {
        List<Field> fields = dbColumnDAO.findColumnByTableName("book");
        for (Field f : fields){
            System.out.println(f);
        }
    }
}