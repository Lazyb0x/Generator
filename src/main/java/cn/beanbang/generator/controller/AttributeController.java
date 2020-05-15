package cn.beanbang.generator.controller;

import cn.beanbang.generator.model.po.Attribute;
import cn.beanbang.generator.service.AttributeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attribute")
public class AttributeController {
    @Autowired
    AttributeService attributeService;

    @GetMapping
    public List<Attribute> list(int templateId){
        return attributeService.findByTemplateId(templateId);
    }

    @PostMapping
    public Attribute add(@RequestBody Attribute attribute){
        return attributeService.add(attribute);
    }

    @PutMapping
    public Attribute update(@RequestBody Attribute attribute){
        return attributeService.update(attribute);
    }

    @DeleteMapping
    public String delete(@PathVariable int id){
        attributeService.delete(id);
        return null;
    }
}
