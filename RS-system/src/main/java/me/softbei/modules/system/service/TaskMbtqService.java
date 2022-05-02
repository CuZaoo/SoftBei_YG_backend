package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.TaskMbtq;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaskMbtq)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:27:22
 */
public interface TaskMbtqService {
    TaskMbtq queryById(Long mbtqId);
    Page<TaskMbtq> queryAllByLimit(int offset, int limit);
    TaskMbtq insert(TaskMbtq taskMbtq);
    TaskMbtq update(TaskMbtq taskMbtq);
    boolean deleteById(Long mbtqId);
     List<TaskMbtq> getall();
}


