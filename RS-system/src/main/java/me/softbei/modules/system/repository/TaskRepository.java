package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.Task;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (Task)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:26:46
 */
public interface TaskRepository extends JpaRepository<Task ,Long>{

  
}


