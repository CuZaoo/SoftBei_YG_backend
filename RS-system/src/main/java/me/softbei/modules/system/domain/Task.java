package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("任务表")
@Entity
@Table(name = "task",schema="rs")
public class Task  implements Serializable {
 
    private static final long serialVersionUID = -55402170372098025L;
            
    /**
    * 任务表ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "task_id")
    @ApiModelProperty("任务表ID")
    private Long taskId;
                        
    /**
    * 对应模型ID
    */                                
    @Basic
    @Column(name= "model_id")
    @ApiModelProperty("对应模型ID")
    private Long modelId;
                        
    /**
    * 所属任务组ID
    */                                
    @Basic
    @Column(name= "task_group_id")
    @ApiModelProperty("所属任务组ID")
    private Long taskGroupId;
                        
    /**
    * 创建时间
    */                                
    @Basic
    @Column(name= "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;
                        
    /**
    * 更新时间
    */                                
    @Basic
    @Column(name= "update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime;
             
}
