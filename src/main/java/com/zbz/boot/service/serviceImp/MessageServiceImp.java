package com.zbz.boot.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbz.boot.bean.Message;
import com.zbz.boot.mapper.MessageMapper;
import com.zbz.boot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
