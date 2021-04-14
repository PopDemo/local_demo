package DtoClass;

/**
 * 更新对象DTO
 *
 * @Author yinyi
 * @Date 2018-08-02 15:37
 **/

public class ChangeDto {

    /**
     * 字段名称
     */
    private String fieldName;
    /**
     * 更新前
     */
    private String beforeValue;
    /**
     * 更新后
     */
    private String afterValue;
    /**
     * 备注
     */
    private String remark;
    public ChangeDto(){
        super();
    }

    public ChangeDto(String fieldName, String beforeValue, String afterValue, String remark) {
        this.fieldName = fieldName;
        this.beforeValue = beforeValue;
        this.afterValue = afterValue;
        this.remark = remark;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(String beforeValue) {
        this.beforeValue = beforeValue;
    }

    public String getAfterValue() {
        return afterValue;
    }

    public void setAfterValue(String afterValue) {
        this.afterValue = afterValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String
    toString() {
        return "ChangeDto{" +
                "fieldName='" + fieldName + '\'' +
                ", beforeValue='" + beforeValue + '\'' +
                ", afterValue='" + afterValue + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
