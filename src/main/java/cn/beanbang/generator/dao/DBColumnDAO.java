package cn.beanbang.generator.dao;

import cn.beanbang.generator.model.po.Field;
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
public class DBColumnDAO {

    @Autowired
    ApplicationContext ctx;

    public List<Field> findColumnByTableName(String tableName) {
        List<Field> fields = new ArrayList<>();

        DataSource ds = (DataSource) ctx.getBean("dataSource");
        Connection c = DataSourceUtils.getConnection(ds);
        try {
            PreparedStatement ps = c.prepareStatement(
                    "SELECT column_name, column_type, column_key, is_nullable, extra, column_default\n" +
                            "FROM information_schema.columns\n" +
                            "WHERE table_name = ?;"
            );
            ps.setObject(1, tableName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Field field = new Field();
                field.setColumnName(rs.getString("column_name"));
                field.setDataType(rs.getString("column_type"));
                field.setPrimaryKey(
                        "PRI".equals(rs.getString("column_key")) );
                field.setNotNull(
                        "NO".equals(rs.getString("is_nullable")) );
                field.setAutoIncremental(
                        "auto_increment".equals(rs.getString("extra")) );
                field.setDefaultValue(rs.getString("column_default"));

                fields.add(field);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                c.close();
            } catch (SQLException e) {
            }
        } finally {
            DataSourceUtils.releaseConnection(c, ds);
        }
        return fields;
    }
}
