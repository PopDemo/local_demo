package cn.local.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSupportDTO<T> {

    private String code;
    private T data;

    public ResponseSupportDTO(){}

    public  ResponseSupportDTO(String code,T data){
        this.code=code;
        this.data=data;
    }

    @Override
    public String toString() {
        return "Lazy Man Response Data -> {" +
                "code='" + code + '\'' +
                ", data=" + JSONObject.toJSONString(data) +
                '}';
    }
}
