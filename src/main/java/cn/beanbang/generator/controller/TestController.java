package cn.beanbang.generator.controller;

import cn.beanbang.generator.pojo.Model;
import cn.beanbang.generator.service.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    TestModelService testModelService;

    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "Hello, world!";
    }

    @GetMapping("/testList")
    @ResponseBody
    public List<Model> listInstance(){
        return testModelService.listModel();
    }
}
