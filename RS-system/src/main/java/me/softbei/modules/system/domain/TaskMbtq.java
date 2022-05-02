package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("目标提取表")
@Entity
@Table(name = "task_mbtq",schema="rs")
public class TaskMbtq  implements Serializable {
 
    private static final long serialVersionUID = -85470341916888336L;
            
    /**
    * 目标提取表ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "mbtq_id")
    @ApiModelProperty("目标提取表ID")
    private Long mbtqId;
                        
    /**
    * 目标提取原图url地址
    */                                
    @Basic
    @Column(name= "img_url")
    @ApiModelProperty("目标提取原图url地址")
    private String imgUrl;
                        
    /**
    * 目标提取原图真实路径
    */                                
    @Basic
    @Column(name= "img_path")
    @ApiModelProperty("目标提取原图真实路径")
    private String imgPath;
                        
    /**
    * 目标提取处理图url地址
    */                                
    @Basic
    @Column(name= "img_result_url")
    @ApiModelProperty("目标提取处理图url地址")
    private String imgResultUrl;
                        
    /**
    * 目标提取处理图真实路径
    */                                
    @Basic
    @Column(name= "img_result_path")
    @ApiModelProperty("目标提取处理图真实路径")
    private String imgResultPath;
                        
    /**
    * 对应任务ID
    */                                
    @Basic
    @Column(name= "task_id")
    @ApiModelProperty("对应任务ID")
    private Long taskId;
                        
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
