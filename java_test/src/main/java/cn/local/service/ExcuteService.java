package cn.local.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExcuteService {
    public <T> void getDataClass(T dataModel){
        if (dataModel instanceof String){
            log.info("该类型为String类");
        }
        if (dataModel instanceof Integer){
            log.info("该类型为Integer类");
        }
        if (dataModel instanceof Boolean){
            log.info("该类型为Boolean类");
        }
        log.info("instanceof  end;");
    }



}
