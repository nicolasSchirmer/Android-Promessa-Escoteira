package gejapao.promessa.List;

public class itemRow {
    private int background;
    private int logoBack;
    private String title;

    public itemRow(int background, int logoBack, String title) {
        this.background = background;
        this.logoBack = logoBack;
        this.title = title;
    }

    public void setLogoBg(int imageId) {
        this.logoBack = imageId;
    }

    public int getLogobg() {
        return logoBack;
    }

    public void setBg(int imageId) {
        this.background = imageId;
    }

    public int getBg() {
        return background;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
