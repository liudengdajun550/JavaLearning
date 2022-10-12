package streamandlambad8;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.10.08
 **/
public class Main {
//https://blog.csdn.net/weixin_51435009/article/details/123707616?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-123707616-blog-108448810.t0_edu_mix&spm=1001.2101.3001.4242.1&utm_relevant_index=3
    public static void main(String[] args) {
        /*
        JDK9的新特性:      
        List接口,Set接口,Map接口:里边增加了一个静态的方法of,可以给集合一次性添加多个元素        
        static List of​(E... elements)      
        使用前提:     
        当集合中存储的元素的个数已经确定了,不在改变时使用    
        注意:     
        1.of方法只适用于List接口,Set接口,Map接口,不适用于接接口的实现类     
        2.of方法的返回值是一个不能改变的集合,集合不能再使用add,put方法添加元素,会抛出异常      
        3.Set接口和Map接口在调用of方法的时候,不能有重复的元素,否则会抛出异常
        https://blog.csdn.net/weixin_36152824/article/details/114771327
        https://www.jb51.net/article/221934.htm
*/

        List<Employee> list = Arrays.asList(
                new Employee("bcd", 27, 9500.0),
                new Employee("aaa", 29, 10000.0),
                new Employee("abc", 28, 8000.0),
                new Employee("bc", 28, 9000.0),
                new Employee("bc", 28, 9000.0),
                new Employee("cde", 30, 12000.0)
        );
        //判断每一个员工是否都>=20岁
        System.out.println(list.stream().distinct().allMatch((s) -> s.getSalary() >= 20));
        //查找薪资最低的员工
        //Optional<T>存储一个数据的容器类型->jdk8新增的容器类型-->帮助避免出现空指针异常
        System.out.println(list.stream().sorted((d1, d2) -> (int) (d1.getSalary() - d2.getSalary())).findFirst().get()); //sorted中两个参数是如何赋值的？https://blog.csdn.net/m0_37899908/article/details/112502858?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-112502858-blog-52654023.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-3-112502858-blog-52654023.pc_relevant_multi_platform_whitelistv3
        //并行流
        System.out.println(list.stream().findAny().get());
        System.out.println(list.parallelStream().findAny().get());
        //规约
        //找到公司所有员工的薪资，求和
        System.out.println(list.stream().map(Employee::getSalary).reduce((d1, d2) -> (d1 + d2)).get());
        //收集collect  把最终的结果进行收集  统计
        //平均薪资
        System.out.println(list.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
        //static <T> Collector<T,?,List<T>> toList() 返回 Collector ，将输入元素累积到新的 List 。
        System.out.println(list.stream().filter(e -> e.getAge() >= 28).collect(Collectors.toList()));
        //static <T> Collector<T,?,Set<T>> toSet() 返回 Collector ，将输入元素累积到新的 Set 。
        System.out.println(list.stream().filter(e -> e.getAge() >= 28).collect(Collectors.toSet()));
        //返回键值对
        //Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper) 返回 Collector ，它将元素累积到 Map其键和值是将提供的映射函数应用于输入元素的结果。
        //需要先去重
        Map<String, Double> collect = list.stream().distinct().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(collect);
    }
}
