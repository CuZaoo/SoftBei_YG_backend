package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.Model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (Model)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:25:58
 */
public interface ModelRepository extends JpaRepository<Model ,Long>{

  
}


