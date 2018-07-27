package cn.sheep.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**Lambda表达式基础语法:
 * 引入了新的操作符 "->"  箭头操作符或lambda操作符
 * 左侧:表达式的参数列表                        接口中,抽象方法的参数列表
 * 右侧:执行的功能,Lambda体  就是对接口的实现    接口中,对抽象方法的实现
 *      之前是用匿名内部类实现接口,现在就可以用lambda表达式了
 *
 * @auther create by jhy
 * @date 2018/5/2 15:41
 *
 * 语法格式一:无参数,无返回值
 *              ()->Sout("*****")
 * 语法格式二:有一个参数,无返回值
 *              (x)->Sout("x")
 * 语法格式三:有一个参数,无返回值 ,小括号可以省略
 *              x->Sout("x")
 *语法格式四:有多个参数,有返回值,多条语句
 *              (x,y) -> { }
 * 语法格式五:有多个参数,有返回值,一条语句
 *              return 和 大括号 都可以省略
 * lambda表达式的数据类型可以不写
 *
 * =========================================================
 * Lambda表达式 需要函数式接口的支持
 * 函数式接口:借口中只有一个抽象方法,就成为函数是接口
 * 可以使用注解@FunctionalInterface修饰  可以检查是否是函数式接口
 */
public class LambdaDemo2 {

    /**
     * 语法格式一:无参数,无返回值
     *            ()->Sout("*****")
     */
    @Test
    public void test1(){

        int num = 0;   //jdk1.7以前,必须是final(局部内部类使用了同级别的局部变量时,该变量必须是final)
                                                           // |
        //原来的格式 无参数 无返回值的接口                       |
        Runnable r = new Runnable() {                      // |
            @Override                                      // |
            public void run() {                            // |
                System.out.println("hello old"+ num);    //<---
            }
        };
        r.run();

        System.out.println("--------------------");

        Runnable r1 = ()-> System.out.println("hello lambda");
        r1.run();
    }

    /**
     *  * 语法格式二:有一个参数,无返回值
     *              (x)->Sout("x")
     */
    @Test
    public void test2(){
        //java8有一个接口consumer
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("有一个参数,无返回值");
    }

    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("-------");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(5,6));
    }

    @Test
    public void test5(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        System.out.println(com.compare(5,6));
    }


    /**
     * 需求:对一个数运算
     * 先搞一个函数式接口
     */
    @Test
    public void test6(){
        Integer integer = operation(100, (x) -> x * x);
        System.out.println(integer);
        Integer integer2 = operation(100, (x) -> x + 2);
        System.out.println(integer2);
    }

    public Integer operation(Integer num,MyFunction mf){
        return mf.getValue(num);
    }

}
