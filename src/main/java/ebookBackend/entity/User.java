package ebookBackend.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.iden
     *
     * @mbggenerated
     */
    private String iden;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.ban
     *
     * @mbggenerated
     */
    private Boolean ban;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.mail
     *
     * @mbggenerated
     */
    private String mail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.cart
     *
     * @mbggenerated
     */
    private String cart;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.iden
     *
     * @return the value of users.iden
     *
     * @mbggenerated
     */
    public String getIden() {
        return iden;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.iden
     *
     * @param iden the value for users.iden
     *
     * @mbggenerated
     */
    public void setIden(String iden) {
        this.iden = iden == null ? null : iden.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.ban
     *
     * @return the value of users.ban
     *
     * @mbggenerated
     */
    public Boolean getBan() {
        return ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.ban
     *
     * @param ban the value for users.ban
     *
     * @mbggenerated
     */
    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.mail
     *
     * @return the value of users.mail
     *
     * @mbggenerated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.mail
     *
     * @param mail the value for users.mail
     *
     * @mbggenerated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.cart
     *
     * @return the value of users.cart
     *
     * @mbggenerated
     */
    public String getCart() {
        return cart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.cart
     *
     * @param cart the value for users.cart
     *
     * @mbggenerated
     */
    public void setCart(String cart) {
        this.cart = cart == null ? null : cart.trim();
    }
}