package vn.vtcc.boitoan.model.api;

public class Info {
    private Integer code;
    private Data data;
    private String message;

    public Info(Integer code, Data data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }
}
