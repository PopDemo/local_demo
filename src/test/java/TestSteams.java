

import DtoClass.ChangeDto;
import DtoClass.DemoClass;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.SystemUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 * Y_PoP
 *
 * @author 帆哥哥
 * @create 2020/8/14
 * @since 1.0.0
 */

public class TestSteams {



//    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add(222);
//        list.add(12);
//        list.add(2222);
//        list.add(21622);
//        list.add(2122);





//        list.add(2252);
//        list.add(2322);
//        // Optional.ofNullable-->如果逻辑体里面返回的为null就只进行为null容器，如果不为空则为数据
//        // Optional.ifPresent是进行判断如果为空就返回ture   不为空就返回true
//        Optional.ofNullable(list.stream().map(s -> s.equals("222"))).ifPresent(s -> System.out.println(s.toString()));
//
//        Optional.ofNullable(list.stream().filter(s -> s.equals("ss"))).isPresent( s ->{} );
//
//        String s = list.stream().filter(s -> s.equals("Abyss")).findFirst().orElse(null);


//        DemoClass demoClass = new DemoClass();
//
//        demoClass.setDemos("qwertyuiopasdfghjklzxc");
//
//        if (demoClass.getDemos().length() <= 19) {
//            System.out.println("12312313");
//            System.out.println(demoClass.getDemos());
//        }else {
//            demoClass.setDemos(demoClass.getDemos().substring(0,19));
//            System.out.println(demoClass.getDemos().substring(0,19));
//        }
//
//        if (demoClass.getDemos().length() <= 19){
//            System.out.println("截取成功");
//        }
//
//
//        System.out.println("qwertyuiopasdfghjkl".length());

        /**
         * 1.初始化实体容器
         * 2.伪代码模仿从db中查找出来的数据
         * 3.返回的是list
         */
//        DemoClass demo = null;
//
//
//
//        demo.setDemos("0");
//        demo.setDemos1("1");
//        demo.setDemos2("2");
//
//        List<DemoClass> list = new ArrayList<>();
//        list.add(demo);
//
//
//        // 我们将查询出来的list转换为实体类型
//        DemoClass queryDemo = list.get(0);
//
//
//        System.out.println(queryDemo.getDemos());

//    }

    public static synchronized String genUniqueKey(){

        Random random = new Random(7);

        Integer number = random.nextInt(900000) + 100000;

        return (System.currentTimeMillis() + String.valueOf(number));
    }

    public static void main(String[] args) {
        String uniqueKey = genUniqueKey();
        System.out.println(uniqueKey);

        AtomicLong nowSyn = new AtomicLong();
        nowSyn.getAndAdd(System.currentTimeMillis());





    }


}
