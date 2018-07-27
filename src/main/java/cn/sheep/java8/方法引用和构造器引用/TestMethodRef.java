package cn.sheep.java8.方法引用和构造器引用;

import cn.sheep.java8.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @auther create by jhy
 * @date 2018/5/20 23:26
 *
 * 方法引用:若Lamnda体中的内容已经实现了,就可以使用"方法引用"
 *      (方法引用是Lambda表达式的另一种表现形式)
 *
 *    三种语法格式
 *    对象::实例方法名
 *    类::静态方法名
 *    类::实例方法名
 */
public class TestMethodRef {

    /**
     * 第一种格式
     */
    @Test
    public void test1(){

        PrintStream ps1 = System.out;
        Consumer<String> con = (x)-> ps1.println(x);
        //在这里
        // Lambda体中的
        // println方法已经实现了,可以使用方法引用
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;

        Consumer<String> con3 = System.out::println;
        //前提
        //在这里抽象方法的参数和返回值类型  Consumer
        // 必须和
        // 我当前要调用的方法的参数和返回值保持一致 println
        con3.accept("qweasd");
    }

    @Test
    public void test2(){

        Employee emp = new Employee();
        emp.setAge(12);
        emp.setName("qwe");
        Supplier<String> sup = ()->emp.getName();

        String str = sup.get();
        System.out.println(str);

        //同样,这里的getName方法也实现了
        Supplier<String> sup1 = emp::getName;
        String s = sup1.get();
        System.out.println(s);
    }

}
