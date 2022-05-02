package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.Common;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Common)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:25:06
 */
public interface CommonService {
    Common queryById(Long commonId);
    Page<Common> queryAllByLimit(int offset, int limit);
    Common insert(Common common);
    Common update(Common common);
    boolean deleteById(Long commonId);
     List<Common> getall();
}


