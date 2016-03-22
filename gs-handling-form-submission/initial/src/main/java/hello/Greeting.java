package hello;

public class Greeting {

    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
