package cn.beanbang.generator.service;

import cn.beanbang.generator.pojo.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestModelService {

    public List<Model> listModel(){
        List<Model> modelList = new ArrayList<>();

        for (int i=0; i<10; i++){
            Model model= new Model("Springboot", Integer.toString(i));
            modelList.add(model);
        }

        return modelList;
    }
}
