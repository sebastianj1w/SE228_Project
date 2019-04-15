package ebookBackend.entity;

public class BookDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bookDetail.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bookDetail.rate
     *
     * @mbggenerated
     */
    private Double rate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bookDetail.publishDate
     *
     * @mbggenerated
     */
    private String publishdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bookDetail.words
     *
     * @mbggenerated
     */
    private Double words;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bookDetail.abstraction
     *
     * @mbggenerated
     */
    private String abstraction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bookDetail.catalogue
     *
     * @mbggenerated
     */
    private String catalogue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bookDetail.ID
     *
     * @return the value of bookDetail.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bookDetail.ID
     *
     * @param id the value for bookDetail.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bookDetail.rate
     *
     * @return the value of bookDetail.rate
     *
     * @mbggenerated
     */
    public Double getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bookDetail.rate
     *
     * @param rate the value for bookDetail.rate
     *
     * @mbggenerated
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bookDetail.publishDate
     *
     * @return the value of bookDetail.publishDate
     *
     * @mbggenerated
     */
    public String getPublishdate() {
        return publishdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bookDetail.publishDate
     *
     * @param publishdate the value for bookDetail.publishDate
     *
     * @mbggenerated
     */
    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate == null ? null : publishdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bookDetail.words
     *
     * @return the value of bookDetail.words
     *
     * @mbggenerated
     */
    public Double getWords() {
        return words;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bookDetail.words
     *
     * @param words the value for bookDetail.words
     *
     * @mbggenerated
     */
    public void setWords(Double words) {
        this.words = words;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bookDetail.abstraction
     *
     * @return the value of bookDetail.abstraction
     *
     * @mbggenerated
     */
    public String getAbstraction() {
        return abstraction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bookDetail.abstraction
     *
     * @param abstraction the value for bookDetail.abstraction
     *
     * @mbggenerated
     */
    public void setAbstraction(String abstraction) {
        this.abstraction = abstraction == null ? null : abstraction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bookDetail.catalogue
     *
     * @return the value of bookDetail.catalogue
     *
     * @mbggenerated
     */
    public String getCatalogue() {
        return catalogue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bookDetail.catalogue
     *
     * @param catalogue the value for bookDetail.catalogue
     *
     * @mbggenerated
     */
    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue == null ? null : catalogue.trim();
    }
}