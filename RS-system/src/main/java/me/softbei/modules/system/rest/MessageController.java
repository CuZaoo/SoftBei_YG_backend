package me.softbei.modules.system.rest;

import com.alibaba.fastjson.JSONArray;
import me.softbei.annotation.rest.AnonymousGetMapping;
import me.softbei.annotation.rest.AnonymousPostMapping;
import me.softbei.exception.BadRequestException;
import me.softbei.modules.system.domain.Message;
import me.softbei.modules.system.domain.vo.Message7DayVo;
import me.softbei.modules.system.domain.vo.MessageVo;
import me.softbei.modules.system.service.MessageService;
import me.softbei.utils.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

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
    @AnonymousGetMapping("getMessageSize")
    public ResponseEntity<Object> getMessageSize(){
        return new ResponseEntity<>(this.messageService.getMessageSize(),HttpStatus.OK);
    }

    @ApiOperation("获取7日留言数量")
    @AnonymousGetMapping("getMessageOf7Day")
    public ResponseEntity<Object> getMessageOf7Day(){
        Message7DayVo messageSizeOf7Days = this.messageService.getMessageSizeOf7Days();
        return new ResponseEntity<>(messageSizeOf7Days,HttpStatus.OK);
    }
    @ApiOperation("保存留言")
    @AnonymousPostMapping("saveMessage")
    public ResponseEntity<Object> saveMessage(@RequestBody Message message){
        if (StringUtils.isBlank(message.getMessageContent())){
            throw new BadRequestException("留言不可为空");
        }
//        这里前端可以通过post传递一个假的senderName，使得游客可以冒充某个用户发言，后期开发应该加上一个判断用户是否登录的代码
        this.messageService.saveMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation("随机获取10条留言")
    @AnonymousGetMapping("getSomeMessage")
    public ResponseEntity<Object> getSomeMessage(){
        int nums = 10;
        return new ResponseEntity<>(this.messageService.getSomeMessage(nums),HttpStatus.OK);
    }

    @ApiOperation("获取最新的10条留言")
    @AnonymousGetMapping("getNewMessage")
    public ResponseEntity<Object> getNewMessage(@RequestParam(required = true) Integer page,@RequestParam(required = true) Integer size, HttpServletRequest request){
        Page<Message> newMessage = this.messageService.getNewMessage(page, size);
        return new ResponseEntity<>(newMessage,HttpStatus.OK);
    }


    @AnonymousGetMapping("getPsv")
    public MessageVo getPsv() {
        Socket socket = null;
        StringBuilder sb =null;
        MessageVo vo = null;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            String host=addr.getHostName();
            //String ip=addr.getHostAddress().toString(); //获取本机ip
            //log.info("调用远程接口:host=>"+ip+",port=>"+12345);

            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            socket = new Socket(host,12345);

            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print( "star");
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");

            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            String tmp = null;
            sb = new StringBuilder();
            // 读取内容
            while((tmp=br.readLine())!=null)
                sb.append(tmp).append('\n');
             vo= JSONArray.parseObject(sb.toString(), MessageVo.class);
            System.out.println(vo.getBase64code());
            System.out.println(vo.getName());
//            System.out.println(sb);
            //将算法返回的结果再次返回给Vue前端
//            JSONArray res = JSON.parseArray(sb.toString());
//            System.out.println(res);
            // 解析结果

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(socket!=null) socket.close();} catch (IOException e) {}
            System.out.println("远程接口调用结束.");
            return vo;
        }
    }
}


