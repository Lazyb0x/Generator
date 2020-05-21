package cn.beanbang.generator.service;

import cn.beanbang.generator.dao.DBColumnDAO;
import cn.beanbang.generator.dao.DBTableDAO;
import cn.beanbang.generator.dao.ModelDAO;
import cn.beanbang.generator.model.po.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    ModelDAO modelDAO;

    @Autowired
    DBTableDAO dbTableDAO;
//
//    @Autowired
//    DBColumnDAO dbColumnDAO;

    public List<Model> findAll(){
        return modelDAO.findAll();
    }

    public Model add(Model model){
        return modelDAO.save(model);
    }

    public Model update(Model model){
        return modelDAO.save(model);
    }

    public void delete(int id){
        modelDAO.deleteById(id);
    }
}
