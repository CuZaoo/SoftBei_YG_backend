package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.TaskGroup;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskGroup)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:31:35
 */
public interface TaskGroupService {
    TaskGroup queryById(Long groupId);
    Page<TaskGroup> queryAllByLimit(int offset, int limit);
    TaskGroup insert(TaskGroup taskGroup);
    TaskGroup update(TaskGroup taskGroup);
    boolean deleteById(Long groupId);
     List<TaskGroup> getall();
}


