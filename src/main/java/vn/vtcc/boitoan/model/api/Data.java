package vn.vtcc.boitoan.model.api;

import java.util.List;

public class Data {
    private String host;
    private String basePath;
    private List<Path> paths = null;

    public Data(String host, String basePath, List<Path> paths) {
        this.host = host;
        this.basePath = basePath;
        this.paths = paths;
    }

    public Data() {

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

}
