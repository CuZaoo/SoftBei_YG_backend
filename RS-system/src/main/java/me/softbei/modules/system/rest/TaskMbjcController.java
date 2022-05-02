package me.softbei.modules.system.rest;

import me.softbei.modules.system.domain.TaskMbjc;
import me.softbei.modules.system.service.TaskMbjcService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * (TaskMbjc)表控制层
 *
 * @author Wyl
 * @since 2022-04-30 11:45:32
 */
@Api(tags = "接口")
@RestController
@RequestMapping("taskMbjc")
public class TaskMbjcController {
    /**
     * 服务对象
     */
    @Resource
    private TaskMbjcService taskMbjcService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数")
    @GetMapping("selectOne")
    @ApiImplicitParam(name = "id", value = "主键ID")
    public ResponseEntity<Object> selectOne(Long id) {
        return new ResponseEntity<>(this.taskMbjcService.queryById(id),HttpStatus.OK);
    }

}


