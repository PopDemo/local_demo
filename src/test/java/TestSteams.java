

import DtoClass.ChangeDto;
import DtoClass.DemoClass;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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

//    public static synchronized String genUniqueKey(){
//
//        Random random = new Random(7);
//
//        Integer number = random.nextInt(900000) + 100000;
//
//        return (System.currentTimeMillis() + String.valueOf(number));
//    }
//
//
//    private static int totalCount = 0;
//
//    public static class Customer{
//        private int customerID;
//
//        public Customer(){
//            ++totalCount;
//            customerID = totalCount;
//            System.out.println("增加一个");
//        }
//
//        public String getCustomerID() {
//            DecimalFormat decimalFormat = new DecimalFormat("0000000");
//            return decimalFormat.format(customerID);
//        }
//
//    }

    private static Logger log = LoggerFactory.getLogger(TestSteams.class);
        // 开头2位 年
        private static final String total0_2 =  String.valueOf(LocalDate.now().getYear()).substring(2);
    // 中间7位 自增列
    private static AtomicInteger total2_7_Count = new AtomicInteger(0);
    // 四位暗码 -> 存储
    private static String total7_11 = "";
    private static DecimalFormat decimalFormat = new DecimalFormat("0000000");





    /**
     * 获取纸质券券码
     * @param prodectId
     * @return
     */
    public static String getCouponId(String prodectId){
        StringBuffer couponId = new StringBuffer();
        total2_7_Count.getAndIncrement();
        couponId.append(total0_2).append(decimalFormat.format(total2_7_Count.get())).append(total7_11);
        log.warn("生成纸质券券码0-2区间 -> {},2-7区间count+1 -> {},对应prodectId -> {}生成完整券码为 -> {}",total0_2,decimalFormat.format(total2_7_Count.get()),prodectId,couponId.toString());
        return couponId.toString();
    }


    public static void main(String[] args) {
//        String uniqueKey = genUniqueKey();
//        System.out.println(uniqueKey);
//
//        AtomicLong nowSyn = new AtomicLong();
//        nowSyn.getAndAdd(System.currentTimeMillis());

//        for (int i = 0; i < 1 << 12; i++) {
//            Customer customer =  new Customer();
//            System.out.println(customer.getCustomerID());
//        }
//        for (int i = 0; i < 1 << 12; i++) {
//            log.info(TestSteams.getCouponId("001"));
//        }


//        DecimalFormat decimalFormat4 = new DecimalFormat("0000");
//
//        String num = "21";
//
//        log.info(decimalFormat4.format(Integer.valueOf(num)));


//
//        System.out.print("{");
//        for (int i=0;i<=26;i++) {
//
//            System.out.print("\""+randomNum01+"\":"+"\""+String.valueOf((char)(Lower+i))+"\",");
//            System.out.print("\""+randomNum02+"\":"+"\""+String.valueOf((char)(Upper+i))+"\",");
//
//        }
//        System.out.print("}");


        Map<String,String> ascll_Num = new HashMap<>();

        char Lower = 'a';
        char Upper = 'A';

        for (int i = 10; i < 30; i++) {
            System.out.println(i);
            ascll_Num.put(String.valueOf(i), String.valueOf((char)(Lower+i)));
            if (i > 24) return;
        }
        log.info("map:{}",ascll_Num.size());
        System.out.println(ascll_Num.size());

        for (int j = 40; j < 70; j++) {

            ascll_Num.put(String.valueOf(j), String.valueOf((char)(Upper+j)));
            if (j > 24) return;
        }

        log.info("map:{}",ascll_Num.size());


    }

    public void printLowerCase () {
        char c = 'a';
        for (int i=0;i<26;i++) {
            System.out.print((char)(c+i)+" ");
        }
    }

    public void printUpperCase () {
        char c = 'A';
        for (int i=0;i<26;i++) {
            System.out.print((char)(c+i)+" ");
        }
    }





}
