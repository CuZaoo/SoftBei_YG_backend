package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.TaksDwjc;
import me.softbei.modules.system.repository.TaksDwjcRepository;
import me.softbei.modules.system.service.TaksDwjcService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaksDwjc)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:26:39
 */
@Service("taksDwjcService")
public class TaksDwjcServiceImpl implements TaksDwjcService {
    @Resource
    private TaksDwjcRepository taksDwjcRepository;

    @Override
    public TaksDwjc queryById(Long dwjcId) {
        return this.taksDwjcRepository.getOne(dwjcId);
    }

    @Override
    public List<TaksDwjc> getall() {
        return this.taksDwjcRepository.findAll();

    }
    
     @Override
    public Page<TaksDwjc> queryAllByLimit(int offset, int limit) {
        return this.taksDwjcRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public TaksDwjc insert(TaksDwjc taksDwjc) {
       
        return this.taksDwjcRepository.save(taksDwjc);
    }


    @Override
    public TaksDwjc update(TaksDwjc taksDwjc) {
       
        return this.taksDwjcRepository.save(taksDwjc);
    }

  
    @Override
    public boolean deleteById(Long dwjcId) {
    
     try{
             this.taksDwjcRepository.deleteById(dwjcId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


