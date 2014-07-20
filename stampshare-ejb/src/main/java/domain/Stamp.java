package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "stamp_info")
public class Stamp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stamp_id")
    private Integer id;

    @Column(name = "stamp_name", nullable = false)
    private String name;

    @Column(name = "stamp_year", nullable = false)
    private Integer year;

    @Column(name = "stamp_count", nullable = false)
    private Integer count;

    @Column(name = "stamp_rating", nullable = false)
    private Double rating;

    @Column(name = "stamp_image", nullable = false)
    @Lob
    private byte[] imageData;

    @Column(name = "stamp_adddate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date addDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    @ManyToOne(cascade = CascadeType.ALL)
    private ExchangePolicy exchangePolicy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "stamp_comment",
            joinColumns = {@JoinColumn(name = "stamp_id")},
            inverseJoinColumns = {@JoinColumn(name = "comment_id")})
    List<Comment> commentList = new ArrayList<Comment>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "stamp_request",
            joinColumns = {@JoinColumn(name = "stamp_id")},
            inverseJoinColumns = {@JoinColumn(name = "request_id")})
    List<Request> requestList = new ArrayList<Request>();

    public Stamp() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ExchangePolicy getExchangePolicy() {
        return exchangePolicy;
    }

    public void setExchangePolicy(ExchangePolicy exchangePolicy) {
        this.exchangePolicy = exchangePolicy;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }
}
