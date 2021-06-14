package cn.local.support;

import cn.local.dto.ResponseSupportDTO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResponseExcuteService<T> {

    public ResponseSupportDTO<T> success(T data){
        ResponseSupportDTO<T> responseSupportDTOM = new ResponseSupportDTO<>();
        responseSupportDTOM.setCode("200");
        responseSupportDTOM.setData(data);

        return  responseSupportDTOM;
    }


}
