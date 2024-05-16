package service;


import bean.Pizza;
import bean.VoceDiMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoceDiMenuRepository;

import java.util.List;

@Service
public class VoceDiMenuService {

    @Autowired
    private VoceDiMenuRepository voceDiMenuRepository;

    public void salvaVoceDiMenu(VoceDiMenu voceDiMenu){
        voceDiMenuRepository.save(voceDiMenu);
    }

    public List<Pizza> getPizzePriceLessThan(double prezzo){
        return voceDiMenuRepository.findByPrezzoLessThan(prezzo);
    }

    public long countPizza(){
        return voceDiMenuRepository.countPizze();
    }
}
