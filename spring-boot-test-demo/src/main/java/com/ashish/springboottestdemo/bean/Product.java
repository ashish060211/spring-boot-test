package com.ashish.springboottestdemo.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "PRODUCT", schema = "PCC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @EqualsAndHashCode.Include
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    /*@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "PRODUCT_ADMIN_ID", nullable = true)
    @JsonIgnore
    private ProductAdmin productAdmin;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<LegalEntity> legalEntities;*/

    public Product(Integer productId) {
        this.productId = productId;
    }
}
