package vn.vtcc.boitoan.model.api;

public class Param {
    private String param;
    private String type;
    public String getParam() {
        return param;
    }

    public Param(String param, String type) {
        this.param = param;
        this.type = type;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
