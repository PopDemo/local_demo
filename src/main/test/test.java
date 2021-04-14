import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class test {

    public static void main(String[] args) throws Exception {
        Logger log = LoggerFactory.getLogger(test.class);

        DateTimeFormatter outputDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String orderTimeStr = "2020-10-20T20:00:00";
        LocalDateTime orderTime = LocalDateTime.parse(orderTimeStr, outputDtf);
        LocalDateTime begingingOfDay = LocalDateTime.of(orderTime.toLocalDate(), LocalTime.MIN);
        LocalDateTime endingOfDay = LocalDateTime.of(orderTime.toLocalDate(), LocalTime.MAX);
        log.info("orderTime:{}  starttime:{}  endtime:{}", orderTime,begingingOfDay.format(outputDtf), endingOfDay.format(outputDtf));









        JSONObject json = new JSONObject();
        json.put("date","2020-10-27T00:00:00.000+0000");
//        new DateTime().format(json.getString("date"));





    }


}
