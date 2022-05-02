package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("")
@Entity
@Table(name = "task_group",schema="rs")
public class TaskGroup  implements Serializable {
 
    private static final long serialVersionUID = 126260952395702206L;
            
    /**
    * 任务组ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "group_id")
    @ApiModelProperty("任务组ID")
    private Long groupId;
                        
    /**
    * 任务组所属用户
    */                                
    @Basic
    @Column(name= "user_id")
    @ApiModelProperty("任务组所属用户")
    private Long userId;
             
}
