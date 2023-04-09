package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;


@Entity
@Table(name = "detail_order")
public class DetailOrder extends PanacheEntityBase {

    @Id
    private String id;

    @Column(name = "jumlah_product")
    private Integer jumlahProduct;

    @Column(name = "harga_product")
    private Integer hargaProduct;




    @JsonBackReference
    @OneToOne
    Order orders;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getJumlahProduct() {
        return jumlahProduct;
    }

    public void setJumlahProduct(Integer jumlahProduct) {
        this.jumlahProduct = jumlahProduct;
    }

    public Integer getHargaProduct() {
        return hargaProduct;
    }

    public void setHargaProduct(Integer hargaProduct) {
        this.hargaProduct = hargaProduct;
    }
}
