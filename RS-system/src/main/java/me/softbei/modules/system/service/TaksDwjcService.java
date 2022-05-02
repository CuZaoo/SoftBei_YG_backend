package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.TaksDwjc;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (TaksDwjc)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:26:39
 */
public interface TaksDwjcService {
    TaksDwjc queryById(Long dwjcId);
    Page<TaksDwjc> queryAllByLimit(int offset, int limit);
    TaksDwjc insert(TaksDwjc taksDwjc);
    TaksDwjc update(TaksDwjc taksDwjc);
    boolean deleteById(Long dwjcId);
     List<TaksDwjc> getall();
}


