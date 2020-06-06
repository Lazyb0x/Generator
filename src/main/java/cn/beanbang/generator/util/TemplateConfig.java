package cn.beanbang.generator.util;

import cn.beanbang.generator.model.po.Template;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.ObjectExpression;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理模板配置文件的工具类
 */
public class TemplateConfig {

    /**
     * 模板文件夹的名字
     */
    final String templateName;

    public TemplateConfig(String templateName){
        this.templateName = templateName;
    }

    /**
     * 获得模板文件的信息键值对
     * @param fileName 模板文件的文件名
     * @return Map<String, Object>
     */
    public Map<String, Object> getFileInfo(String fileName){
        File file = new File("templates/" + templateName + "/config.json");
        Map<String, Object> fileInfo = new HashMap<>();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(file);
            Map<String, Object> config = objectMapper.readValue(file, Map.class);
            List<Map<String, Object>> vmFiles = (List)config.get("files");
            for (Map f : vmFiles){
                if (fileName.equals(f.get("fileName"))){
                    fileInfo = f;
                    break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return fileInfo;
    }

    /**
     * 获得导出文件的后缀名
     * @param fileName 模板文件名
     * @return 后缀名
     */
    public String getSuffix(String fileName){
        Map<String, Object> fileInfo = getFileInfo(fileName);
        return (String)fileInfo.get("exportSuffix");
    }

    /**
     * 获得导出文件文件夹名
     * @param fileName 模板文件名
     * @return 后缀名
     */
    public String getFolder(String fileName){
        Map<String, Object> fileInfo = getFileInfo(fileName);
        return (String)fileInfo.get("exportFolder");
    }
}
