package com.zbz.boot.converter;

import com.zbz.boot.format.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ZbzMessageConverter implements HttpMessageConverter <Person>{


    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return  MediaType.parseMediaTypes("application/x-zbz");
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议数据的写出
        String data = person.getUserName()+";"+person.getAge()+";"+person.getBirth();


        //写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(Class clazz) {
        return HttpMessageConverter.super.getSupportedMediaTypes(clazz);
    }

    @Override
    public Person read(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }




}
