package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class Order extends PanacheEntityBase {

    private String id;
    private LocalDateTime tanggalPesanan;
    private String totalHargaPesanan;
    private String statusPesanan;


    @JsonBackReference
    @OneToOne
    User users;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTanggalPesanan() {
        return tanggalPesanan;
    }

    public void setTanggalPesanan(LocalDateTime tanggalPesanan) {
        this.tanggalPesanan = tanggalPesanan;
    }

    public String getTotalHargaPesanan() {
        return totalHargaPesanan;
    }

    public void setTotalHargaPesanan(String totalHargaPesanan) {
        this.totalHargaPesanan = totalHargaPesanan;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }
}
