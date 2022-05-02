package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.Task;
import me.softbei.modules.system.repository.TaskRepository;
import me.softbei.modules.system.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Task)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:26:46
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskRepository taskRepository;

    @Override
    public Task queryById(Long taskId) {
        return this.taskRepository.getOne(taskId);
    }

    @Override
    public List<Task> getall() {
        return this.taskRepository.findAll();

    }
    
     @Override
    public Page<Task> queryAllByLimit(int offset, int limit) {
        return this.taskRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public Task insert(Task task) {
       
        return this.taskRepository.save(task);
    }


    @Override
    public Task update(Task task) {
       
        return this.taskRepository.save(task);
    }

  
    @Override
    public boolean deleteById(Long taskId) {
    
     try{
             this.taskRepository.deleteById(taskId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


