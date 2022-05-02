package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.TaskGroup;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (TaskGroup)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:31:35
 */
public interface TaskGroupRepository extends JpaRepository<TaskGroup ,Long>{

  
}


