package com.zbz.boot.format.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbz.boot.format.bean.Message;
import com.zbz.boot.format.mapper.MessageMapper;
import com.zbz.boot.format.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp extends ServiceImpl<MessageMapper,Message> implements MessageService {
//    @Autowired
//    MessageMapper messageMapper;
//    @Override
//    public List<Message> getMessages(String type){
//        return messageMapper.getMessages(type);
//    }
//    public Integer insertMessages(Message message){
//        return messageMapper.insertMessages(message);
//    }
//
//    public Integer updateMessages(Message message) {
//        return messageMapper.updateMessages(message);
//    }
//
//    public Integer deleteMessages(Integer id) {
//        return  messageMapper.deleteMessages(id);
//    }
}
