package me.softbei.modules.system.service.dto;

import lombok.Getter;
import lombok.Setter;
import me.softbei.base.BaseDTO;

import java.io.Serializable;

@Getter
@Setter
public class MessageDto extends BaseDTO implements Serializable {
    private Long messageId;
    private String senderName;
    private String messageContent;
}
