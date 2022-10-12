package com.dsm.lambad8;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.10.08
 **/
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
class Main {
    /**
     * 枚举类型的使用：
     * https://blog.csdn.net/qq_27093465/article/details/52180865
     * lamba8表达式：
     * https://www.runoob.com/java/java8-lambda-expressions.html
     * 深入浅出Java虚拟机——JVM高级特性与最佳事件
     * 1.需要学会使用java性能监控和g故障处理工具的使用
     * 2.类加载机制，深入了解sandBox使用原理
     * https://blog.csdn.net/weixin_51435009/article/details/123707616?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-123707616-blog-108448810.t0_edu_mix&spm=1001.2101.3001.4242.1&utm_relevant_index=3
     * */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        List<Integer> squaresList = numbers.stream()
                //参数是每一条数据，映射成一个新的结果返回，最后返回一个持有所以映射后的新的结果的流
                .map(i -> i * i) //map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数;
                //排序  sorted() --> 内部比较器
                //     sorted(Comparator) -->外部比较器
                .sorted((x, y) -> y - x)
                .collect(Collectors.toList());
//        squaresList.forEach(System.out::println);
        squaresList.forEach(num -> {
//            num++;
            System.out.println(num);
        });




//
//        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
//        Map<Integer, String> strMap = new HashMap<Integer, String>();
//
//        strMap = strList.stream()
//                .collect( Collectors.toMap( str -> strList.indexOf(str), str -> str ) );
//
//        strMap.forEach((key, value) -> {
//            System.out.println(key+"::"+value);
//        });

    }
}