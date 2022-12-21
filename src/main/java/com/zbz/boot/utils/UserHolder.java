//package com.zbz.boot.utils;
//
//
//import com.zbz.boot.format.redis.bean.Myuser;
//
//
//public class UserHolder {
//    private static final ThreadLocal<Myuser> tl = new ThreadLocal<>();
//
//    public static void saveUser(Myuser user){
//        tl.set(user);
//    }
//
//    public static Myuser getUser(){
//        return tl.get();
//    }
//
//    public static void removeUser(){
//        tl.remove();
//    }
//}
