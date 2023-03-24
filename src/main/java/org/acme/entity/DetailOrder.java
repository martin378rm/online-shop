package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "detail_order")
public class DetailOrder extends PanacheEntityBase {

    @Id
    private String id;

    @Column(name = "jumlah_product")
    private Integer jumlahProduct;

    @Column(name = "harga_product")
    private Integer hargaProduct;

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
