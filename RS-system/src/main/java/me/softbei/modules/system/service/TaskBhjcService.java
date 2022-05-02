package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.TaskBhjc;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskBhjc)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:26:53
 */
public interface TaskBhjcService {
    TaskBhjc queryById(Long bhjcId);
    Page<TaskBhjc> queryAllByLimit(int offset, int limit);
    TaskBhjc insert(TaskBhjc taskBhjc);
    TaskBhjc update(TaskBhjc taskBhjc);
    boolean deleteById(Long bhjcId);
     List<TaskBhjc> getall();
}


