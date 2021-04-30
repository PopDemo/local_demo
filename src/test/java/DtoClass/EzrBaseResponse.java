package DtoClass;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description Ezr系统级返回结果
 * @Author WQ
 * @Date 2020/4/28 18:39
 **/
@Data
public class EzrBaseResponse<T> implements Serializable {
    /**
     * 状态
     */
    private Boolean Status;
    /**
     * 状态码
     */
    private Integer StatusCode;
    /**
     * 返回信息
     */
    private String Msg;
    /**
     * 请求时间戳
     */
    private String Timestamp;
    /**
     * 签名
     */
    private String Sign;
    /**
     * 返回结果集
     */
    private T Result;


    private String getMag(){
        return this.Msg;
    }

    private void setMag(String Msg){
        this.Msg=Msg;
    }

}
