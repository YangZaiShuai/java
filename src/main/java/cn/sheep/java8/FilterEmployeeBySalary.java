package cn.sheep.java8;

/**
 * @auther create by jhy
 * @date 2018/5/2 3:49
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee o) {
        return o.getSalary()>=500;
    }
}
