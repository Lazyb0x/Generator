package cn.beanbang.generator.controller;

import cn.beanbang.generator.model.po.Model;
import cn.beanbang.generator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
public class ModelController {
    @Autowired
    ModelService modelService;

    @GetMapping
    public List<Model> list(){
        return modelService.findAll();
    }

    @PostMapping
    public Model add(@RequestBody Model model){
        return modelService.add(model);
    }

    @PutMapping
    public Model update(@RequestBody Model model){
        return modelService.update(model);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        modelService.delete(id);
        return null;
    }
}
