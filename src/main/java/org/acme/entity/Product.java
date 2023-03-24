package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product extends PanacheEntityBase {

    @Id
    private String id;

    private String nama_produk;

    private String deskripsi_produk;

    private Integer harga_produk;

    private Integer stok_produk;



    // setter & getter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public void setDeskripsi_produk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }

    public Integer getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(Integer harga_produk) {
        this.harga_produk = harga_produk;
    }

    public Integer getStok_produk() {
        return stok_produk;
    }

    public void setStok_produk(Integer stok_produk) {
        this.stok_produk = stok_produk;
    }


}
