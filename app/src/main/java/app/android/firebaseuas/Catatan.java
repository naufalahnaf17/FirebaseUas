package app.android.firebaseuas;

public class Catatan {
    String id,judul,desc;

    public Catatan(String id, String judul, String desc) {
        this.id = id;
        this.judul = judul;
        this.desc = desc;
    }

    public Catatan(){}

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getDesc() {
        return desc;
    }
}
