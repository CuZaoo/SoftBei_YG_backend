package me.softbei.modules.system.repository;

import me.softbei.modules.system.domain.Message;

import java.util.List;

import me.softbei.modules.system.domain.vo.Message7DayVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * (Message)表数据库访问层
 *
 * @author !author
 * @since 2022-04-30 11:18:15
 */
public interface MessageRepository extends JpaRepository<Message ,Long>{

//    SELECT DATE_FORMAT( create_time, '%Y-%m-%d' ) days,COUNT(*) COUNT
    @Modifying
    @Query(value = "SELECT DATE_FORMAT( create_time, '%m-%d' ) days,COUNT(*) times FROM ( SELECT * FROM message WHERE DATE_SUB( CURDATE( ), INTERVAL 7 DAY ) <= DATE( create_time) ) as  datas group by days",nativeQuery = true)
    List<Object[]> getMessageSizeOf7Days();

    @Modifying
    @Query(value = "select  *  from  message order by rand() limit ?",nativeQuery = true)
    List<Message> getSomeMessage(Integer nums);

}


