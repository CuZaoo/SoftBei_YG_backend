package me.softbei.modules.system.rest;

import io.swagger.models.auth.In;
import me.softbei.modules.system.domain.Message;
import me.softbei.modules.system.service.MessageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * (Message)表控制层
 *
 * @author Wyl
 * @since 2022-04-30 11:45:32
 */
@Api(tags = "接口")
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;

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
        return new ResponseEntity<>(this.messageService.queryById(id),HttpStatus.OK);
    }
    @ApiOperation("获取留言数量")
    @GetMapping("getMessageSize")
    public ResponseEntity<Object> getMessageSize(){

        return new ResponseEntity<>(this.messageService.getMessageSize(),HttpStatus.OK);
    }

    @ApiOperation("获取7日留言数量")
    @GetMapping("getMessageOf7Day")
    public ResponseEntity<Object> getMessageOf7Day(){
        List<Object> messageSizeOf7Days = this.messageService.getMessageSizeOf7Days();
        return new ResponseEntity<>(messageSizeOf7Days,HttpStatus.OK);
    }
    @ApiOperation("保存留言")
    @PostMapping("saveMessage")
    public ResponseEntity<Object> saveMessage(@Validated @RequestBody Message message){
        this.messageService.insert(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @ApiOperation("随机获取10条留言")
    @GetMapping("getSomeMessage")
    public ResponseEntity<Object> getSomeMessage(){
        int nums = 10;
        return new ResponseEntity<>(this.messageService.getSomeMessage(nums),HttpStatus.OK);
    }

    @ApiOperation("获取最新的10条留言")
    @GetMapping("getNewMessage")
    public ResponseEntity<Object> getNewMessage(Integer page,Integer size){
        return new ResponseEntity<>(this.messageService.getNewMessage(page,size),HttpStatus.OK);
    }
}


