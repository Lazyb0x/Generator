package cn.beanbang.generator.controller;

import cn.beanbang.generator.model.po.Instance;
import cn.beanbang.generator.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
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

    @GetMapping("/codePreview")
    public List<Object> preview(int id){
        //todo
        return null;
    }

    @GetMapping("/download")
    public String download(int id, HttpServletResponse response) throws IOException {
        //todo
        byte[] file = instanceService.generate(id);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + file.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        response.getOutputStream().write(file);
        return null;
    }
}
