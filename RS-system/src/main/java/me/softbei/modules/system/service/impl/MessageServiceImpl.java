package me.softbei.modules.system.service.impl;

import me.softbei.modules.system.domain.Message;
import me.softbei.modules.system.domain.vo.Message7DayVo;
import me.softbei.modules.system.repository.MessageRepository;
import me.softbei.modules.system.service.MessageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Message7DayVo getMessageSizeOf7Days() {
        List<Object[]> list = this.messageRepository.getMessageSizeOf7Days();
//        List<Message7DayVo> voList = EntityUtils.castEntity(list, Message7DayVo.class, new Message7DayVo());
        return this.convertToMessage7DayVo(list);
    }

    private Message7DayVo convertToMessage7DayVo(List<Object[]> list) {
        List<String> days = new ArrayList<>();
        List<BigInteger> times = new ArrayList<>();
        final SimpleDateFormat sdft = new SimpleDateFormat("MM-dd");
        Collections.sort(list, new Comparator<Object[]>() {
            /**
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Object[] o1, Object[] o2) {
                try {
                    Date date1 = sdft.parse(o1[0].toString());
                    Date date2 = sdft.parse(o2[0].toString());
                    if (date1.getTime() <= date2.getTime()) {
                        return -1;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });
        list.forEach(val -> {
            days.add((String) val[0]);
            times.add((BigInteger) val[1]);
        });

        return new Message7DayVo(days, times);
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
     * @param message
     */
    @Override
    public void saveMessage(Message message) {

        this.messageRepository.save(message);
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
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(page - 1, size,sort);
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


