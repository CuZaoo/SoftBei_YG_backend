package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.TaskMbjc;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskMbjc)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:27:15
 */
public interface TaskMbjcService {
    TaskMbjc queryById(Long mbjcId);
    Page<TaskMbjc> queryAllByLimit(int offset, int limit);
    TaskMbjc insert(TaskMbjc taskMbjc);
    TaskMbjc update(TaskMbjc taskMbjc);
    boolean deleteById(Long mbjcId);
     List<TaskMbjc> getall();
}


