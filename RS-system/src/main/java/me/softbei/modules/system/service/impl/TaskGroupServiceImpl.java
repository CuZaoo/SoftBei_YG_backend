package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.TaskGroup;
import me.softbei.modules.system.repository.TaskGroupRepository;
import me.softbei.modules.system.service.TaskGroupService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskGroup)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:31:35
 */
@Service("taskGroupService")
public class TaskGroupServiceImpl implements TaskGroupService {
    @Resource
    private TaskGroupRepository taskGroupRepository;

    @Override
    public TaskGroup queryById(Long groupId) {
        return this.taskGroupRepository.getOne(groupId);
    }

    @Override
    public List<TaskGroup> getall() {
        return this.taskGroupRepository.findAll();

    }
    
     @Override
    public Page<TaskGroup> queryAllByLimit(int offset, int limit) {
        return this.taskGroupRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public TaskGroup insert(TaskGroup taskGroup) {
       
        return this.taskGroupRepository.save(taskGroup);
    }


    @Override
    public TaskGroup update(TaskGroup taskGroup) {
       
        return this.taskGroupRepository.save(taskGroup);
    }

  
    @Override
    public boolean deleteById(Long groupId) {
    
     try{
             this.taskGroupRepository.deleteById(groupId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


