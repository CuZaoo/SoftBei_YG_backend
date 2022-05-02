package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("地物检测表")
@Entity
@Table(name = "taks_dwjc",schema="rs")
public class TaksDwjc  implements Serializable {
 
    private static final long serialVersionUID = 698896705949842308L;
            
    /**
    * 地物检测ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "dwjc_id")
    @ApiModelProperty("地物检测ID")
    private Long dwjcId;
                        
    /**
    * 原图 url
    */                                
    @Basic
    @Column(name= "img_url")
    @ApiModelProperty("原图 url")
    private String imgUrl;
                        
    /**
    * 原图path
    */                                
    @Basic
    @Column(name= "img_path")
    @ApiModelProperty("原图path")
    private String imgPath;
                        
    /**
    * 处理图url
    */                                
    @Basic
    @Column(name= "img_result_url")
    @ApiModelProperty("处理图url")
    private String imgResultUrl;
                        
    /**
    * 处理图path
    */                                
    @Basic
    @Column(name= "img_result_path")
    @ApiModelProperty("处理图path")
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
