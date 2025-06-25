package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;
import java.sql.Date;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {
    public Division() {
    }

    public Division(Long id, String division_name) {
        this.id = id;
        this.division_name = division_name;
    }

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;

    //FetchType.Lazy, and "nullable=false, insertable=false, updatable=false"
    //allows us to have more than one column named "country_id" in this file
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable=false, insertable=false, updatable=false)
    private Country country;

    //columns
    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "country_id")
    private Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }


}
