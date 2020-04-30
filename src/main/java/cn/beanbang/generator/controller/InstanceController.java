package cn.beanbang.generator.controller;

import cn.beanbang.generator.pojo.Instance;
import cn.beanbang.generator.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instance")
public class InstanceController {
    @Autowired
    InstanceService instanceService;

    @GetMapping
    public List<Instance> list(int modelId, int templateId){
        return instanceService.findByModelIdAndTemplateId(modelId, templateId);
    }

    @PostMapping
    public Instance add(@RequestBody Instance instance){
        return instanceService.add(instance);
    }

    @PutMapping
    public Instance update(@RequestBody Instance instance){
        return instanceService.update(instance);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        instanceService.delete(id);
        return null;
    }
}
