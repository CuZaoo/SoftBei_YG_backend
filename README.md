<h1 style="text-align: center">遥感图片处理系统</h1>


#### 项目简介
一个基于 Spring Boot 2.1.0 、 Spring Boot Jpa、 JWT、Spring Security、Redis、Vue的前后端分离的后台管理系统

基于ELAdmin： https://github.com/elunez/ELAdmin

#### 项目源码

|     |   后端源码  | 前端源码                                          |
|---  |--- |-----------------------------------------------|
|  github   |  https://github.com/CuZaoo/SoftBei_YG_backend   | https://github.com/CuZaoo/SoftBei_YG_frontend |



####  系统功能
- 目标提取：根据用户提供的图片，选择合适的模型对图片中的给定目标进行提取
- 变化检测：根据用户提供的变化前后图片，选择合适的模型对两张图片中变换的位置进行标注
- 目标检测：根据用户提供的图片，选择合适的模型对图片中给定的目标做检测处理
- 地物检测：根据用户提供的图片，选择合适的模型对图片中的道路等信息做检测


#### 项目结构
项目采用按功能分模块的开发方式，结构如下

- `RS-common` 为系统的公共模块，各种工具类，公共配置存在该模块

- `RS-system` 为系统核心模块也是项目入口模块，也是最终需要打包部署的模块

- `RS-logging` 为系统的日志模块，其他模块如果需要记录日志需要引入该模块

- `RS-tools` 为第三方工具模块，包含：图床、邮件、云存储、本地存储、支付宝


#### 详细结构

```
- RS-common 公共模块
    - annotation 为系统自定义注解
    - aspect 自定义注解的切面
    - base 提供了Entity、DTO基类和mapstruct的通用mapper
    - config 自定义权限实现、redis配置、swagger配置、Rsa配置等
    - exception 项目统一异常的处理
    - utils 系统通用工具类
- RS-system 系统核心模块（系统启动入口）
	- config 配置跨域与静态资源，与数据权限
	    - thread 线程池相关
	- modules 系统相关模块(登录授权、图片处理等)
- RS-logging 系统日志模块
- RS-tools 系统第三方工具模块
```
