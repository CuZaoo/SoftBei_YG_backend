package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.TaskMbjc;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (TaskMbjc)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:27:15
 */
public interface TaskMbjcRepository extends JpaRepository<TaskMbjc ,Long>{

  
}


