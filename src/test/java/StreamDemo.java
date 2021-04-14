import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(StreamDemo.class);
        List<String> list= Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println(list.stream().map(string -> string.equals("bc")).count());


        JSONObject json = new JSONObject();
        json.put("customDate2","2020-10-27T00:00:00.000+0000");


        // 初始化
        Instant instant = json.getDate("customDate2").toInstant();
        LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.of("GMT+00:00"));
        log.info("json GetDate To thisDate:{}",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(time));




    }


}
