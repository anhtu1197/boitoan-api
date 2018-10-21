package vn.vtcc.boitoan.model;

public class Bai {
    private int id;
    private String imageURL;
    private String result;

    public Bai(int id, String imageURL, String result) {
        this.id = id;
        this.imageURL = imageURL;
        this.result = result;
    }

    public Bai() {
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


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
