package ebookBackend.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.iden
     *
     * @mbggenerated
     */
    private String iden;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.ban
     *
     * @mbggenerated
     */
    private Boolean ban;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.mail
     *
     * @mbggenerated
     */
    private String mail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.id
     *
     * @return the value of t_userinfo.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.id
     *
     * @param id the value for t_userinfo.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.iden
     *
     * @return the value of t_userinfo.iden
     *
     * @mbggenerated
     */
    public String getIden() {
        return iden;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.iden
     *
     * @param iden the value for t_userinfo.iden
     *
     * @mbggenerated
     */
    public void setIden(String iden) {
        this.iden = iden == null ? null : iden.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.password
     *
     * @return the value of t_userinfo.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.password
     *
     * @param password the value for t_userinfo.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.ban
     *
     * @return the value of t_userinfo.ban
     *
     * @mbggenerated
     */
    public Boolean getBan() {
        return ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.ban
     *
     * @param ban the value for t_userinfo.ban
     *
     * @mbggenerated
     */
    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.mail
     *
     * @return the value of t_userinfo.mail
     *
     * @mbggenerated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.mail
     *
     * @param mail the value for t_userinfo.mail
     *
     * @mbggenerated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }
}