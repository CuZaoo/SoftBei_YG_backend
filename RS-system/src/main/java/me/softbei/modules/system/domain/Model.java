package me.softbei.modules.system.domain;

import io.swagger.models.auth.In;
import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("模型表")
@Entity
@Table(name = "model",schema="rs")
public class Model  implements Serializable {
 
    private static final long serialVersionUID = 638352801107065578L;
            
    /**
    * 模型表ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "model_id")
    @ApiModelProperty("模型表ID")
    private Long modelId;
                        
    /**
    * 模型名称
    */                                
    @Basic
    @Column(name= "name")
    @ApiModelProperty("模型名称")
    private String name;
                        
    /**
    * 模型训练次数
    */                                
    @Basic
    @Column(name= "time")
    @ApiModelProperty("模型训练次数")
    private Long time;
                        
    /**
    * 模型年份
    */                                
    @Basic
    @Column(name= "year")
    @ApiModelProperty("模型年份")
    private String year;
                        
    /**
    * 模型对应论文地址
    */                                
    @Basic
    @Column(name= "url")
    @ApiModelProperty("模型对应论文地址")
    private String url;
                        
    /**
    * 模型指标,使用逗号分隔
    */                                
    @Basic
    @Column(name= "miou")
    @ApiModelProperty("模型指标,使用逗号分隔")
    private Float miou;

    /**
     * 模型指标,使用逗号分隔
     */
    @Basic
    @Column(name= "f1")
    @ApiModelProperty("模型指标,使用逗号分隔")
    private Float f1;

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
