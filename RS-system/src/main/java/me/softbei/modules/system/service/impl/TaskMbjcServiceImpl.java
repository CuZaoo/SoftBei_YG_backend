package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.TaskMbjc;
import me.softbei.modules.system.repository.TaskMbjcRepository;
import me.softbei.modules.system.service.TaskMbjcService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskMbjc)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:27:15
 */
@Service("taskMbjcService")
public class TaskMbjcServiceImpl implements TaskMbjcService {
    @Resource
    private TaskMbjcRepository taskMbjcRepository;

    @Override
    public TaskMbjc queryById(Long mbjcId) {
        return this.taskMbjcRepository.getOne(mbjcId);
    }

    @Override
    public List<TaskMbjc> getall() {
        return this.taskMbjcRepository.findAll();

    }
    
     @Override
    public Page<TaskMbjc> queryAllByLimit(int offset, int limit) {
        return this.taskMbjcRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public TaskMbjc insert(TaskMbjc taskMbjc) {
       
        return this.taskMbjcRepository.save(taskMbjc);
    }


    @Override
    public TaskMbjc update(TaskMbjc taskMbjc) {
       
        return this.taskMbjcRepository.save(taskMbjc);
    }

  
    @Override
    public boolean deleteById(Long mbjcId) {
    
     try{
             this.taskMbjcRepository.deleteById(mbjcId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


