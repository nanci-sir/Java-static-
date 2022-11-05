# Java-static-
Java static静态关键字

### 1. static是什么

static是静态的意思，可以用来修饰成员变量、成员方法。

static修饰成员变量之后称为静态成员变量（类变量），修饰方法之后称为静态方法（类方法）。

static修饰后的成员变量，可以被类的所有对象共享（访问、修改)。

1. static是什么 ？

**静态的意思，可以修饰成员变量、成员方法**

2.static修饰的成员变量是什么？ 有什么特点？

静态成员变量（有static修饰，属于类、加载一次，内存中只有一份），访问格式

实例成员变量（无static修饰，属于对象），访问格式：

3.两种成员变量各自在什么情况下定义？

**静态成员变量：表示在线人数等需要被类的所有对象共享的信息时。**

实例成员变量：属于每个对象，且每个对象的该信息不同时 如：name,age,money

```java
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
```

### 2. static修饰成员方法的基本用法

**成员方法的分类：**

静态成员方法（有static修饰，归属于类），建议用类名访问，也可以用对象访问。

实例成员方法（无static修饰，归属于对象），只能用对象触发访问。

表示对象自己的行为的，且方法中需要访问实例成员的，则该方法必须申明成实例方法。

如果该方法是以执行一个共用功能为目的，则可以申明成静态方法。

1.成员方法的分类和访问分别是什么样的？

   静态成员方法（有static修饰，属于类和对象共享）访问格式：

​    对象静态成员方法。（不推荐）

  实例成员方法（无static修饰，属于对象）的访问格式：

​    对象实例成员方法。

2.每种成员方法的使用场景是怎么样的？

 表示对象自己的行为的，且方法中需要直接访问实例成员，则该方法必须申明成实例方法。

 如果该方法是以执行一个通用功能为目的，或者需要方便访问，则可以申明成静态方法。

实例方法必须构建对象才能访问，静态方法可以被类和对象直接访问

```java
package Student;

public class Student {
    //实例成员变量，属于对象
    private  String name;

    //静态成员变量方法，有static修饰，用类和对象都能被访问
    public  static int getMax(int age1, int age2){
        return age1 > age2 ? age1 :age2;

    }
    //实例成员变量属于对象，只能被对象触发访问
    public void study(){
        System.out.println(name + "在好好学习天天向上！");

    }

    public static void main(String[] args) {
        //1.静态成员方法
        System.out.println(Student.getMax(10, 3));//10
        System.out.println(getMax(10, 3));//10
        //2.对象，实例方法 构建对象访问
        Student s = new Student();
        s.name = "张三";
        s.study();//张三在好好学习天天向上！
        //3.对象也可以访问静态方法（不推荐）
        System.out.println(s.getMax(13,2));//13

    }

}
```

static访问注意事项：
静态方法只能访问静态的成员，不可以直接访问实例成员。
实例方法可以访问静态的成员，也可以访问实例成员。因为实例方法构造对象访问
静态方法中是不可以出现this关键字的，this代表当前对象，

```java
package Student;

public class test {
    //静态成员
    public  static int onLineNumber = 10;
    public static  void  test2(){
        System.out.println("===test2===");
    }
    //实例成员
    private String name;
    public  void run(){
        System.out.println(name + "跑的快");
    }
    //ststic访问相关语法
    //3.静态方法中是不可以出现this关键字的，
    public static void test3(){
        System.out.println(name);

    }

    //2.实例方法可以访问静态的成员，也可以访问实例成员。
    public  void go(){
        System.out.println(test.onLineNumber);
        System.out.println(onLineNumber);
        test();
        System.out.println(name);
        run();//对象触发
        //this可以出现在实例
        System.out.println(this.name);
        System.out.println(this);
    }

    public  static  void  test(){
        //1. 静态方法只能访问静态的成员，不可以直接访问实例成员。
        System.out.println(test.onLineNumber);
        System.out.println(onLineNumber);
        test();
        // System.out.println(name);不可以直接访问实例成员
    }
    public static void main(String[] args) {
    }
}
```

## 3. static应用知识：工具类

工具类是什么？
类中都是一些静态方法，每个方法都是以完成一个共用的功能为目的，这个类用来给系统开发人员共同使用的。

工具类定义时的其他要求：
由于工具里面都是静态方法，直接用类名即可访问，因此，工具类无需创建对象，建议将工具类的构造器进行私有

工具类是什么，有什么好处？
内部都是一些静态方法，每个方法完成一个功能
一次编写，处处可用，提高代码的重用性。

工具类有什么要求？
建议工具类的构造器私有化处理。
工具类不需要创建对象。

```java
package Student;

import java.util.Random;

public class Util {
    //由于工具类无需创造对象，所以把其构造器私有化会显得很专业
    private Util(){

    }
    //工具类
    public static String crezteVerifyCode(int n) {
        //静态成员方法
        String code = "";
        String data = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            //获取随机索引，得到几个字符
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }
        return code;
    }
    }
```

```java
package Student;

import java.util.Random;

public class check {
    public static void main(String[] args) {
        System.out.println(Util.crezteVerifyCode(6));
    }
}
```

定义数组工具类

需求：在实际开发中，经常会遇到一些数组使用的工具类。请按照如下要求编写一个数组的工具类：ArraysUtils
：我们知道数组对象直接输出的时候是输出对象的地址的，而项目中很多地方都需要返回数组的内容，请在ArraysUtils中提供一个工具类方法toString，用于返回整数数组的内容，返回的字符串格式如：[10, 20, 50, 34, 100]（只考虑整数数组，且只考虑一维数组）
：经常需要统计平均值，平均值为去掉最低分和最高分后的分值，请提供这样一个工具方法getAerage，用于返回平均分。（只考虑浮点型数组，且只考虑一维数组）
：定义一个测试类TestDemo，调用该工具类的工具方法，并返回结果。

```java
package Student;
//完成数组工具类的设计

public class TestDemo {
    private TestDemo(){

    }
    //定义静态方法
    public static String toString(int[] arr){
        //1.一些校验
        if(arr == null){
            return  null;

        }
        //2.返回内容
        String result = "[";
        for (int i = 0; i <arr.length ; i++) {
            result +=(i == arr.length - 1? arr[i] : arr[i] +"," );


        }
        result +="]";
        return  result;

    }
}
```

```java
package Student;

public class test2 {
    public static void main(String[] args) {
        int[] arr =null;
        int[] arr1 = {};
        int[] arr2 ={11,23,45,67};

        System.out.println(TestDemo.toString(arr));
        System.out.println(TestDemo.toString(arr1));
        System.out.println(TestDemo.toString(arr2));
    }
}
```
