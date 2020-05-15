package cn.beanbang.generator.controller;

import cn.beanbang.generator.model.po.Value;
import cn.beanbang.generator.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/value")
public class ValueController {
    @Autowired
    ValueService valueService;

    @GetMapping
    public List<Value> list(int instanceId, int attributeId){
        return valueService.findByInstanceId(instanceId, attributeId);
    }

    @PostMapping
    public Value add(@RequestBody Value value){
        return valueService.add(value);
    }

    @PutMapping
    public Value update(@RequestBody Value value){
        return valueService.update(value);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        valueService.delete(id);
        return null;
    }
}
