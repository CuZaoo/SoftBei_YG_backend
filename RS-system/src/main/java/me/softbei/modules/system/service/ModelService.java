package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.Model;
import java.util.List;

import org.springframework.data.domain.Page;
/**
 * (Model)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:25:58
 */
public interface ModelService {
    Model queryById(Long modelId);
    Page<Model> queryAllByLimit(int offset, int limit);
    Model insert(Model model);
    Model update(Model model);
    boolean deleteById(Long modelId);
     List<Model> getall();
     Page<Model> getModelByPage(int page, int size);
}


