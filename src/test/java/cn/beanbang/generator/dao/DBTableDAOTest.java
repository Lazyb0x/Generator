package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Entity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DBTableDAOTest {

    @Autowired
    DBTableDAO dBTableDAO;

    @Test
    void findAllTable(){
        List<Entity> entities = dBTableDAO.findAllTable();
        for (Entity e : entities){
            System.out.println(e.getTableName());
        }
    }
}