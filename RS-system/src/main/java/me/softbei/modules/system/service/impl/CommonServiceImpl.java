package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.Common;
import me.softbei.modules.system.repository.CommonRepository;
import me.softbei.modules.system.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Common)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:25:06
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
    @Resource
    private CommonRepository commonRepository;

    @Override
    public Common queryById(Long commonId) {
        return this.commonRepository.getOne(commonId);
    }

    @Override
    public List<Common> getall() {
        return this.commonRepository.findAll();

    }
    
     @Override
    public Page<Common> queryAllByLimit(int offset, int limit) {
        return this.commonRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public Common insert(Common common) {
       
        return this.commonRepository.save(common);
    }


    @Override
    public Common update(Common common) {
       
        return this.commonRepository.save(common);
    }

  
    @Override
    public boolean deleteById(Long commonId) {
    
     try{
             this.commonRepository.deleteById(commonId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


