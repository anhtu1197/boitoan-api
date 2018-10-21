package vn.vtcc.boitoan.model;

/**
 * Created by TuanAnh on 22/02/2018.
 */


public class Que {
    private int id;
    private String loiGiai;
    private String imageURL;
    private String tenQue;

    public Que(int id, String loiGiai, String imageURL, String tenQue) {
        this.id = id;
        this.loiGiai = loiGiai;
        this.imageURL = imageURL;
        this.tenQue = tenQue;
    }

    public Que() {

    }

    public String getTenQue() {
        return tenQue;
    }

    public void setTenQue(String tenQue) {
        this.tenQue = tenQue;
    }

    public String getLoiGiai() {
        return loiGiai;
    }

    public void setLoiGiai(String loiGiai) {
        this.loiGiai = loiGiai;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
