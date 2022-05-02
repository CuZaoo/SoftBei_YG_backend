package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.Task;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Task)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:26:46
 */
public interface TaskService {
    Task queryById(Long taskId);
    Page<Task> queryAllByLimit(int offset, int limit);
    Task insert(Task task);
    Task update(Task task);
    boolean deleteById(Long taskId);
     List<Task> getall();
}


