package cn.demo.support;


public enum TopicEnum {


    TEST_TOPIC("test","测试topicName");

    private String code;

    private String msg;


    TopicEnum(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }
}
