package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBTableDAO {

    @Autowired
    ApplicationContext ctx;

    public List<Entity> findAllTable() {
        List<Entity> entities = new ArrayList<>();

        DataSource ds = (DataSource) ctx.getBean("dataSource");
        Connection c = DataSourceUtils.getConnection(ds);
        try {
            PreparedStatement ps = c.prepareStatement(
                    "SELECT table_name\n" +
                            "FROM information_schema.tables\n" +
                            "WHERE table_schema = 'generator'\n" +
                            "ORDER BY table_name;"
            );
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("table_name");

                entities.add(new Entity(){{setTableName(name);}});
//                System.out.println(name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                c.close();
            } catch (SQLException e) { }
        } finally {
            DataSourceUtils.releaseConnection(c, ds);
        }

        return entities;
    }

}
