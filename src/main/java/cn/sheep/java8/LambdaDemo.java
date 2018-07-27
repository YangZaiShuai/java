package cn.sheep.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @auther create by jhy
 * @date 2018/5/2 3:02
 */
public class LambdaDemo {
        /*
        Lambda表达式
        lambda是一个匿名函数,可以吧lambda表达式理解为一个可以传递的代码
        更简洁灵活
        * */

        //原来的匿名内部类
        /*实现抽象方法
        * 这就可以把匿名内部类的实例 作为参数传递
        * */
        @Test
        public void test1(){
                Comparator<Integer> comparator = new Comparator<Integer>() {
                        public int compare(Integer o1, Integer o2) {
                                return Integer.compare(o1,o2);
                        }
                };

                TreeSet<Integer> ts = new TreeSet<>(comparator);
        }

        //lambda表达式可以简介开发
        @Test
        public void test2(){
                Comparator<Integer> com = (x,y)->Integer.compare(x,y);
                TreeSet<Integer> ts = new TreeSet<Integer>(com);
        }

        //需求,员工年龄大于35的人的信息
        List<Employee> employees = Arrays.asList(
                new Employee("zhangsan",18,999),
                new Employee("lisi",28,888),
                new Employee("wangwu",38,777)
        );

        public List<Employee> filterEmployees(List<Employee> list){
                List<Employee> emps = new ArrayList<>();
                for(Employee emp : list){
                        if (emp.getAge()>=35){
                                emps.add(emp);
                        }
                }
                return emps;
        }
        @Test
        public void test3(){
                List<Employee> employees = filterEmployees(this.employees);
                for(Employee emp : employees){
                        System.out.println(emp);
                }
        }

        //获取工资大于5000员工信息
        //...............很多需求  又得里一个方法     区别很小
        public List<Employee> filterEmployees2(List<Employee> list){
                List<Employee> emps = new ArrayList<>();
                for(Employee emp : list){
                        if (emp.getSalary()>=5000){
                                emps.add(emp);
                        }
                }
                return emps;
        }

        //优化方式一  采用设计模式  策略设计模式
        /*
        * 先来一个接口,再定义不同的实现类
        * */
        public List<Employee> filterEmployees3(List<Employee> list,MyPredicate<Employee> mp){
                List<Employee> emps = new ArrayList<>();
                for(Employee emp : list){
                        if (mp.test(emp)){
                                emps.add(emp);
                        }
                }
                return emps;
        }
        @Test
        public void test4(){
                List<Employee> list = filterEmployees3(this.employees, new FilterEmployeeByAge());
                for (Employee emp : list){
                        System.out.println(emp);
                }
                System.out.println("==========================================================");
                List<Employee> list2 = filterEmployees3(this.employees, new FilterEmployeeBySalary());
                for (Employee emp : list2){
                        System.out.println(emp);
                }
        }


        //优化 方式二  匿名内部类 实现接口
        @Test
        public void test5(){
                List<Employee> list = filterEmployees3(employees, new MyPredicate<Employee>() {
                        @Override
                        public boolean test(Employee t) {
                                return t.getSalary() <= 900;
                        }
                });
                for (Employee employee : list){
                        System.out.println(employee);
                }
        }

        //优化三  Lambda表达式
        @Test
        public void test6(){
                List<Employee> list = filterEmployees3(employees, e -> e.getSalary() <= 800);

                list.forEach(System.out::println);
        }

        //优化四  只有一个实体类
        @Test
        public void test7(){
                employees.stream().filter(e -> e.getSalary() > 800).forEach(System.out::println);
                employees.stream()
                        .map(Employee::getName)
                        .forEach(System.out::println);
        }


}
