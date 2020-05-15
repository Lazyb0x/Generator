package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.ValueDAO;
import cn.beanbang.generator.model.po.Attribute;
import cn.beanbang.generator.model.po.Instance;
import cn.beanbang.generator.model.po.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueService {
    @Autowired
    ValueDAO valueDAO;

    public List<Value> findByInstanceId(int instanceId, int attributeId) {
        return valueDAO.findValueByInstanceAndAttribute(
                new Instance() {{
                    setId(instanceId);
                }},
                new Attribute() {{
                    setId(attributeId);
                }}
        );
    }

    public Value add(Value value) {
        return valueDAO.save(value);
    }

    public Value update(Value value) {
        return valueDAO.save(value);
    }

    public void delete(int id) {
        valueDAO.deleteById(id);
    }
}
