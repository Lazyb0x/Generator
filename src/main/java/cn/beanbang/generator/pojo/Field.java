package cn.beanbang.generator.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    cn.beanbang.generator.pojo.Entity entity;

    private String fieldName;

    private String columnName;

    private String dataType;

    private boolean primaryKey;

    private boolean notNull;

    private boolean valueUnique;

    private boolean zeroFilled;

    private boolean autoIncremental;

    private String defaultValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public cn.beanbang.generator.pojo.Entity getEntity() {
        return entity;
    }

    public void setEntity(cn.beanbang.generator.pojo.Entity entity) {
        this.entity = entity;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean isUnique() {
        return valueUnique;
    }

    public void setUnique(boolean unique) {
        this.valueUnique = unique;
    }

    public boolean isZeroFilled() {
        return zeroFilled;
    }

    public void setZeroFilled(boolean zeroFilled) {
        this.zeroFilled = zeroFilled;
    }

    public boolean isAutoIncremental() {
        return autoIncremental;
    }

    public void setAutoIncremental(boolean autoIncremental) {
        this.autoIncremental = autoIncremental;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
