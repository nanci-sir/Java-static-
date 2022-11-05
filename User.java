package com.company;

public class User {
    //静态成员变量
        public static int onlineNumber = 161;
        //实例成员变量
    private String name;
    private  int  age;

    public static void main(String[] args) {

    //1.类名，静态成员变量
        System.out.println(User.onlineNumber);
        //2,对象名，实例成员变量
        User u = new User();
        u.name  ="张三";
        u.age = 21;
        System.out.println(u.name);
        System.out.println(u.age);
        u.onlineNumber++;
        System.out.println(u.onlineNumber);
        System.out.println(User.onlineNumber);//推荐方式
    }
}
