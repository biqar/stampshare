package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/7/13
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "exchange_policy_info")
public class ExchangePolicy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchange_policy_id")
    private Integer id;

    @Column(name = "exchange_policy_name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "exchange_policy_stamp",
            joinColumns = {@JoinColumn(name = "exchange_policy_id")},
            inverseJoinColumns = {@JoinColumn(name = "stamp_id")})
    List<Stamp> stampList = new ArrayList<Stamp>();

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

    public List<Stamp> getStampList() {
        return stampList;
    }

    public void setStampList(List<Stamp> stampList) {
        this.stampList = stampList;
    }
}
