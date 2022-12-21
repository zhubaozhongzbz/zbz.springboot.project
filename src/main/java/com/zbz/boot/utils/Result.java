package com.zbz.boot.utils;


import com.zbz.boot.format.fileUbload.RestApiResponse;

/**
 * @ProjectName RestApiResponse
 * @author Administrator
 * @version 1.0.0
 * @Description 附件分片上传
 * @createTime 2022/4/13 0013 15:59
 */
final  public class Result<T> {
    private Result() {}
    private static  Result result=null;
    private synchronized static<T> Result<T> getInstance(){
        if(result==null){
            result=new  Result<T>();
        }

        return result;
    }
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应数据
     */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        getInstance().success = true;
        getInstance().data = data;
        return result;
    }

    public static <T> Result<T> success() {

        getInstance().success = true;
        return result;
    }

    public static <T> Result<T> error(T data) {

        getInstance().success = false;
        getInstance().data = data;
        return result;
    }

    public static <T> Result<T> flag(boolean data) {
        getInstance().success = data;
        return result;
    }

}