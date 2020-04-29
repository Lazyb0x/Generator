package cn.beanbang.generator.controller;

import cn.beanbang.generator.pojo.Entity;
import cn.beanbang.generator.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entity")
public class EntityController {
    @Autowired
    EntityService entityService;

    @GetMapping
    public List<Entity> list(int id){
        return entityService.findByModelId(id);
    }

    @PostMapping
    public Entity add(@RequestBody Entity entity){
        return entityService.add(entity);
    }

    @PutMapping
    public Entity update(@RequestBody Entity entity){
        return entityService.update(entity);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        entityService.delete(id);
        return null;
    }
}
