package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.TaskBhjc;
import me.softbei.modules.system.repository.TaskBhjcRepository;
import me.softbei.modules.system.service.TaskBhjcService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskBhjc)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:26:53
 */
@Service("taskBhjcService")
public class TaskBhjcServiceImpl implements TaskBhjcService {
    @Resource
    private TaskBhjcRepository taskBhjcRepository;

    @Override
    public TaskBhjc queryById(Long bhjcId) {
        return this.taskBhjcRepository.getOne(bhjcId);
    }

    @Override
    public List<TaskBhjc> getall() {
        return this.taskBhjcRepository.findAll();

    }
    
     @Override
    public Page<TaskBhjc> queryAllByLimit(int offset, int limit) {
        return this.taskBhjcRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public TaskBhjc insert(TaskBhjc taskBhjc) {
       
        return this.taskBhjcRepository.save(taskBhjc);
    }


    @Override
    public TaskBhjc update(TaskBhjc taskBhjc) {
       
        return this.taskBhjcRepository.save(taskBhjc);
    }

  
    @Override
    public boolean deleteById(Long bhjcId) {
    
     try{
             this.taskBhjcRepository.deleteById(bhjcId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


