package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product extends PanacheEntityBase {

    @Id
    private String id;

    @Column(name = "nama_produk")
    private String namaProduk;

    @Column(name = "deskripsi_produk")
    private String deskripsiProduk;

    @Column(name = "harga_produk")
    private Integer hargaProduk;

    @Column(name = "stok_produk")
    private Integer stokProduk;



    // setter & getter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }

    public void setDeskripsiProduk(String deskripsiProduk) {
        this.deskripsiProduk = deskripsiProduk;
    }

    public Integer getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(Integer hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public Integer getStokProduk() {
        return stokProduk;
    }

    public void setStokProduk(Integer stokProduk) {
        this.stokProduk = stokProduk;
    }
}
