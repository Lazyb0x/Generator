package cn.beanbang.generator.controller;

import cn.beanbang.generator.model.po.Field;
import cn.beanbang.generator.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/field")
public class FieldController {
    @Autowired
    FieldService fieldService;

    @GetMapping
    public List<Field> list(int entityId){
        return fieldService.findByEntityId(entityId);
    }

    @PostMapping
    public Field add(@RequestBody Field field){
        return fieldService.add(field);
    }

    @PutMapping
    public Field update(@RequestBody Field field){
        return fieldService.update(field);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        fieldService.delete(id);
        return null;
    }
}
