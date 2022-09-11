package practice;


import com.dsm.enums.Charactor;

/**
 * @author dengshuangmin<dengshuangmin @ kuaishou.com>
 * @creed: 开开心心每一天
 * @date 20220825
 **/
public class EnumTest {
    public static void main(String[] args) {
        if(Charactor.NOMAL.equals("平民")){
            System.out.println("jinlaile");
        }
        if(Charactor.NOMAL.getName().equals("平民")){
            System.out.println("jinlailegetName");
        }
        if(Charactor.NOMAL.name().equals("NOMAL")){
            System.out.println("jinlaileNOMAL");
        }
        if(Charactor.NOMAL.name().equals("平民")){
            System.out.println("获取name");
        }
        if(Charactor.NOMAL.equals(Charactor.NOMAL)){
            System.out.println("Enum比较");
        }
        if(Charactor.NOMAL.name().equals(Charactor.SPY.name())){
            System.out.println("Enum比较");
        }
        System.out.println("没进来:"+Charactor.NOMAL.name.getClass());
    }
}
