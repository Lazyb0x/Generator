package cn.beanbang.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonParseTest {
    /**
     * 解析Json文件测试
     * @throws IOException
     */
    @Test
    void parseTest() throws IOException {
        File file = new File("templates/sql/config.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        //String fileName = jsonNode.get("entity").get("fileName").asText();
        Map<String, Object> map = objectMapper.readValue(file, Map.class);
        List<Map<String, Object>> vmFiles = (List)map.get("files");

        for (Map m : vmFiles){
            System.out.println(m.get("fileName"));
            System.out.println(m.get("type"));
            System.out.println(m.get("exportSuffix"));
        }

        //System.out.println(fileName);
    }
}
