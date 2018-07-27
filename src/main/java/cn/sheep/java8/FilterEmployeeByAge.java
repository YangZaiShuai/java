package cn.sheep.java8;

/**
 * @auther create by jhy
 * @date 2018/5/2 3:40
 */
public class FilterEmployeeByAge implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee t) {
        return t.getAge() >=35;
    }
}
