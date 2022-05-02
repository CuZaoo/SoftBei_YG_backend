package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("变化检测表")
@Entity
@Table(name = "task_bhjc",schema="rs")
public class TaskBhjc  implements Serializable {
 
    private static final long serialVersionUID = 398639336758216999L;
            
    /**
    * 变化检测ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "bhjc_id")
    @ApiModelProperty("变化检测ID")
    private Long bhjcId;
                        
    /**
    * 图片1 url
    */                                
    @Basic
    @Column(name= "img1_url")
    @ApiModelProperty("图片1 url")
    private String img1Url;
                        
    /**
    * 图片1 path
    */                                
    @Basic
    @Column(name= "img1_path")
    @ApiModelProperty("图片1 path")
    private String img1Path;
                        
    /**
    * 图片2 url
    */                                
    @Basic
    @Column(name= "img2_url")
    @ApiModelProperty("图片2 url")
    private String img2Url;
                        
    /**
    * 图片2 path
    */                                
    @Basic
    @Column(name= "img2_path")
    @ApiModelProperty("图片2 path")
    private String img2Path;
                        
    /**
    * 结果 url
    */                                
    @Basic
    @Column(name= "img_result_url")
    @ApiModelProperty("结果 url")
    private String imgResultUrl;
                        
    /**
    * 结果 path
    */                                
    @Basic
    @Column(name= "img_result_path")
    @ApiModelProperty("结果 path")
    private String imgResultPath;
                        
    /**
    * 任务id
    */                                
    @Basic
    @Column(name= "task_id")
    @ApiModelProperty("任务id")
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
