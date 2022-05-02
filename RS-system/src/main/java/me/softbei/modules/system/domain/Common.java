package me.softbei.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import io.swagger.annotations.*;
import java.io.Serializable;
 import java.util.Date;
 
@Data
@ApiModel("公共表")
@Entity
@Table(name = "common",schema="rs")
public class Common  implements Serializable {
 
    private static final long serialVersionUID = 287575783429070300L;
            
    /**
    * 公共表ID
    */                              
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "common_id")
    @ApiModelProperty("公共表ID")
    private Long commonId;
                        
    /**
    * 功能名称
    */                                
    @Basic
    @Column(name= "name")
    @ApiModelProperty("功能名称")
    private String name;
                        
    /**
    * 功能描述
    */                                
    @Basic
    @Column(name= "description")
    @ApiModelProperty("功能描述")
    private String description;
                        
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
