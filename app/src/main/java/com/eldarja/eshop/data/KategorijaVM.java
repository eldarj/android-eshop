package com.eldarja.eshop.data;

import java.io.Serializable;

public class KategorijaVM implements Serializable {
    public Integer id;
    public String naziv;

    public KategorijaVM(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
