package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.TaskMbtq;
import me.softbei.modules.system.repository.TaskMbtqRepository;
import me.softbei.modules.system.service.TaskMbtqService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskMbtq)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:27:22
 */
@Service("taskMbtqService")
public class TaskMbtqServiceImpl implements TaskMbtqService {
    @Resource
    private TaskMbtqRepository taskMbtqRepository;

    @Override
    public TaskMbtq queryById(Long mbtqId) {
        return this.taskMbtqRepository.getOne(mbtqId);
    }

    @Override
    public List<TaskMbtq> getall() {
        return this.taskMbtqRepository.findAll();

    }
    
     @Override
    public Page<TaskMbtq> queryAllByLimit(int offset, int limit) {
        return this.taskMbtqRepository.findAll(PageRequest.of((offset-1)
*limit,limit));
    }

    @Override
    public TaskMbtq insert(TaskMbtq taskMbtq) {
       
        return this.taskMbtqRepository.save(taskMbtq);
    }


    @Override
    public TaskMbtq update(TaskMbtq taskMbtq) {
       
        return this.taskMbtqRepository.save(taskMbtq);
    }

  
    @Override
    public boolean deleteById(Long mbtqId) {
    
     try{
             this.taskMbtqRepository.deleteById(mbtqId) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}


