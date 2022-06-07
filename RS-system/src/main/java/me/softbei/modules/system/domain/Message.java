package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("用户留言")
@Entity
@Table(name = "message",schema="rs")
public class Message  implements Serializable {
 
    private static final long serialVersionUID = -87561786911143320L;
            
    /**
    * 留言表ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "message_id")
    @ApiModelProperty("留言表ID")
    private Long messageId;
                        
    /**
    * 发送人名称
    */                                
    @Basic
    @Column(name= "sender_name")
    @ApiModelProperty("发送人名称")
    private String senderName;
                        
    /**
    * 发送内容
    */                                
    @Basic
    @NotBlank
    @Column(name= "message_content")
    @ApiModelProperty("发送内容")
    private String messageContent;
                        
    /**
    * 创建时间
    */                                
    @Basic
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;
                        
    /**
    * 更新时间
    */                                
    @Basic

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;
             
}
