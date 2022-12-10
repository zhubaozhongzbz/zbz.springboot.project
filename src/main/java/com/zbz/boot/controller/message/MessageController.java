package com.zbz.boot.controller.message;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbz.boot.bean.Message;
import com.zbz.boot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    MessageService  messageService;
    @ResponseBody
    @PostMapping("/insertMessages")
    public boolean insertMessages(@RequestBody Map map){
        Message message=new Message();
        message.setTitle((String) map.get("title"));
        message.setLink((String) map.get("link"));
        message.setType((String) map.get("type"));
       return  messageService.save(message);
    //  return  messageService.insertMessages(message);
    }

    @ResponseBody
    @GetMapping("/getMessages")
    public Page getMessages(@RequestParam("type")String type,
            @RequestParam(value="pn" ,defaultValue ="1" )Integer pn){
        Map<String, Object> map = new HashMap<>();
        map.put("type",type);
    //分页
        QueryWrapper<Message> qwrapper=new QueryWrapper<>();
        qwrapper.eq("type",type);
        Page<Message> messagePage = new Page<Message>(pn, 7);
        Page page = messageService.page(messagePage, qwrapper);

      //  return  messageService.listByMap(map);
      //  return  messageService.getMessages(type);
        return page;

    }
    @ResponseBody
    @PostMapping("/updateMessages")
    public boolean updateMessages(@RequestBody Message message){
        return  messageService.saveOrUpdate(message);
       // return messageService.updateMessages(message);
    }
    @GetMapping("/deleteMessages")
    @ResponseBody
    public boolean deleteMessages(@RequestParam Integer id){
      return   messageService.removeById(id);
       // return messageService.deleteMessages(id);
    }


}
