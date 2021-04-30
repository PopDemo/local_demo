import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * 读取订单id第一位是否是数字，如果是数据，前缀添加 确实 addStrChannel 渠道
 */
public class PatternDemo {
    private static  Logger log = LoggerFactory.getLogger(PatternDemo.class);
    private final static String addStrChannel = "taobao_";
    private final static String num_pattern = "-?[1-9]\\d*";

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\MI\\Desktop\\orderIdResource");
        File[] fileList = file.listFiles();
        for (File thisFile : fileList) {
            //获取thisFile的    文件名
            String fileName = thisFile.getName();
            //获取thisFile的    绝对路径
            String absoluteFileName = thisFile.getAbsolutePath();

            if (fileName.contains("OUT")) continue;

            String outName = absoluteFileName.substring(0,absoluteFileName.length()-4)+"_OUT.csv";
            log.info("读取FileName:{},outFileName:{}",fileList,outName);
            handleTaobaoOrderId(absoluteFileName,outName);
        }
        
        
       
    }
    
    public static void handleTaobaoOrderId(String oldFileName, String outFileName) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(oldFileName)));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName)));
        Pattern r = Pattern.compile(num_pattern);

        String line = "";
        AtomicInteger countHandle = new AtomicInteger();
        AtomicInteger tbcountHandle = new AtomicInteger();

        while (null != (line = reader.readLine())){
            String outline = line;
            String index0 = line.substring(0,1);

            if (r.matcher(index0).matches()){
                tbcountHandle.getAndIncrement();
                outline = addStrChannel+line;
                log.info("this line str[0]:{},update line str[0++]:{}",line,outline);
            }

            writer.write(outline);
            writer.write("\n");
            writer.flush();
            countHandle.getAndIncrement();
            if (0 == countHandle.get() % 2000){
               log.info("当前已经修复了:{}个订单,处理了:{}",tbcountHandle.get(),countHandle.get());
            }
        }
        writer.close();

        log.info("修复订单id全部完成,修复量：{},总量：{}",tbcountHandle.get(),countHandle.get());

        
        
    }









}
