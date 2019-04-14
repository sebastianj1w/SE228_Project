package ebookBackend.RESTfulService.entity;


public class User {
    private String id;
    private String password;
    private String identity;
    private boolean ban;
    private String mail;

    public boolean isBan() {
        return ban;
    }

    public User() { }
    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String email) {
        this.mail = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getIdentity() { return identity; }

    public void setIdentity(String identity) { this.identity = identity; }

    public boolean getBan() { return ban; }

    public void setBan(boolean ban) { this.ban = ban; }
}
