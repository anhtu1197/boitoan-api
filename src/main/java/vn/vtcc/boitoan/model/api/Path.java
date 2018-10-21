package vn.vtcc.boitoan.model.api;

import java.util.List;

public class Path {
    private String path;
    private String method;
    private String description;
    private List<Param> params = null;

    public Path(String path, String method, String description, List<Param> params) {
        this.path = path;
        this.method = method;
        this.description = description;
        this.params = params;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

}
