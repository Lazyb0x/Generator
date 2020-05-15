package cn.beanbang.generator.model.dto;

import lombok.Data;

import java.util.Properties;

@Data
public class InstanceDTO {
    private String name;
    private String comment;
    Properties properties;
}
