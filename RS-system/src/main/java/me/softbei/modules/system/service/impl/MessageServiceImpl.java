package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.Message;
import me.softbei.modules.system.repository.MessageRepository;
import me.softbei.modules.system.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Message)表服务实现类
 *
 * @author Wyl
 * @since 2022-04-30 11:19:18
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageRepository messageRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long getMessageSize() {
        return this.messageRepository.count();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Object> getMessageSizeOf7Days() {
        return this.messageRepository.getMessageSizeOf7Days();
    }

    /**
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Message> getSomeMessage(Integer nums) {
        return this.messageRepository.getSomeMessage(nums);
    }

    /**
     * @param page :当前页,size:分页大小
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<Message> getNewMessage(int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1,size);
        return this.messageRepository.findAll(pageable);
    }

    @Override
    public Message queryById(Long messageId) {
        return this.messageRepository.getOne(messageId);
    }

    @Override
    public List<Message> getall() {
        return this.messageRepository.findAll();

    }

    @Override
    public Page<Message> queryAllByLimit(int offset, int limit) {
        return this.messageRepository.findAll(PageRequest.of((offset - 1)
                * limit, limit));
    }

    @Override
    public Message insert(Message message) {

        return this.messageRepository.save(message);
    }


    @Override
    public Message update(Message message) {

        return this.messageRepository.save(message);
    }


    @Override
    public boolean deleteById(Long messageId) {

        try {
            this.messageRepository.deleteById(messageId);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
}


