package com.company;

public class StaticFildDemo1 {
    public static void main(String[] args) {
        System.out.println(User.onlineNumber);
        User u = new User();
        u.onlineNumber++;
        System.out.println(u.onlineNumber);
    }
}
