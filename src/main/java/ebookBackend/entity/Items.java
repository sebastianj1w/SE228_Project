package ebookBackend.entity;

import java.math.BigDecimal;

public class Items {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_items.orderID
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_items.bookID
     *
     * @mbggenerated
     */
    private String bookid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_items.amount
     *
     * @mbggenerated
     */
    private Integer amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_items.value
     *
     * @mbggenerated
     */
    private BigDecimal value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_items.orderID
     *
     * @return the value of t_items.orderID
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_items.orderID
     *
     * @param orderid the value for t_items.orderID
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_items.bookID
     *
     * @return the value of t_items.bookID
     *
     * @mbggenerated
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_items.bookID
     *
     * @param bookid the value for t_items.bookID
     *
     * @mbggenerated
     */
    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_items.amount
     *
     * @return the value of t_items.amount
     *
     * @mbggenerated
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_items.amount
     *
     * @param amount the value for t_items.amount
     *
     * @mbggenerated
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_items.value
     *
     * @return the value of t_items.value
     *
     * @mbggenerated
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_items.value
     *
     * @param value the value for t_items.value
     *
     * @mbggenerated
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}