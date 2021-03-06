package ebookBackend.entity;

import java.math.BigDecimal;

public class Order {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.orderID
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.total
     *
     * @mbggenerated
     */
    private BigDecimal total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.userID
     *
     * @mbggenerated
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.date
     *
     * @mbggenerated
     */
    private BigDecimal date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.show
     *
     * @mbggenerated
     */
    private Integer show;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.orderID
     *
     * @return the value of orders.orderID
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.orderID
     *
     * @param orderid the value for orders.orderID
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.total
     *
     * @return the value of orders.total
     *
     * @mbggenerated
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.total
     *
     * @param total the value for orders.total
     *
     * @mbggenerated
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.userID
     *
     * @return the value of orders.userID
     *
     * @mbggenerated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.userID
     *
     * @param userid the value for orders.userID
     *
     * @mbggenerated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.state
     *
     * @return the value of orders.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.state
     *
     * @param state the value for orders.state
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.title
     *
     * @return the value of orders.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.title
     *
     * @param title the value for orders.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.date
     *
     * @return the value of orders.date
     *
     * @mbggenerated
     */
    public BigDecimal getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.date
     *
     * @param date the value for orders.date
     *
     * @mbggenerated
     */
    public void setDate(BigDecimal date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.show
     *
     * @return the value of orders.show
     *
     * @mbggenerated
     */
    public Integer getShow() {
        return show;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.show
     *
     * @param show the value for orders.show
     *
     * @mbggenerated
     */
    public void setShow(Integer show) {
        this.show = show;
    }
}