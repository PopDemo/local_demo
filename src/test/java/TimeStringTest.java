import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class TimeStringTest {

    public static void main(String[] args) {
        String yearStr = String.valueOf(LocalDate.now().getYear());
        String total = String.valueOf(LocalDate.now().getYear()).substring(3);
        log.info("YearStr:{},totalYear:{}",yearStr,total);
    }
}
