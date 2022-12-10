package com.zbz.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbz.boot.bean.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    public List<Message> getMessages(String type);

    public Integer insertMessages(Message message);

    Integer updateMessages(Message message);

    Integer deleteMessages(Integer id);


}
