package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.Model;
import me.softbei.modules.system.repository.ModelRepository;
import me.softbei.modules.system.service.ModelService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Model)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:25:58
 */
@Service("modelService")
public class ModelServiceImpl implements ModelService {
    @Resource
    private ModelRepository modelRepository;

    @Override
    public Model queryById(Long modelId) {
        return this.modelRepository.getOne(modelId);
    }

    @Override
    public List<Model> getall() {
        return this.modelRepository.findAll();

    }

    /**
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Model> getModelByPage(int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1,size);
        return this.modelRepository.findAll(pageable);
    }


    @Override
    public Page<Model> queryAllByLimit(int offset, int limit) {
        return this.modelRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public Model insert(Model model) {
       
        return this.modelRepository.save(model);
    }


    @Override
    public Model update(Model model) {
       
        return this.modelRepository.save(model);
    }

  
    @Override
    public boolean deleteById(Long modelId) {
    
     try{
             this.modelRepository.deleteById(modelId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


