package redis;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 2022.10.08
 **/
public class Main {
    public static void main(String[] args) {
        //Redis Zcard 命令
        //https://www.runoob.com/redis/sorted-sets-zcard.html
        //当 key 存在且是有序集类型时，返回有序集的基数。 当 key 不存在时，返回 0 。
        //Redisscan:https://www.linuxe.cn/post-548.html
        //redis的client驱动lettuce使用lambad：https://vimsky.com/examples/detail/java-class-com.lambdaworks.redis.ScoredValue.html
        //https://blog.csdn.net/Aplumage/article/details/118312200
        //总结一下：redis使用C语言开发的一个Key-Value数据库【即远程字典服务】，通过命令方式获取数据
        //可以通过Java开发的redis客户端lettuce操作命令行
        //具体的命令可以通过百度查到
        //需要注意redis中的scan命令、zcard命令、zcount命令、写数据的set
        //redis的score排序：http://www.caotama.com/1236548.html
        //读取zadd数据：https://www.redis.com.cn/commands/zadd.html

    }
}
