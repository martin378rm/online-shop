package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order extends PanacheEntityBase {

    @Id
    private String id;
    private LocalDateTime tanggalPesanan;
    private String totalHargaPesanan;
    private String statusPesanan;


    @JsonBackReference
    @OneToOne
    User users;

    @JsonManagedReference
    @OneToOne(mappedBy = "orders", fetch = FetchType.EAGER)
    DetailOrder detailOrder;


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
