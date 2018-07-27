package cn.sheep.java8;

/**
 * @auther create by jhy
 * @date 2018/5/2 3:39
 */

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);

}
