package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.TaskMbtq;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (TaskMbtq)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:27:22
 */
public interface TaskMbtqRepository extends JpaRepository<TaskMbtq ,Long>{

  
}


