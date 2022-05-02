package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.Common;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (Common)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:25:06
 */
public interface CommonRepository extends JpaRepository<Common ,Long>{

  
}


