package cz.etn.etnshop.dao;

import org.hibernate.search.annotations.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Indexed
public class Product implements Serializable {

    private static final long serialVersionUID = -2739622030641073946L;

    private int id;
    private String name;
    private Long serialNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "serial_number")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    public Long getSerialNumber() { return serialNumber; }
    public void setSerialNumber(Long serialNumber) { this.serialNumber = serialNumber; }
}
