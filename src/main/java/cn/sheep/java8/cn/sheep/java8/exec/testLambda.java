package cn.sheep.java8.cn.sheep.java8.exec;

import cn.sheep.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @auther create by jhy
 * @date 2018/5/2 16:17
 */
public class testLambda {
    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan",18,999),
            new Employee("lisi",28,888),
            new Employee("laosan",18,888),
            new Employee("wangwu",38,777)
    );
    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        employees.forEach(System.out::println);
    }
}
