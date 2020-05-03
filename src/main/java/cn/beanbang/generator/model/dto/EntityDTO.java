package cn.beanbang.generator.model.dto;

import cn.beanbang.generator.model.po.Entity;
import cn.beanbang.generator.model.po.Field;
import lombok.Data;

import java.util.List;

@Data
public class EntityDTO {
    private String entityName;

    private String tableName;

    private String comments;

    private List<Field> fields;

    public static EntityDTO of(Entity entity, List<Field> fields){
        EntityDTO newe = new EntityDTO();
        newe.entityName = entity.getEntityName();
        newe.tableName = entity.getTableName();
        newe.comments = entity.getComments();
        newe.fields = fields;
        return newe;
    }
}
