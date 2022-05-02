package me.softbei.modules.system.service;

import me.softbei.modules.system.domain.Message;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Message)表服务接口
 *
 * @author !author
 * @since 2022-04-30 11:18:15
 */
public interface MessageService {
    Message queryById(Long messageId);
    Page<Message> queryAllByLimit(int offset, int limit);
    Message insert(Message message);
    Message update(Message message);
    boolean deleteById(Long messageId);
     List<Message> getall();
    Long getMessageSize();
    List<Object> getMessageSizeOf7Days();
    List<Message> getSomeMessage(Integer nums);

    Page<Message> getNewMessage(int page, int size);
}


