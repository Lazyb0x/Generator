package cn.beanbang.generator.controller;

import cn.beanbang.generator.model.po.Template;
import cn.beanbang.generator.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/template")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @GetMapping
    public List<Template> list(){
        return templateService.findAll();
    }

    @PostMapping
    public Template add(@RequestBody Template template){
        return templateService.add(template);
    }

    @PutMapping
    public Template update(@RequestBody Template template){
        return templateService.update(template);
    }

    @DeleteMapping("/{id}")
    public String delete(int id){
        templateService.delete(id);
        return null;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        //todo
        return null;
    }
}
